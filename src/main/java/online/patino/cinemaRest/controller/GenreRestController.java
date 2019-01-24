package online.patino.cinemaRest.controller;

import online.patino.cinemaRest.entity.GenreEntity;
import online.patino.cinemaRest.model.GenreModel;
import online.patino.cinemaRest.service.GenreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreRestController {
    @Autowired
    @Qualifier("GenreService")
    GenreManager genreManager;

    @GetMapping("/list")
    public List<GenreModel> listGenre (){return  genreManager.getListMGenre();}
    @PutMapping("/create")
    public boolean createGenre (@RequestBody @Valid GenreEntity genreEntity){
        return genreManager.create(genreEntity);
    }
    @PostMapping("/edit")
    public boolean editGenre (@RequestBody @Valid GenreEntity genreEntity){
        return genreManager.update(genreEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFilm (@PathVariable ("id") Long id){
        return genreManager.delete(id);
    }
}

