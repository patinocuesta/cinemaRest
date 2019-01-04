package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    @Qualifier("FilmService")
    FilmService filmservice;

    @PutMapping("/create")
    public boolean createFilm (@RequestBody @Valid Film film){
        return filmservice.create(film);
    }
    @PostMapping ("/edit")
    public boolean editFilm (@RequestBody @Valid Film film){
        return filmservice.update(film);
    }
    @DeleteMapping("/delete/{title}/{id}")
    public boolean deleteFilm (@PathVariable ("id") Long id,
                               @PathVariable ("title") String title){
        return filmservice.delete(id, title);
    }
}
