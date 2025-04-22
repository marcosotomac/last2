package com.example.hack2;

import org.springframework.stereotype.Service;

@Service
public class operacionService {
    public operacion restar(int a, int b) {
        if (a == b) {
            throw new IllegalArgumentException("‘a’ no puede ser igual a ‘b’");
        }
        if (a < b) {
            throw new IllegalArgumentException("‘a’ no puede ser menor que ‘b’");
        }

        int resultado = a - b;
        return new operacion(a, b, resultado);
    }
}
