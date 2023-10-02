package com.alura.foro.config.errors;

import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Handle404Error() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Handle404Error(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(ErrorHandlerData::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(IntegrityValidator.class)
    public ResponseEntity errorHandlerIntegrityValidation (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity errorHandlerBValidations (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record ErrorHandlerData(String field, String error) {
        public ErrorHandlerData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
