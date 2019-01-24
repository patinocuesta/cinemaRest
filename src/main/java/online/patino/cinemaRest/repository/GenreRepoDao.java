package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("GenreRepo")
public interface GenreRepoDao extends JpaRepository<GenreEntity, Serializable> {
    GenreEntity findById(Long Id);
    GenreEntity findByName (String name);
    GenreEntity findByIdAndName(Long id, String name);

}
