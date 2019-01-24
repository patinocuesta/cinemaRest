package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CGenre;
import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.GenreModel;
import online.patino.cinemaRest.repository.GenreRepoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GenreService")
public class GenreManager {
    @Autowired
    @Qualifier("GenreRepo")
    private GenreRepoDao genreRepoDao;

    @Autowired
    @Qualifier("CGenre")
    private CGenre cgenre;

    public boolean create (GenreEntity genreEntity){
        try{
            genreRepoDao.save(genreEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (GenreEntity genreEntity){
        try{
            genreRepoDao.save(genreEntity);
            return true;
        }catch(Exception e){

            return false;
        }
    }
    public boolean delete (Long id){
        try{

            GenreEntity genreEntity = genreRepoDao.findById(id);
            genreRepoDao.delete(genreEntity);
            return true;
        }catch(Exception e){
            GenreEntity genreEntity = genreRepoDao.findById(id);
            if(genreEntity.getFilmEntities().size()>0){ throw new IllegalStateException("le genreEntity '"+ genreEntity.getName()+"' est associé à des films");}
            return false;
        }
    }

    public GenreModel getMGenreById (Long id){
        return new GenreModel(genreRepoDao.findById(id));
    }

    public List<GenreModel> getListMGenre(){
        return cgenre.converList(genreRepoDao.findAll());
    }

    public GenreModel getMGenreByIdAndName (Long id, String name){
        return new GenreModel(genreRepoDao.findByIdAndName(id, name));
    }

    public GenreModel getMGenreByName (String name){
        return new GenreModel(genreRepoDao.findByName(name));
    }
}
