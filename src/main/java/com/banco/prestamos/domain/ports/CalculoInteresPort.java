package com.banco.prestamos.domain.ports;

import java.math.BigDecimal;

public interface CalculoInteresPort {
    BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias);
    BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos);
    BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual);
    BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual);
}