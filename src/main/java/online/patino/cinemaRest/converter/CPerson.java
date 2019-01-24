package online.patino.cinemaRest.converter;

//Convertidor par sacar  lista de un modelo desde una entidad


import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CPerson")
public class CPerson {
    public List<PersonModel> converList(List<PersonEntity> personEntities) {
        List<PersonModel> mpeople = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            mpeople.add(new PersonModel(personEntity));
        }
        return mpeople;
    }
}
