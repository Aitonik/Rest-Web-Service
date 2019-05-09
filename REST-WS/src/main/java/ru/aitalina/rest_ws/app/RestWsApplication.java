package ru.aitalina.rest_ws.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ru.aitalina.rest_ws")
@EnableJpaRepositories(basePackages = "ru.aitalina.rest_ws.dao")
@EntityScan(basePackages = "ru.aitalina.rest_ws.model")
public class RestWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestWsApplication.class, args);
    }


}
