package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CPlay;
import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.entity.Play;
import online.patino.cinemaRest.model.MPlay;
import online.patino.cinemaRest.repository.PlayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlayServie")
public class PlayService {
    @Autowired
    @Qualifier("PlayRepo")
    private PlayRepo playrepo;

    @Autowired
    @Qualifier("CPlay")
    private CPlay cplay;

    public boolean create (Play play){
        try{
            playrepo.save(play);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (Play play){
        try{
            playrepo.save(play);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id, Film film, Person person){
        try{
            Play play = playrepo.findByIdAndFilmAndPerson(id, film, person);
            playrepo.delete(play);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public List<MPlay> getListMPlay(){
        return cplay.converList(playrepo.findAll());
    }
    public List<MPlay> getListByName(String name){
        return cplay.converList(playrepo.findByName(name));
    }
    public MPlay getMPlayByIdAndName(Long id, String name){
        return new MPlay(playrepo.findByIdAndName(id, name));
    }
    public MPlay getMPlayByIdAndFilm(Long id, Film film) {
        return new MPlay(playrepo.findByIdAndFilm(id, film));
    }
     public MPlay getMPlayByIdAndPerson(Long id, Person person){
        return new MPlay(playrepo.findByIdAndPerson(id, person));
    }
    public List<MPlay> getMPlayByFilmAndPerson (Film film, Person person){
        return cplay.converList(playrepo.findByFilmAndPerson(film, person));
    }
}
