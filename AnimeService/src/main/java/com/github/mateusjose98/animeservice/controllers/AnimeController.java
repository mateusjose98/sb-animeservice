package com.github.mateusjose98.animeservice.controllers;

import com.github.mateusjose98.animeservice.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/animes")
public class AnimeController {

    @GetMapping
    public List<Anime> listAll() {
        return Anime.getAnimes();
    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable Long id) {
        return Anime.getAnimes().stream().filter(anime -> anime.getId().equals(id)).findFirst().orElse(null);
    }


}
