package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.service.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/persons")
public class PersonRestController {
    @Autowired
    @Qualifier("PersonService")
    PersonManager personservice;

    @PutMapping("/create")
    public boolean createPerson(@RequestBody @Valid PersonEntity personEntity) {
        return personservice.create(personEntity);
    }

    @PostMapping("/edit")
    public boolean editPerson(@RequestBody @Valid PersonEntity personEntity) {
        return personservice.update(personEntity);
    }

    @DeleteMapping("/delete/{id}/{surname}/{givenname}")
    public boolean deletePerson (@PathVariable ("id") Long id,
                                 @PathVariable ("surname") String givenname,
                                 @PathVariable ("givenname")String surname){
        return personservice.delete(id, surname, givenname);
    }
}