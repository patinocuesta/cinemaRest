package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntityPersonsToModelPersons")
public class EntityPersonsToModelPersons {
    public List<PersonModel> converList(List<PersonEntity> personEntities) {
        List<PersonModel> personsModel = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            personsModel.add(new PersonModel(personEntity));
        }
        return personsModel;
    }
}
