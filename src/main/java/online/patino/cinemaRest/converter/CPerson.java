package online.patino.cinemaRest.converter;

//Convertidor par sacar  lista de un modelo desde una entidad


import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.model.MPerson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CPerson")
public class CPerson {
    public List<MPerson> converList(List<Person> persons) {
        List<MPerson> mpersons = new ArrayList<>();
        for (Person person : persons) {
            mpersons.add(new MPerson(person));
        }
        return mpersons;
    }
}
