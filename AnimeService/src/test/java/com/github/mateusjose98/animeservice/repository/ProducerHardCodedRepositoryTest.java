package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Producer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProducerHardCodedRepositoryTest {


    @InjectMocks // o mockito vai criar este objeto para gente
    private ProducerHardCodedRepository producerHardCodedRepository;

    @Mock
    private ProducerData producerData;
    List<Producer> producers;


    @BeforeEach
    void setUp() {

        producers = new ArrayList<>(List.of(
                Producer.builder().id(1L).name("Toei Animation").build(),
                Producer.builder().id(2L).name("Madhouse").build(),
                Producer.builder().id(3L).name("Sunrise").build()
        ));
        BDDMockito.when(producerData.findAll()).thenReturn(producers);
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll_ReturnsAllProducers_WhenSuccessful() {
        var result = producerHardCodedRepository.findAll();
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSameElementsAs(producers);

    }

    @Test
    @DisplayName("findById returns a producer when successful")
    void findById_ReturnsProducer_WhenSuccessful() {
        var expectedProducer = producers.getFirst();
        var result = producerHardCodedRepository.findById(1L);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(expectedProducer.getId(), result.get().getId());
        assertEquals("Toei Animation", result.get().getName());
    }

    @Test
    @DisplayName("findById returns empty when producer is not found")
    void findById_ReturnsEmpty_WhenProducerIsNotFound() {
        var result = producerHardCodedRepository.findById(400L);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("findByName returns a list of producers when successful")
    void findByName_ReturnsListOfProducers_WhenSuccessful() {
        var result = producerHardCodedRepository.findByName("Toei Animation");
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Toei Animation", result.get(0).getName());
    }

    @Test
    @DisplayName("findByName returns empty list when producer is not found")
    void findByName_ReturnsEmptyList_WhenProducerIsNotFound() {
        var result = producerHardCodedRepository.findByName("abcd");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("save returns a producer when successful")
    void save_ReturnsProducer_WhenSuccessful() {
        var producer = Producer.builder().id(4L).name("Bones").build();
        var result = producerHardCodedRepository.save(producer);
        assertNotNull(result);
        assertEquals(4L, result.getId());
        assertEquals("Bones", result.getName());
    }

    @Test
    @DisplayName("delete removes a producer when successful")
    void delete_RemovesProducer_WhenSuccessful() {
        producerHardCodedRepository.delete(Producer.builder().id(1L).name("Toei Animation").build());
        var result = producerHardCodedRepository.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("delete returns false when producer is not found")
    void delete_ReturnsFalse_WhenProducerIsNotFound() {
        producerHardCodedRepository.delete(Producer.builder().id(400L).name("Toei Animation").build());
        var result = producerHardCodedRepository.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("update updates a producer when successful")
    void update_UpdatesProducer_WhenSuccessful() {
        var producer = Producer.builder().id(1L).name("Bones").build();
        producerHardCodedRepository.update(producer);
        var result = producerHardCodedRepository.findById(1L);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("Bones", result.get().getName());
    }



}