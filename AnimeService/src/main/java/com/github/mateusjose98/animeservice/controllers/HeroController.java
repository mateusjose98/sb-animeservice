package com.github.mateusjose98.animeservice.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {

    private static final List<String> heroes = List.of("Superman", "Batman", "Goku", "Kakashi");

    @GetMapping
    public List<String> listAll(@RequestParam(value = "name", required = false) String name) {
        return heroes.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
    }



}
