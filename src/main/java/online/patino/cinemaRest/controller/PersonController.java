package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/v1")
public class PersonController {
    @Autowired
    @Qualifier("PersonService")
    PersonService personservice;

    @PutMapping("/createperson")
    public boolean createPerson(@RequestBody @Valid Person person){
        return personservice.create(person);
    }
}
