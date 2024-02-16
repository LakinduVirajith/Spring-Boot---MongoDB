package com.vpcodelabs.springboot.mongodb.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot With MongoDB API",
                description = "This API provides endpoints to interact with a Spring Boot application using MongoDB. It serves as a sample project demonstrating the integration of Spring Boot with MongoDB for practice purposes.",
                version = "1.0"
        )
)
public class SwaggerConfig {
}
