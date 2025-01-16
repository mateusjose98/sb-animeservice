package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Producer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProducerData {

    private final List<Producer> PRODUCERS = new ArrayList<>();

    {
        var mappa = Producer.builder()
                .id(1L).name("Mappa")
                .createdAt(LocalDateTime.now())
                .build();
        var kyotoAnimation = Producer.builder()
                .id(2L).name("Kyoto Animation")
                .createdAt(LocalDateTime.now())
                .build();
        var madhouse = Producer.builder()
                .id(3L).name("Madhouse")
                .createdAt(LocalDateTime.now())
                .build();
        PRODUCERS.addAll(
                List.of(mappa, kyotoAnimation,
                        madhouse));
    }

    public List<Producer> findAll() {
        return PRODUCERS;
    }
}
