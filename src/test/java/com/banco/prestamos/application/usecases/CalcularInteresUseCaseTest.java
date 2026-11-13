package com.banco.prestamos.application.usecases;

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
class CalcularInteresUseCaseTest {

    @Mock
    private CalculoInteresPort calculoInteresPort;

    @InjectMocks
    private CalcularInteresUseCase calcularInteresUseCase;

    @Test
    void ejecutar_deberiaCalcularInteresSimple() {
        // Given: un préstamo con parámetros válidos
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        when(calculoInteresPort.calcularInteresSimple(any(), any(), anyLong()))
            .thenReturn(new BigDecimal("500.00"));

        // When: se ejecuta el caso de uso
        BigDecimal resultado = calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true);

        // Then: verificar que se calculó correctamente
        assertNotNull(resultado);
        verify(calculoInteresPort).calcularInteresSimple(any(), any(), anyLong());
    }

    @Test
    void ejecutar_deberiaCalcularInteresCompuesto() {
        // Given: un préstamo para cálculo compuesto
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        when(calculoInteresPort.calcularInteresCompuesto(any(), any(), anyInt()))
            .thenReturn(new BigDecimal("500.00"));

        // When: se ejecuta con interés compuesto
        BigDecimal resultado = calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, false);

        // Then
        assertNotNull(resultado);
        verify(calculoInteresPort).calcularInteresCompuesto(any(), any(), anyInt());
    }

    @Test
    void ejecutar_conMontoNulo_deberiaLanzarExcepcion() {
        // Given
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = null;
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true)
        );
    }

    @Test
    void ejecutar_conTasaNula_deberiaLanzarExcepcion() {
        // Given
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = null;
        LocalDate fechaInicio = LocalDate.now();

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true)
        );
    }
}