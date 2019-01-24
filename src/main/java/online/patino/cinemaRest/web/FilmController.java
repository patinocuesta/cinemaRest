package online.patino.cinemaRest.web;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Play;
import online.patino.cinemaRest.model.MFilm;
import online.patino.cinemaRest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/film")
public class FilmController {


    @Autowired
    FilmService filmManager;
    @Autowired
    PersonService personManager;
    @Autowired
    GenreService genreManager;
    @Autowired
    PlayService playManager;


    @Autowired
    ImageService imm;

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<MFilm> films = filmManager.getListMFilm();
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
        model.addAttribute("film", new Film());
        return "film/form";
    }

    @GetMapping("/mod/{id}")
    public String mod(@PathVariable("id") long id, Model model) {
        MFilm film = filmManager.getMFilmById(id);
        model.addAttribute("title", film.getTitle() + " : modification");
        model.addAttribute("persons", personManager.getListMPerson());
        model.addAttribute("genresFilm", genreManager.getListMGenre());
        model.addAttribute("film", film);
        model.addAttribute("plays", playManager.getListMPlay());
        model.addAttribute("newrole", new Play());
        return "film/form";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute Film film) {
        filmManager.create(film);
        return "redirect:list";
    }

    @GetMapping("/rmrole/{id}")
    public String rmRole(@PathVariable("id") Long id) {
        filmManager.delete(id);
        return "redirect:/film/mod/" + filmId;
    }

    @PostMapping("/addrole")
    public String addRole(@ModelAttribute Play role) {
        long filmId = role.getFilm().getId();
        playManager.create();
        return "redirect:/film/mod/" + filmId;
    }

    @PostMapping("/modrole/{id}")
    public String modRole(@PathVariable("id") long roleId, @ModelAttribute Play role) {
        filmManager.saveRole(role);
        return "redirect:/film/mod/" + role.getFilm().getId();
    }


}
