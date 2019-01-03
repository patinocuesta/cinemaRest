package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Repository ("FilmRepo")
public interface FilmRepo extends JpaRepository<Film, Serializable> {
    Film findById(Long Id);
    List<Film> findByTitle (String title);
    Film findByIdAndTitle(Long id, String title);


}
