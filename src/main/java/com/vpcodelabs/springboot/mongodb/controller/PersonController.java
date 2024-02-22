package com.vpcodelabs.springboot.mongodb.controller;

import com.vpcodelabs.springboot.mongodb.collection.Person;
import com.vpcodelabs.springboot.mongodb.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/age")
    @Operation(summary = "get person by age", description = "retrieve all persons details based on age range")
    public List<Person> getByPersonAge(@RequestParam Integer minAge, @RequestParam Integer maxAge){
        return personService.getByPersonAge(minAge, maxAge);
    }

    @GetMapping("/search")
    @Operation(summary = "search person by following", description = "search all person details based on name, minAge, maxAge or city")
    public Page<Person> searchPerson(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer minAge,
                                     @RequestParam(required = false) Integer maxAge,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }

    @GetMapping("/oldest-person")
    @Operation(summary = "get oldest person by cities", description = "using aggregation and mongo template fetch oldest person by cities")
    public List<Document> getOldestPerson(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/population-by-city")
    @Operation(summary = "get population by cities", description = "using aggregation and mongo template fetch population by cities")
    public List<Document> getPopulationByCity(){
        return personService.getPopulationByCity();
    }
}
