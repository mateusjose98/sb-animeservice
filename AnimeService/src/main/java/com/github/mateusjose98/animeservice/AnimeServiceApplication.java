package com.github.mateusjose98.animeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// adiciona nas vm options isso: -Xmx500m -XshowSettings:vm
@SpringBootApplication
public class AnimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeServiceApplication.class, args);
    }

}
