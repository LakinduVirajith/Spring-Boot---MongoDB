package com.vpcodelabs.springboot.mongodb.controller;

import com.vpcodelabs.springboot.mongodb.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
