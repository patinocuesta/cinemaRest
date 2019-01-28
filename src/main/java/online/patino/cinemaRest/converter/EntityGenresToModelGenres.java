package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.GenreModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntityGenresToModelGenres")
public class EntityGenresToModelGenres {
    public List<GenreModel> converList(List<GenreEntity> genreEntities) {
        List<GenreModel> genresModel = new ArrayList<>();
        for (GenreEntity genreEntity : genreEntities) {
            genresModel.add(new GenreModel(genreEntity));
        }
        return genresModel;
    }
}
