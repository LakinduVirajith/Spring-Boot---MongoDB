package com.vpcodelabs.springboot.mongodb.service;

import com.vpcodelabs.springboot.mongodb.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}
