package com.alura.foro.config.errors;

public class IntegrityValidator extends RuntimeException {
    public IntegrityValidator(String s) {
        super(s);
    }
}