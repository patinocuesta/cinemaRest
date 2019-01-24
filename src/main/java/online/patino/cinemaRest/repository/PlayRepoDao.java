package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.entity.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository ("PlayRepo")
public interface PlayRepoDao extends JpaRepository<PlayEntity, Serializable> {
    PlayEntity findById(Long Id);
    List<PlayEntity> findByName (String name);
    PlayEntity findByIdAndName(Long id, String name);
    List<PlayEntity> findByPerson (PersonEntity personEntity);
    List<PlayEntity> findByFilm (FilmEntity filmEntity);
    PlayEntity findByIdAndFilmAndPerson(Long id, FilmEntity filmEntity, PersonEntity personEntity);
    PlayEntity findByIdAndFilm (Long id, FilmEntity filmEntity);
    PlayEntity findByIdAndPerson (Long id, PersonEntity personEntity);
    List<PlayEntity> findByFilmAndPerson (FilmEntity filmEntity, PersonEntity personEntity);

}
