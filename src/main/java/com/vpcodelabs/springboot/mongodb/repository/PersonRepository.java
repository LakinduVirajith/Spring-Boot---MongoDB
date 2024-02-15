package com.vpcodelabs.springboot.mongodb.repository;

import com.vpcodelabs.springboot.mongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
}
