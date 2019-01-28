package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.DtoToEntity.DtoToEntityFilm;
import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.FilmModel;
import online.patino.cinemaRest.repository.FilmRepoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FilmService")
public class FilmManager {
    @Autowired
    @Qualifier ("FilmRepo")
    private FilmRepoDao filmRepoDao;
    @Autowired
    @Qualifier ("CFilm")
    private DtoToEntityFilm cfilm;

    public boolean create (FilmEntity filmEntity){
        try{
            filmRepoDao.save(filmEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (FilmEntity filmEntity){
        try{
           filmRepoDao.save(filmEntity);

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id){
        try{
            FilmEntity filmEntity = filmRepoDao.findById(id);
            filmRepoDao.delete(filmEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public FilmModel getFilmModelById (Long id) {return new FilmModel(filmRepoDao.findById(id));}
    public List<FilmModel> getAllFilmModel(){
        return cfilm.converList(filmRepoDao.findAll());
    }
    public List<FilmModel> findFilmsModelByGenre(GenreEntity genreEntity){return cfilm.converList(filmRepoDao.findFilmsByGenres(genreEntity));}
    public FilmModel getFilmModelByTitleAndId (Long id, String title){return new FilmModel(filmRepoDao.findByTitleAndId(title, id));}
    public List<FilmModel> getFilmModelByTitle (String title){return cfilm.converList(filmRepoDao.findByTitle(title));}
}
