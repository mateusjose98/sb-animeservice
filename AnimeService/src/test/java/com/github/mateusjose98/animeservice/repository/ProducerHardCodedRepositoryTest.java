package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Producer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProducerHardCodedRepositoryTest {


    @InjectMocks // o mockito vai criar este objeto para gente
    private ProducerHardCodedRepository producerHardCodedRepository;

    @Mock
    private ProducerData producerData;

    @BeforeEach
    void setUp() {
        List<Producer> producers = List.of(
                Producer.builder().id(1L).name("Toei Animation").build(),
                Producer.builder().id(2L).name("Madhouse").build(),
                Producer.builder().id(3L).name("Sunrise").build()
        );
        BDDMockito.when(producerData.findAll()).thenReturn(producers);
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll_ReturnsAllProducers_WhenSuccessful() {
        var result = producerHardCodedRepository.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("findById returns a producer when successful")
    void findById_ReturnsProducer_WhenSuccessful() {
        var result = producerHardCodedRepository.findById(1L);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("Toei Animation", result.get().getName());
    }


}