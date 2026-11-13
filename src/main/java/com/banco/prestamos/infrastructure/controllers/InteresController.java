package com.banco.prestamos.infrastructure.controllers;

import com.banco.prestamos.application.usecases.CalcularInteresUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/intereses")
public class InteresController {

    private final CalcularInteresUseCase calcularInteresUseCase;

    public InteresController(CalcularInteresUseCase calcularInteresUseCase) {
        this.calcularInteresUseCase = calcularInteresUseCase;
    }

    @PostMapping("/simple")
    public ResponseEntity<InteresResponse> calcularInteresSimple(
            @RequestBody InteresSimpleRequest request) {
        UUID prestamoId = request.prestamoId();
        LocalDate fechaCalculo = request.fechaCalculo() != null 
            ? request.fechaCalculo() 
            : LocalDate.now();
        
        var resultado = calcularInteresUseCase.ejecutarCalculoSimple(prestamoId, fechaCalculo);
        
        return ResponseEntity.ok(InteresResponse.from(
            resultado.getId(),
            resultado.getPrestamo().getId(),
            resultado.getMontoInteres(),
            resultado.getFechaCalculo(),
            resultado.getPagado()
        ));
    }

    @PostMapping("/compuesto")
    public ResponseEntity<InteresResponse> calcularInteresCompuesto(
            @RequestBody InteresCompuestoRequest request) {
        UUID prestamoId = request.prestamoId();
        LocalDate fechaCalculo = request.fechaCalculo() != null 
            ? request.fechaCalculo() 
            : LocalDate.now();
        
        var resultado = calcularInteresUseCase.ejecutarCalculoCompuesto(
            prestamoId, 
            fechaCalculo, 
            request.periodos()
        );
        
        return ResponseEntity.ok(InteresResponse.from(
            resultado.getId(),
            resultado.getPrestamo().getId(),
            resultado.getMontoInteres(),
            resultado.getFechaCalculo(),
            resultado.getPagado()
        ));
    }

    @GetMapping("/prestamo/{prestamoId}/total")
    public ResponseEntity<Map<String, BigDecimal>> obtenerInteresTotal(
            @PathVariable UUID prestamoId) {
        BigDecimal interesTotal = calcularInteresUseCase.obtenerInteresTotal(prestamoId);
        return ResponseEntity.ok(Map.of("interesTotal", interesTotal));
    }

    public record InteresSimpleRequest(
        UUID prestamoId,
        LocalDate fechaCalculo
    ) {}

    public record InteresCompuestoRequest(
        UUID prestamoId,
        LocalDate fechaCalculo,
        int periodos
    ) {}

    public record InteresResponse(
        UUID id,
        UUID prestamoId,
        BigDecimal montoInteres,
        LocalDate fechaCalculo,
        Boolean pagado
    ) {
        public static InteresResponse from(UUID id, UUID prestamoId, BigDecimal monto, 
                LocalDate fecha, Boolean pagado) {
            return new InteresResponse(id, prestamoId, monto, fecha, pagado);
        }
    }
}