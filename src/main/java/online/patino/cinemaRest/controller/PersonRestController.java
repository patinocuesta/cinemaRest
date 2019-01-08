package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/persons")
public class PersonRestController {
    @Autowired
    @Qualifier("PersonService")
    PersonService personservice;

    @PutMapping("/create")
    public boolean createPerson(@RequestBody @Valid Person person) {
        return personservice.create(person);
    }

    @PostMapping("/edit")
    public boolean editPerson(@RequestBody @Valid Person person) {
        return personservice.update(person);
    }

    @DeleteMapping("/delete/{id}/{surname}/{givenname}")
    public boolean deletePerson (@PathVariable ("id") Long id,
                                 @PathVariable ("surname") String givenname,
                                 @PathVariable ("givenname")String surname){
        return personservice.delete(id, surname, givenname);
    }
}