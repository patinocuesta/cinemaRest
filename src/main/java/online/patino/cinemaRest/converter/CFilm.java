package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.model.FilmModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Convertidor par sacar  lista de un modelo desde una entidad
@Component("CFilm")
public class CFilm {
    public List<FilmModel> converList(List<FilmEntity> filmEntities) {
        List<FilmModel> mfilms = new ArrayList<>();
        for (FilmEntity filmEntity : filmEntities) {
            mfilms.add(new FilmModel(filmEntity));
        }
        return mfilms;
    }
}
