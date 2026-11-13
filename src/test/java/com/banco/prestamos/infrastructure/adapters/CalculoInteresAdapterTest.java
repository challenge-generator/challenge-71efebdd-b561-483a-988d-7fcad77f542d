package com.banco.prestamos.infrastructure.adapters;

import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Disabled("Superficie de práctica - el candidato debe implementar los tests")
@ExtendWith(MockitoExtension.class)
class CalculoInteresAdapterTest implements CalculoInteresPort {

    @Mock
    private Prestamo prestamo;

    @InjectMocks
    private CalculoInteresAdapter calculoInteresAdapter;

    @Test
    void calcularInteresSimple_deberiaDelegarAlServicio() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When
        BigDecimal resultado = calculoInteresAdapter.calcularInteresSimple(capital, tasa, dias);

        // Then
        assertNotNull(resultado);
    }

    @Test
    void calcularInteresCompuesto_deberiaDelegarAlServicio() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When
        BigDecimal resultado = calculoInteresAdapter.calcularInteresCompuesto(capital, tasa, periodos);

        // Then
        assertNotNull(resultado);
    }

    @Test
    void calcularInteresSimple_conParametrosInvalidos_deberiaLanzarExcepcion() {
        // Given
        BigDecimal capital = new BigDecimal("-1000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calculoInteresAdapter.calcularInteresSimple(capital, tasa, dias)
        );
    }

    @Test
    void calcularInteresCompuesto_conParametrosInvalidos_deberiaLanzarExcepcion() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("-0.05");
        int periodos = 12;

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calculoInteresAdapter.calcularInteresCompuesto(capital, tasa, periodos)
        );
    }

    @Override
    public BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        return BigDecimal.ZERO;
    }
}