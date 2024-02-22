package com.vpcodelabs.springboot.mongodb;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Tag(name = "greeting-message")
public class SpringBootMongoDBApplication {

    @Value("${server.port}")
    private int serverPort;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDBApplication.class, args);
    }

    @GetMapping
    public String greetingMessage(){
        return "Spring Boot MongoDB Application Running Well on Port " + serverPort;
    }
}
