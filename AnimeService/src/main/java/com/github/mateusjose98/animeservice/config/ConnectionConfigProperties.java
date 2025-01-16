package com.github.mateusjose98.animeservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db")
public record ConnectionConfigProperties(
        String url, String username,
        String password) {

}
