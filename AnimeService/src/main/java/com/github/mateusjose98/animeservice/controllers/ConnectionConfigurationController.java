package com.github.mateusjose98.animeservice.controllers;

import external.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("connection")
@Slf4j
@RequiredArgsConstructor
public class ConnectionConfigurationController {


    @Qualifier(value = "abacaxi")
    private final Connection connection;

    @GetMapping
    public ResponseEntity<Connection> getConnection() {
        return ResponseEntity.ok(connection);
    }

}
