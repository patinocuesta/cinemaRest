package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Genre;
import online.patino.cinemaRest.model.MGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository ("FilmRepo")
public interface FilmRepo extends JpaRepository<Film, Serializable> {
    Film findById(Long Id);
    List<Film> findByTitle (String title);
    Film findByTitleAndId(String title, Long id);
    List<Film>findFilmsByGenres(Genre genre);


}
