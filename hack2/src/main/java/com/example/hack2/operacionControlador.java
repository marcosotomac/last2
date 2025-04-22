package com.example.hack2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resta")
public class operacionControlador {
    private final operacionService restaService;

    public operacionControlador(operacionService restaService) {
        this.restaService = restaService;
    }

    @GetMapping("/{a}/{b}")
    public ResponseEntity<?> restar(@PathVariable int a, @PathVariable int b) {
        try {
            operacion operacion = restaService.restar(a, b);
            return ResponseEntity.ok(operacion.getResultado());
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error 400: " + e.getMessage());
        }
    }
}
