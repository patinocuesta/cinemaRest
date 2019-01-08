package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository ("PlayRepo")
public interface PlayRepo extends JpaRepository<Play, Serializable> {
    Play findById(Long Id);
    List<Play> findByName (String name);
    Play findByIdAndName(Long id, String name);
    List<Play> findByPerson (Person person);
    List<Play> findByFilm (Film film);
    Play findByIdAndFilmAndPerson(Long id, Film film, Person person);
    Play findByIdAndFilm (Long id, Film film);
    Play findByIdAndPerson (Long id, Person person);
    List<Play> findByFilmAndPerson (Film film, Person person);

}
