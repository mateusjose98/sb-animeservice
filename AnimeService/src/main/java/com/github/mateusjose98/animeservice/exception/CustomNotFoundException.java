package com.github.mateusjose98.animeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super( message);
    }
}