package com.github.mateusjose98.animeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// adiciona nas vm options isso: -Xmx500m -XshowSettings:vm
@SpringBootApplication
public class AnimeServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AnimeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        int[] original = new int[]{1, 2, 3};

        Algo algo = new Algo(original);

        int[] copia = new int[original.length + 1];

        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }

        copia[copia.length - 1] = 3;


        for (int i = 0; i < copia.length; i++) {
            System.out.println(copia[i]);
        }

    }

    public record Algo(int[] numeros){}
}
