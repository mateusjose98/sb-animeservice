package com.github.mateusjose98.animeservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/animes")
public class AnimeController {

    @GetMapping
    public List<String> listAll() {
        return List.of("Naruto", "Dragon Ball", "One Piece");
    }


}