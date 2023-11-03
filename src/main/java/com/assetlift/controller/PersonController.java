package com.assetlift.controller;

import com.assetlift.model.Person;
import com.assetlift.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        var person = personService.getPerson(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person personIn) throws URISyntaxException {
        var personOut = personService.savePerson(personIn);
        return ResponseEntity.created(new URI("/persons/" + personOut.getId())).body(personOut);
    }

    @PostMapping("onboarding")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> savePeople(@RequestBody List<Person> peopleIn) throws URISyntaxException {
        for (Person personIn : peopleIn) {
            personService.savePerson(personIn);
        }
        return peopleIn;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personIn) throws URISyntaxException {
        var personOut = personService.updatePerson(id, personIn);
        if (personOut != null) {
            return ResponseEntity.noContent().build();
        }
        return savePerson(personIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        var person = personService.getPerson(id);
        if (person != null) {
            personService.deletePerson(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
