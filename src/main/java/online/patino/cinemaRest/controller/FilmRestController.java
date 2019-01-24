package online.patino.cinemaRest.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Genre;
import online.patino.cinemaRest.repository.GenreRepo;
import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.model.MFilm;
import online.patino.cinemaRest.model.MGenre;
import online.patino.cinemaRest.service.FilmService;
import online.patino.cinemaRest.service.GenreService;
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
    FilmService filmservice;
    @Autowired
    @Qualifier("GenreService")
    GenreService genreService;
    @PostMapping ("/list")
    public List<MFilm> listFilms(){return  filmservice.getListMFilm();}
    @PostMapping ("/{id}/films")
        public List<MFilm> listFilmsGenre(@PathVariable ("id") Long id){
        MGenre mGenre = genreService.getMGenreById(id) ;
        Genre genre = new Genre(id, mGenre.getName());
        return filmservice.findFilmsByGenre(genre);
        }
    @PutMapping("/create")
    public boolean createFilm (@RequestBody @Valid Film film){return filmservice.create(film);}
    @PostMapping ("/edit")
    public boolean editFilm (@RequestBody @Valid Film film){
        return filmservice.update(film);
    }
    @DeleteMapping("/delete/{title}/{id}")
    public boolean deleteFilm (@PathVariable ("id") Long id, @PathVariable ("title") String title){
        return filmservice.delete(id, title);
    }
}
