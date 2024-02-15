package com.vpcodelabs.springboot.mongodb.service;

import com.vpcodelabs.springboot.mongodb.collection.Person;

public interface PersonService {

    String save(Person person);
}
