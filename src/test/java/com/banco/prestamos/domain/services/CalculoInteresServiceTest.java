package com.banco.prestamos.domain.services;

import com.banco.prestamos.domain.model.Cliente;
import com.banco.prestamos.domain.model.Prestamo;
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
import static org.mockito.Mockito.*;

@Disabled("Superficie de práctica - el candidato debe implementar los tests")
@ExtendWith(MockitoExtension.class)
class CalculoInteresServiceTest {

    @Mock
    private Cliente cliente;

    @Mock
    private Prestamo prestamo;

    @InjectMocks
    private CalculoInteresService calculoInteresService;

    @Test
    void calcularInteresSimple_deberiaRetornarMontoCorrecto() {
        // Given: un capital de 10000 y tasa del 5% anual para 365 días
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When: se calcula el interés simple
        BigDecimal resultado = CalculoInteresService.calcularInteresSimple(capital, tasa, dias);

        // Then: el resultado debe ser 500
        assertNotNull(resultado);
        // TODO: implementar assertions
    }

    @Test
    void calcularInteresCompuesto_deberiaRetornarMontoCorrecto() {
        // Given: un capital de 10000 con tasa del 5% y 12 períodos
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When: se calcula el interés compuesto
        BigDecimal resultado = CalculoInteresService.calcularInteresCompuesto(capital, tasa, periodos);

        // Then: verificar el resultado esperado
        assertNotNull(resultado);
        // TODO: implementar assertions
    }

    @Test
    void calcularInteresSimple_conMontoCero_deberiaRetornarCero() {
        // Given
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When
        BigDecimal resultado = CalculoInteresService.calcularInteresSimple(capital, tasa, dias);

        // Then
        assertEquals(BigDecimal.ZERO, resultado);
    }

    @Test
    void calcularInteresCompuesto_conMontoCero_deberiaRetornarCero() {
        // Given
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When
        BigDecimal resultado = CalculoInteresService.calcularInteresCompuesto(capital, tasa, periodos);

        // Then
        assertEquals(BigDecimal.ZERO, resultado);
    }
}