package com.banco.prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal de la aplicación Spring Boot para el servicio de préstamos.
 * Inicializa el contexto de Spring y escanea los componentes en el paquete base.
 *
 * Arquitectura:
 * - Patrón hexagonal con capas claras de dominio, aplicación e infraestructura.
 * - Los puertos (interfaces) son definidos por el dominio.
 * - Los adaptadores implementan los puertos y se ubican en infraestructura.
 * - La comunicación entre capas se realiza mediante interfaces, nunca directamente.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.banco.prestamos")
public class PrestamosApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrestamosApplication.class, args);
    }
}