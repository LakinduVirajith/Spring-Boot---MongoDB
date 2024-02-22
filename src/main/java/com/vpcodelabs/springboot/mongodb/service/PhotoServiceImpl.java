package com.vpcodelabs.springboot.mongodb.service;

import com.vpcodelabs.springboot.mongodb.collection.Photo;
import com.vpcodelabs.springboot.mongodb.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{

    private final PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(originalFilename);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY ,image.getBytes()));

        return photoRepository.save(photo).getId();
    }

    @Override
    public Photo getPhoto(String id) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        Photo photo = new Photo();

        if(optionalPhoto.isPresent()){
            photo = optionalPhoto.get();
        }
        return photo;
    }
}
