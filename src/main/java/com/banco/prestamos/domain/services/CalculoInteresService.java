package com.banco.prestamos.domain.services;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculoInteresService implements CalculoInteresPort {

    private static final Logger logger = LoggerFactory.getLogger(CalculoInteresService.class);
    private static final int ESCALA_DECIMAL = 10;
    private static final int DIAS_POR_ANO = 365;
    private static final int MESES_POR_ANO = 12;

    public CalculoInteresService() {
    }

    @Override
    public BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        if (capital == null || capital.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor que cero");
        }
        if (tasa == null || tasa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa no puede ser negativa");
        }
        if (dias < 0) {
            throw new IllegalArgumentException("Los días no pueden ser negativos");
        }
        
        logger.debug("Calculando interés simple para capital={}, tasa={}, dias={}", capital, tasa, dias);
        BigDecimal resultado = Interes.calcularInteresSimple(capital, tasa, dias);
        logger.info("Interés simple calculado: {}", resultado);
        return resultado.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        if (capital == null || capital.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor que cero");
        }
        if (tasa == null || tasa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa no puede ser negativa");
        }
        if (periodos <= 0) {
            throw new IllegalArgumentException("Los períodos deben ser mayores que cero");
        }
        
        logger.debug("Calculando interés compuesto para capital={}, tasa={}, periodos={}", capital, tasa, periodos);
        BigDecimal resultado = Interes.calcularInteresCompuesto(capital, tasa, periodos);
        logger.info("Interés compuesto calculado: {}", resultado);
        return resultado.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual) {
        if (capital == null || tasaAnual == null) {
            throw new IllegalArgumentException("El capital y la tasa no pueden ser nulos");
        }
        
        BigDecimal tasaDiaria = tasaAnual.divide(BigDecimal.valueOf(DIAS_POR_ANO), ESCALA_DECIMAL, RoundingMode.HALF_UP);
        logger.debug("Tasa diaria calculada: {}", tasaDiaria);
        
        return capital.multiply(tasaDiaria).setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual) {
        if (capital == null || tasaAnual == null) {
            throw new IllegalArgumentException("El capital y la tasa no pueden ser nulos");
        }
        
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(MESES_POR_ANO), ESCALA_DECIMAL, RoundingMode.HALF_UP);
        logger.debug("Tasa mensual calculada: {}", tasaMensual);
        
        return capital.multiply(tasaMensual).setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularInteresPorPeriodo(Prestamo prestamo, LocalDate fechaCalculo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        if (fechaCalculo == null) {
            fechaCalculo = LocalDate.now();
        }
        
        long diasTranscurridos = ChronoUnit.DAYS.between(prestamo.getFechaInicio(), fechaCalculo);
        if (diasTranscurridos < 0) {
            throw new IllegalArgumentException("La fecha de cálculo no puede ser anterior a la fecha de inicio del préstamo");
        }
        
        logger.info("Calculando interés para préstamo {} con {} días transcurridos", prestamo.getId(), diasTranscurridos);
        return calcularInteresSimple(prestamo.getMonto(), prestamo.getTasaInteres(), diasTranscurridos);
    }

    public BigDecimal calcularTotalAPagar(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        
        BigDecimal intereses = calcularInteresPorPeriodo(prestamo, LocalDate.now());
        BigDecimal total = prestamo.getMonto().add(intereses);
        logger.info("Total a pagar calculado para préstamo {}: {}", prestamo.getId(), total);
        return total.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }
}