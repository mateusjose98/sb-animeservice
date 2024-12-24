package com.github.mateusjose98.animeservice.service;

import com.github.mateusjose98.animeservice.domain.Producer;
import com.github.mateusjose98.animeservice.exception.CustomNotFoundException;
import com.github.mateusjose98.animeservice.repository.ProducerHardCodedRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProducerServiceTest {

    @InjectMocks
    private ProducerService producerService;

    @Mock
    private ProducerHardCodedRepository repository;

    List<Producer> producers;

    @BeforeEach
    void setUp() {
        producers = new ArrayList<>(List.of(
                Producer.builder().id(1L).name("Toei Animation").build(),
                Producer.builder().id(2L).name("Madhouse").build(),
                Producer.builder().id(3L).name("Sunrise").build()
        ));
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll() {
        BDDMockito.when(repository.findAll()).thenReturn(producers);
        var result = producerService.findAll(null);
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSameElementsAs(producers);
    }

    @Test
    @DisplayName("findAll returns when search by name")
    void findAllByName() {

        BDDMockito.when(repository.findByName(producers.getFirst().getName())).thenReturn(List.of(producers.get(0)));

        var result = producerService.findAll("Toei Animation");
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .contains(producers.get(0));
    }

    @Test
    @DisplayName("findAll returns a empty list when search by name does not exist")
    void findAllByNameNotFound() {
        BDDMockito.when(repository.findByName("Toei Animation")).thenReturn(new ArrayList<>());
        var result = producerService.findAll("Toei Animation");
        Assertions.assertThat(result)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void findByIdOrThrowNotFound() {
        Optional<Producer> expected = Optional.of(producers.get(0));
        BDDMockito.when(repository.findById(1L)).thenReturn(expected);
        var result = producerService.findByIdOrThrowNotFound(1L);
        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(expected.get());
    }

    @Test
    @DisplayName("findByIdOrThrowNotFound throws exception when producer not found")
    void findByIdOrThrowNotFoundThrowsException() {
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> producerService.findByIdOrThrowNotFound(1L))
                .isInstanceOf(CustomNotFoundException.class);
    }

    @Test
    void save() {
        var producer = producers.get(0);
        BDDMockito.when(repository.save(producer)).thenReturn(producer);
        var result = producerService.save(producer);
        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(producer);
    }

    @Test
    void delete() {
        var producer = producers.get(0);
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.of(producer));
        producerService.delete(1L);
        Mockito.verify(repository, Mockito.times(1)).delete(producer);
    }

    @Test
    void deleteThrowsException() {
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> producerService.delete(1L))
                .isInstanceOf(CustomNotFoundException.class);
    }
}