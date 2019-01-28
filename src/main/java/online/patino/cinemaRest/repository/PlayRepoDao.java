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
    List<PlayEntity> findByPersonId (Long id);
    List<PlayEntity> findByFilmId (Long id);
    List<PlayEntity> findByPersonIdaAndFilmId (Long IdPerson, Long IdFilm);
}
