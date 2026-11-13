package com.banco.prestamos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El préstamo asociado al cálculo de intereses no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @NotNull(message = "El monto de intereses no puede ser nulo")
    @Positive(message = "El monto de intereses debe ser positivo")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal montoInteres;

    @NotNull(message = "La fecha de cálculo no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaCalculo;

    @Column(nullable = false)
    private Boolean pagado = false;

    public Interes(Prestamo prestamo, BigDecimal montoInteres, LocalDate fechaCalculo) {
        this.prestamo = prestamo;
        this.montoInteres = montoInteres;
        this.fechaCalculo = fechaCalculo;
        this.pagado = false;
    }

    public static BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        if (capital == null || tasa == null || dias <= 0) {
            throw new IllegalArgumentException("Capital, tasa y días deben ser valores válidos");
        }
        BigDecimal tasaDiaria = tasa.divide(BigDecimal.valueOf(360), 10, BigDecimal.ROUND_HALF_UP);
        return capital.multiply(tasaDiaria).multiply(BigDecimal.valueOf(dias));
    }

    public static BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        if (capital == null || tasa == null || periodos <= 0) {
            throw new IllegalArgumentException("Capital, tasa y periodos deben ser valores válidos");
        }
        BigDecimal tasaPeriodo = tasa.divide(BigDecimal.valueOf(100), 10, BigDecimal.ROUND_HALF_UP);
        return capital.multiply(BigDecimal.ONE.add(tasaPeriodo).pow(periodos)).subtract(capital);
    }
}