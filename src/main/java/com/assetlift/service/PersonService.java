package com.assetlift.service;

import com.assetlift.model.Person;
import com.assetlift.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public Person savePerson(Person user) {
        return personRepository.save(user);
    }

    public Person updatePerson(Long id, Person personIn) {
        Person personOut = personRepository.findById(id).orElse(null);

        if (personOut == null) {
            return null;
        }

        personIn.setId(id);
        return personRepository.save(personIn);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
