package com.banco.prestamos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @Size(max = 100, message = "El nombre del cliente no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El identificador fiscal no puede estar vacío")
    @Size(max = 20, message = "El identificador fiscal no puede exceder los 20 caracteres")
    @Column(nullable = false, unique = true, length = 20)
    private String identificadorFiscal;

    @Positive(message = "La edad debe ser un valor positivo")
    @Column(nullable = false)
    private Integer edad;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    @Column(nullable = false, length = 200)
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 15, message = "El teléfono no puede exceder los 15 caracteres")
    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false)
    private Boolean activo = true;

    public Cliente(String nombre, String identificadorFiscal, Integer edad, String direccion, String telefono) {
        this.nombre = nombre;
        this.identificadorFiscal = identificadorFiscal;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = true;
    }
}