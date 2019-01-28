package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("GenreRepo")
public interface GenreRepoDao extends JpaRepository<GenreEntity, Serializable> {
    GenreEntity findById(Long Id);
    GenreEntity findByName (String name);
    List<GenreEntity> findByIdFilm(Long id);
}
