package com.vpcodelabs.springboot.mongodb.service;

import com.vpcodelabs.springboot.mongodb.collection.Person;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void delete(String id);

    List<Person> getByPersonAge(Integer minAge, Integer maxAge);
}
