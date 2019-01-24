package online.patino.cinemaRest.web;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.PlayEntity;
import online.patino.cinemaRest.model.FilmModel;
import online.patino.cinemaRest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/film")
public class FilmController {


    @Autowired
    FilmManager filmManager;
    @Autowired
    PersonManager personManager;
    @Autowired
    GenreManager genreManager;
    @Autowired
    ImageManager imm;

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<FilmModel> films = filmManager.getListMFilm();
        model.addAttribute("films", films);
        return "film/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        model.addAttribute("film", filmManager.getMFilmById(id));
        return "film/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Ajout d'un film");
        model.addAttribute("film", new FilmEntity());
        return "film/form";
    }

    @GetMapping("/mod/{id}")
    public String mod(@PathVariable("id") long id, Model model) {
        FilmModel film = filmManager.getMFilmById(id);
        model.addAttribute("title", film.getTitle() + " : modification");
        model.addAttribute("persons", personManager.getListMPerson());
        model.addAttribute("genresFilm", genreManager.getListMGenre());
        model.addAttribute("film", film);
       // model.addAttribute("plays", film.);
     //   model.addAttribute("newrole", new PlayEntity());
        return "film/form";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute FilmEntity filmEntity) {
        filmManager.create(filmEntity);
        return "redirect:list";
    }

    @GetMapping("/rmrole/{id}")
    public String rmRole(@PathVariable("id") Long id) {
        filmManager.delete(id);
       // return "redirect:/film/mod/" + filmId;
    }

    @PostMapping("/addrole")
    public String addRole(@ModelAttribute PlayEntity role) {
        long filmId = role.getFilmEntity().getId();
       // playManager.create();
        return "redirect:/film/mod/" + filmId;
    }

    @PostMapping("/modrole/{id}")
    public String modRole(@PathVariable("id") long roleId, @ModelAttribute PlayEntity role) {
     //   filmManager.saveRole(role);
        return "redirect:/film/mod/" + role.getFilmEntity().getId();
    }


}
