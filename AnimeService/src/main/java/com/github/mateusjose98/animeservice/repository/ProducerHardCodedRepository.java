package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Producer;
import external.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProducerHardCodedRepository {

    @Qualifier(value = "connectionMySql")
    private final Connection connection;
    private final ProducerData producerData;

    public List<Producer> findAll() {
        return producerData.findAll();
    }

    public Optional<Producer> findById(Long id) {
        return producerData.findAll().stream().filter(producer -> producer.getId().equals(id)).findFirst();
    }

    public List<Producer> findByName(String name) {
        log.debug(connection);
        return producerData.findAll().stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
    }

    public Producer save(Producer producer) {
        producerData.findAll().add(producer);
        return producer;
    }

    public void delete(Producer producer) {
        producerData.findAll().remove(producer);
    }

    public void update(Producer producer) {
        delete(producer);
        save(producer);
    }
}
