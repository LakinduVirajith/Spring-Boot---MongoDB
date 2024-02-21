package com.vpcodelabs.springboot.mongodb.repository;

import com.vpcodelabs.springboot.mongodb.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
