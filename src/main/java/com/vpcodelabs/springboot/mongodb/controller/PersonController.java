package com.vpcodelabs.springboot.mongodb.controller;

import com.vpcodelabs.springboot.mongodb.collection.Person;
import com.vpcodelabs.springboot.mongodb.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
@Tag(name = "person-controllers")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @Operation(summary = "create person", description = "record a new person details by providing the necessary details.")
    public String save(@RequestBody Person person){
        return personService.save(person);
    }
}
