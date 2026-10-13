package com.dinheiro.monitor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Erros {
    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<String> handlersuarioException(UsuarioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public static class UsuarioException extends IllegalArgumentException {
        public UsuarioException(String message) {
            super(message);
        }

        @ExceptionHandler(BuscasException.class)
        public ResponseEntity<String> handlerbuscasException(BuscasException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        public static class BuscasException extends IllegalArgumentException {
            public BuscasException(String message) {
                super(message);
            }
        }

    }

}
