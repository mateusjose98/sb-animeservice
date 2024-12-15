package com.github.mateusjose98.animeservice.config;

import external.Connection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfiguration {

    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String user;
    @Value("${db.password}")
    private String pass;

    @Bean(name = "abacaxi")
    public Connection connectionMySql() {
        return new Connection(url, user, pass);
    }

    @Bean(name = "connectionMongoDB")
//    @Primary
    public Connection connectionMongo() {
        return new Connection(url, user, pass);
    }
}