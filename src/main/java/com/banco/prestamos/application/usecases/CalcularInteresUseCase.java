package com.banco.prestamos.application.usecases;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CalcularInteresUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CalcularInteresUseCase.class);
    private final CalculoInteresPort calculoInteresPort;

    public CalcularInteresUseCase(CalculoInteresPort calculoInteresPort) {
        if (calculoInteresPort == null) {
            throw new IllegalArgumentException("El puerto de cálculo de interés no puede ser nulo");
        }
        this.calculoInteresPort = calculoInteresPort;
    }

    public Interes ejecutar(Prestamo prestamo) {
        logger.info("Iniciando cálculo de interés para préstamo: {}", prestamo.getId());
        
        validarPrestamo(prestamo);
        
        BigDecimal montoInteres = calculoInteresPort.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            calcularDiasTranscurridos(prestamo)
        );
        
        Interes interes = new Interes(
            prestamo,
            montoInteres,
            LocalDate.now()
        );
        
        logger.info("Interés calculado exitosamente para préstamo {}: {}", prestamo.getId(), montoInteres);
        return interes;
    }

    public BigDecimal calcularInteresSimple(Prestamo prestamo, long dias) {
        logger.debug("Calculando interés simple para préstamo {} con {} días", prestamo.getId(), dias);
        return calculoInteresPort.calcularInteresSimple(prestamo.getMonto(), prestamo.getTasaInteres(), dias);
    }

    public BigDecimal calcularInteresCompuesto(Prestamo prestamo, int periodos) {
        logger.debug("Calculando interés compuesto para préstamo {} con {} períodos", prestamo.getId(), periodos);
        return calculoInteresPort.calcularInteresCompuesto(prestamo.getMonto(), prestamo.getTasaInteres(), periodos);
    }

    public BigDecimal calcularTotalAPagar(Prestamo prestamo) {
        logger.info("Calculando total a pagar para préstamo: {}", prestamo.getId());
        validarPrestamo(prestamo);
        
        Interes interes = ejecutar(prestamo);
        BigDecimal total = prestamo.getMonto().add(interes.getMontoInteres());
        
        logger.info("Total a pagar para préstamo {}: {}", prestamo.getId(), total);
        return total;
    }

    private void validarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            logger.error("Préstamo nulo proporcionado");
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        if (prestamo.getMonto() == null || prestamo.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Monto inválido para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("El monto del préstamo debe ser mayor que cero");
        }
        if (prestamo.getTasaInteres() == null || prestamo.getTasaInteres().compareTo(BigDecimal.ZERO) < 0) {
            logger.error("Tasa de interés inválida para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        if (prestamo.getFechaInicio() == null) {
            logger.error("Fecha de inicio nula para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("La fecha de inicio del préstamo no puede ser nula");
        }
    }

    private long calcularDiasTranscurridos(Prestamo prestamo) {
        LocalDate fechaInicio = prestamo.getFechaInicio();
        LocalDate fechaActual = LocalDate.now();
        
        if (fechaInicio.isAfter(fechaActual)) {
            logger.warn("La fecha de inicio {} es posterior a la fecha actual {}", fechaInicio, fechaActual);
            return 0;
        }
        
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaActual);
        logger.debug("Días transcurridos desde {} hasta {}: {}", fechaInicio, fechaActual, dias);
        return dias;
    }

    public Interes calcularInteresParaFecha(Prestamo prestamo, LocalDate fechaCalculo) {
        logger.info("Calculando interés para préstamo {} en fecha {}", prestamo.getId(), fechaCalculo);
        
        validarPrestamo(prestamo);
        
        if (fechaCalculo == null) {
            fechaCalculo = LocalDate.now();
        }
        
        if (fechaCalculo.isBefore(prestamo.getFechaInicio())) {
            logger.error("Fecha de cálculo {} anterior a fecha de inicio {} del préstamo", 
                fechaCalculo, prestamo.getFechaInicio());
            throw new IllegalArgumentException("La fecha de cálculo no puede ser anterior a la fecha de inicio del préstamo");
        }
        
        long dias = java.time.temporal.ChronoUnit.DAYS.between(prestamo.getFechaInicio(), fechaCalculo);
        BigDecimal montoInteres = calculoInteresPort.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            dias
        );
        
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    public BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual) {
        logger.debug("Calculando interés diario para capital={}, tasaAnual={}", capital, tasaAnual);
        return calculoInteresPort.calcularInteresDiario(capital, tasaAnual);
    }

    public BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual) {
        logger.debug("Calculando interés mensual para capital={}, tasaAnual={}", capital, tasaAnual);
        return calculoInteresPort.calcularInteresMensual(capital, tasaAnual);
    }
}