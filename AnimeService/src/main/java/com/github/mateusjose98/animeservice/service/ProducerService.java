package com.github.mateusjose98.animeservice.service;

import com.github.mateusjose98.animeservice.domain.Producer;
import com.github.mateusjose98.animeservice.repository.ProducerHardCodedRepository;
import com.github.mateusjose98.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerHardCodedRepository repository;

    public List<Producer> findAll(
            String name) {
        return name == null
                ? repository.findAll()
                : repository.findByName(name);
    }

    public Producer findByIdOrThrowNotFound(
            Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Producer not Found"));
    }

    public Producer save(
            Producer producer) {
        return repository.save(producer);
    }

    public void delete(Long id) {
        var producer = findByIdOrThrowNotFound(
                id);
        repository.delete(producer);
    }

    public void update(
            Producer producerToUpdate) {
        var producer = findByIdOrThrowNotFound(
                producerToUpdate.getId());
        producerToUpdate.setCreatedAt(
                producer.getCreatedAt());
        repository.update(producerToUpdate);
    }
}