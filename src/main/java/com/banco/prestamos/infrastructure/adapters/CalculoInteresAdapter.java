package com.banco.prestamos.infrastructure.adapters;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import com.banco.prestamos.domain.services.CalculoInteresService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class CalculoInteresAdapter implements CalculoInteresPort {

    private final CalculoInteresService calculoInteresService;

    public CalculoInteresAdapter(CalculoInteresService calculoInteresService) {
        this.calculoInteresService = calculoInteresService;
    }

    @Override
    public Interes calcularInteresSimple(Prestamo prestamo, LocalDate fechaCalculo) {
        BigDecimal montoInteres = calculoInteresService.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            calcularDiasEntreFechas(prestamo.getFechaInicio(), fechaCalculo)
        );
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    @Override
    public Interes calcularInteresCompuesto(Prestamo prestamo, LocalDate fechaCalculo, int periodos) {
        BigDecimal montoInteres = calculoInteresService.calcularInteresCompuesto(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            periodos
        );
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    @Override
    public BigDecimal calcularInteresTotal(Prestamo prestamo) {
        long diasTotales = calcularDiasEntreFechas(
            prestamo.getFechaInicio(),
            prestamo.getFechaVencimiento()
        );
        return calculoInteresService.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            diasTotales
        );
    }

    private long calcularDiasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }
}