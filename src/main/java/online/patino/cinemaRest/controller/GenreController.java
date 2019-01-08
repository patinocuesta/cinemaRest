package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Genre;
import online.patino.cinemaRest.service.FilmService;
import online.patino.cinemaRest.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    @Qualifier("GenreService")
    GenreService genreService;

    @PutMapping("/create")
    public boolean createGenre (@RequestBody @Valid Genre genre){
        return genreService.create(genre);
    }
    @PostMapping("/edit")
    public boolean editGenre (@RequestBody @Valid Genre genre){
        return genreService.update(genre);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFilm (@PathVariable ("id") Long id){
        return genreService.delete(id);
    }
}

