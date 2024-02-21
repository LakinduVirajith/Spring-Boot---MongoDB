package com.vpcodelabs.springboot.mongodb.controller;

import com.vpcodelabs.springboot.mongodb.collection.Photo;
import com.vpcodelabs.springboot.mongodb.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photo")
@Tag(name = "photo-controllers")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    @Operation(summary = "insert a photo", description = "insert a new photo by providing the necessary details.")
    public String addPhoto(@RequestParam("image") MultipartFile image) throws IOException {
        return photoService.addPhoto(image.getOriginalFilename(), image);
    }

    @GetMapping("/{id}")
    @Operation(summary = "download a photo", description = "download a photo by id")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
        Photo photo = photoService.getPhoto(id);
        Resource resource = new ByteArrayResource(photo.getPhoto().getData());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
