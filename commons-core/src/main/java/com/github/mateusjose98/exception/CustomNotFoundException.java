package com.github.mateusjose98.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super( message);
    }
}