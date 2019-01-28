package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.model.FilmModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntityFilmsToModelFilms")
public class EntityFilmsToModelFilms {
    public List<FilmModel> converList(List<FilmEntity> filmEntities) {
        List<FilmModel> filmsModel = new ArrayList<>();
        for (FilmEntity filmEntity : filmEntities) {
            filmsModel.add(new FilmModel(filmEntity));
        }
        return filmsModel;
    }
}
