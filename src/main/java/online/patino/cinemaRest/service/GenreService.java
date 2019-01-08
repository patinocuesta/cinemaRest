package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CGenre;
import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Genre;
import online.patino.cinemaRest.model.MGenre;
import online.patino.cinemaRest.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GenreService")
public class GenreService {
    @Autowired
    @Qualifier("GenreRepo")
    private GenreRepo genreRepo;

    @Autowired
    @Qualifier("CGenre")
    private CGenre cgenre;

    public boolean create (Genre genre){
        try{
            genreRepo.save(genre);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (Genre genre){
        try{
            genreRepo.save(genre);
            return true;
        }catch(Exception e){

            return false;
        }
    }
    public boolean delete (Long id){
        try{

            Genre genre = genreRepo.findById(id);
            genreRepo.delete(genre);
            return true;
        }catch(Exception e){
            Genre genre = genreRepo.findById(id);
            if(genre.getFilms().size()>0){ throw new IllegalStateException("le genre '"+genre.getName()+"' est associé à des films");}
            return false;
        }
    }

    public List<MGenre> getListMGenre(){
        return cgenre.converList(genreRepo.findAll());
    }

    public MGenre getMGenreByIdAndName (Long id, String name){
        return new MGenre(genreRepo.findByIdAndName(id, name));
    }

    public MGenre getMGenreByName (String name){
        return new MGenre(genreRepo.findByName(name));
    }
}
