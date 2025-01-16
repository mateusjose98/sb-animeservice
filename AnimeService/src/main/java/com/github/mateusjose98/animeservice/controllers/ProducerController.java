package com.github.mateusjose98.animeservice.controllers;

import com.github.mateusjose98.animeservice.mapper.ProducerMapper;
import com.github.mateusjose98.animeservice.request.ProducerPostRequest;
import com.github.mateusjose98.animeservice.request.ProducerPutRequest;
import com.github.mateusjose98.animeservice.response.ProducerGetResponse;
import com.github.mateusjose98.animeservice.response.ProducerPostResponse;
import com.github.mateusjose98.animeservice.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/producers")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerMapper mapper;

    private final ProducerService service;

    @GetMapping
    public ResponseEntity<List<ProducerGetResponse>> listAll(
            @RequestParam(required = false) String name) {
        log.debug(
                "Request received to list all producers, param name '{}'",
                name);
        var producers = service.findAll(
                name);

        var producerGetResponses = mapper.toProducerGetResponseList(
                producers);

        return ResponseEntity.ok(
                producerGetResponses);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProducerGetResponse> findById(
            @PathVariable Long id) {
        log.debug(
                "Request to find producer by id: {}",
                id);

        var producer = service.findByIdOrThrowNotFound(
                id);

        var producerGetResponse = mapper.toProducerGetResponse(
                producer);

        return ResponseEntity.ok(
                producerGetResponse);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "x-api-key")
    public ResponseEntity<ProducerPostResponse> save(
            @RequestBody ProducerPostRequest producerPostRequest,
            @RequestHeader HttpHeaders headers) {
        log.info("{}", headers);
        var producer = mapper.toProducer(
                producerPostRequest);

        var producerSaved = service.save(
                producer);

        var producerGetResponse = mapper.toProducerPostResponse(
                producerSaved);

        return ResponseEntity.status(
                        HttpStatus.CREATED)
                .body(producerGetResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        log.debug(
                "Request to delete producer by id: {}",
                id);

        service.delete(id);

        return ResponseEntity.noContent()
                .build();
    }

    @PutMapping
    public ResponseEntity<Void> update(
            @RequestBody ProducerPutRequest request) {
        log.debug(
                "Request to update producer {}",
                request);

        var producerToUpdate = mapper.toProducer(
                request);

        service.update(producerToUpdate);

        return ResponseEntity.noContent()
                .build();
    }

}