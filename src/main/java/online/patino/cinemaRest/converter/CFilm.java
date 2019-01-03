package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.model.MFilm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Convertidor par sacar  lista de un modelo desde una entidad
@Component("CFilm")
public class CFilm {
    public List<MFilm> converList(List<Film> films) {
        List<MFilm> mfilms = new ArrayList<>();
        for (Film film : films) {
            mfilms.add(new MFilm(film));
        }
        return mfilms;
    }
}
