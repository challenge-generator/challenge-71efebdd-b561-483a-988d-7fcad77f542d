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
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El cliente asociado al préstamo no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "El monto del préstamo no puede ser nulo")
    @Positive(message = "El monto del préstamo debe ser positivo")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal monto;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @Positive(message = "La tasa de interés debe ser positiva")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de vencimiento no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado;

    @Column(nullable = false)
    private Boolean activo = true;

    public Prestamo(Cliente cliente, BigDecimal monto, BigDecimal tasaInteres, LocalDate fechaInicio, LocalDate fechaVencimiento) {
        this.cliente = cliente;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = EstadoPrestamo.ACTIVO;
        this.activo = true;
    }

    public enum EstadoPrestamo {
        ACTIVO,
        LIQUIDADO,
        MOROSO,
        REFINANCIADO
    }
}