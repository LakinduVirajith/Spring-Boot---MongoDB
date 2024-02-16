package com.vpcodelabs.springboot.mongodb.controller;

import com.vpcodelabs.springboot.mongodb.collection.Person;
import com.vpcodelabs.springboot.mongodb.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @Operation(summary = "get persons based on name", description = "retrieve all persons details start with given name")
    public List<Person> getPersonStartWith(@RequestParam("name") String name){
        return personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete person", description = "delete person based on id")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }
}
