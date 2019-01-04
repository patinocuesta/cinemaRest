package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CFilm;
import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.model.MFilm;
import online.patino.cinemaRest.repository.FilmRepo;
import online.patino.cinemaRest.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FilmService")
public class FilmService {
    @Autowired
    @Qualifier ("FilmRepo")
    private FilmRepo filmRepo;
    @Autowired
    @Qualifier ("CFilm")
    private CFilm cfilm;

    public boolean create (Film film){
        try{
            filmRepo.save(film);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (Film film){
        try{
           filmRepo.save(film);

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id, String title){
        try{
            Film film = filmRepo.findByTitleAndId(title, id);
            filmRepo.delete(film);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MFilm> getListMFilm(){
        return cfilm.converList(filmRepo.findAll());
    }

    public MFilm getMFilmByTitleAndId (Long id, String title){
        return new MFilm(filmRepo.findByTitleAndId(title, id));
    }

    public List<MFilm> getMFilmByTitle (String title){
        return cfilm.converList(filmRepo.findByTitle(title));
    }
}
