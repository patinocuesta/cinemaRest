package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.FilmModel;
import online.patino.cinemaRest.model.GenreModel;
import online.patino.cinemaRest.service.FilmManager;
import online.patino.cinemaRest.service.GenreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {
    @Autowired
    @Qualifier("FilmService")
    FilmManager filmservice;
    @Autowired
    @Qualifier("GenreService")
    GenreManager genreManager;
    @PostMapping ("/list")
    public List<FilmModel> listFilms(){return  filmservice.getListMFilm();}
    @PostMapping ("/{id}/films")
        public List<FilmModel> listFilmsGenre(@PathVariable ("id") Long id){
        GenreModel genreModel = genreManager.getMGenreById(id) ;
        GenreEntity genreEntity = new GenreEntity(id, genreModel.getName());
        return filmservice.findFilmsByGenre(genreEntity);
        }
    @PutMapping("/create")
    public boolean createFilm (@RequestBody @Valid FilmEntity filmEntity){return filmservice.create(filmEntity);}
    @PostMapping ("/edit")
    public boolean editFilm (@RequestBody @Valid FilmEntity filmEntity){
        return filmservice.update(filmEntity);
    }
    @DeleteMapping("/delete/{title}/{id}")
    public boolean deleteFilm (@PathVariable ("id") Long id, @PathVariable ("title") String title){
        return filmservice.delete(id);
    }
}
