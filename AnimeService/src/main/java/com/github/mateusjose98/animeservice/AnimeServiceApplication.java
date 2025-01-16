package com.github.mateusjose98.animeservice;

import com.github.mateusjose98.animeservice.config.ConnectionConfigProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

// adiciona nas vm options isso: -Xmx500m -XshowSettings:vm
@SpringBootApplication
@EnableConfigurationProperties(value = {
        ConnectionConfigProperties.class})
@ComponentScan(basePackages = {
        "com.github.mateusjose98"})
public class AnimeServiceApplication implements
        CommandLineRunner {

    public static void main(
            String[] args) {
        SpringApplication.run(
                AnimeServiceApplication.class,
                args);
    }

    @Override
    public void run(String... args) throws Exception {

        int[] original = new int[]{1, 2, 3};

        Algo algo = new Algo(original);

        int[] copia = new int[original.length + 1];

        System.arraycopy(original, 0, copia,0, original.length);

        copia[copia.length - 1] = 3;

        for (int i = 0; i < copia.length;
             i++) {
            System.out.println(copia[i]);
        }

    }

    public record Algo(int[] numeros) {

    }
}
