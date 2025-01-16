package com.github.mateusjose98.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigs {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
