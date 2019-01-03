package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.Genre;
import online.patino.cinemaRest.model.MGenre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Convertidor par sacar  lista de un modelo desde una entidad
@Component("CGenre")
public class CGenre {
    public List<MGenre> converList(List<Genre> genres) {
        List<MGenre> mgenres = new ArrayList<>();
        for (Genre genre : genres) {
            mgenres.add(new MGenre(genre));
        }
        return mgenres;
    }
}
