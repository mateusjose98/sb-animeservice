package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimeData {

    private final List<Anime> ANIMES = new ArrayList<>();

    {
        var ninjaKamui = Anime.builder()
                .id(1L).name("Ninja Kamui")
                .build();
        var kaijuu = Anime.builder().id(2L)
                .name("Kaijuu-8gou").build();
        var kimetsuNoYaiba = Anime.builder()
                .id(3L).name("Kimetsu No Yaiba")
                .build();
        ANIMES.addAll(
                List.of(ninjaKamui, kaijuu,
                        kimetsuNoYaiba));
    }

    public List<Anime> findAll() {
        return ANIMES;
    }

}
