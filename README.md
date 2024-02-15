# Spring-Boot---MongoDB

<div style="display: flex;">
    <!-- SPRING BOOT LOGO -->
    <a href="https://spring.io/projects/spring-boot/">
        <img src="source/spring-boot.png" alt="SPRING BOOT LOGO" height="55" />
    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <!-- MONGODB LOGO -->
    <a href="https://www.mongodb.com/">
        <img src="source/mongo-db.png" alt="MONGODB LOGO" height="50" />
    </a>
</div>

---

# Table of Contents

- [Spring-Boot---MongoDB](#spring-boot---mongodb)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
  - [Key Features](#key-features)
  - [SQL Vs MongoDB](#sql-vs-mongodb)
  - [Getting Started](#getting-started)
- [Project Dependencies](#project-dependencies)
  - [Spring Web](#spring-web)
  - [MongoDB Driver](#mongodb-driver)
  - [Lombok](#lombok)
  - [JSON Path](#json-path)
- [Database Connection](#database-connection)
  - [Sample Code Using YML](#sample-code-using-yml)
  - [Explanation](#explanation)
- [Spring Boot Annotations](#spring-boot-annotations)
  - [Document](#document)

---

# Introduction

Spring Data MongoDB is part of the larger Spring Data project, which aims to simplify data access for various data stores. It provides a high-level abstraction for interacting with MongoDB databases from Spring applications.

## Key Features

- **Simplified Data Access**: Spring Data MongoDB simplifies interaction with MongoDB databases by providing a repository abstraction and support for MongoDB-specific queries.
- **Repository Support**: Define repository interfaces for MongoDB entities, providing CRUD operations out-of-the-box.
- **MongoTemplate**: Offers a powerful way to interact with MongoDB using plain Java objects, allowing for more flexible queries and operations compared to repositories.
- **Automatic Query Generation**: Automatically generates MongoDB queries from method names in repository interfaces, reducing the need for manual query writing.
- **Annotation-Based Mapping**: Supports annotation-based mapping between Java objects and MongoDB documents, simplifying the conversion process.

## SQL Vs MongoDB

![MongoDB vs SQL](source/sql-vs-nosql.jpg)

## Getting Started

To start using Spring Data MongoDB, include the appropriate dependencies in your project's configuration file (e.g., `pom.xml` for Maven or `build.gradle` for Gradle). You'll need dependencies for Spring Data MongoDB and the MongoDB Java driver.

---

# Project Dependencies

## Spring Web

- Helps in building web applications using Spring.
- Handles web requests, defines controllers, and manages HTTP responses.
- Essential for creating RESTful APIs and web-based applications.

## MongoDB Driver

- Allows Java applications to connect to MongoDB databases.
- Facilitates executing queries and performing database operations.
- Enables communication between Java applications and MongoDB.

## Lombok

- Reduces boilerplate code in Java classes.
- Provides annotations to generate common code constructs like getters, setters, and constructors.
- Improves code readability and maintainability by eliminating repetitive code.

## JSON Path

- Facilitates querying JSON data in Java applications.
- Enables extracting specific values from JSON documents.
- Useful for parsing and manipulating JSON data structures efficiently.

---

# Database Connection

## Sample Code Using YML

```yaml
server:
  port: 8080

spring:
  profiles:
    active: dev

---

spring:
  config:
    activate:
      on-profile: dev
  data:
    mongodb:
      uri: uri
      database: person

---

spring:
  config:
    activate:
      on-profile: prod
  data:
    mongodb:
      uri: uri
      database: person
```
## Explanation

- **spring**: This section is used to define configuration properties for the Spring framework and its modules.

- **config**: This subsection defines configuration properties for Spring Boot.

- **activate**: This property specifies the activation conditions for the configuration. In this case, it's activated when the active Spring profile is dev.

- **on-profile**: Specifies the profile under which this configuration is activated. In this case, it's activated when the active profile is dev.

- **data**: This subsection is used to configure data-related settings.

- **mongodb**: This subsection specifically configures MongoDB-related settings.

- **uri**: This property specifies the URI for connecting to the MongoDB database. Replace uri with the actual URI of your MongoDB instance. The URI typically includes information such as the host, port, authentication credentials, and database name.

- **database**: This property specifies the name of the MongoDB database to connect to. In this case, it's set to person.

Overall, this configuration tells the Spring Boot application to connect to a MongoDB database with the specified URI and use the database named person. This configuration is activated when the active Spring profile is set to dev. Similarly, there is another configuration for the prod profile which is activated when the active profile is prod.

---

# Spring Boot Annotations

## Document

The `@Document` annotation is used to mark a Java class as a document that should be stored in a MongoDB collection. This annotation is similar to JPA's `@Entity` annotation in that it marks a class as a persistent entity.

```java
@Document(collection = "person")