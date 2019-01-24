package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.GenreModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Convertidor par sacar  lista de un modelo desde una entidad
@Component("CGenre")
public class CGenre {
    public List<GenreModel> converList(List<GenreEntity> genreEntities) {
        List<GenreModel> mgenres = new ArrayList<>();
        for (GenreEntity genreEntity : genreEntities) {
            mgenres.add(new GenreModel(genreEntity));
        }
        return mgenres;
    }
}
