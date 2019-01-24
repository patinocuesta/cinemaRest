package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository ("FilmRepo")
public interface FilmRepoDao extends JpaRepository<FilmEntity, Serializable> {
    FilmEntity findById(Long Id);
    List<FilmEntity> findByTitle (String title);
    FilmEntity findByTitleAndId(String title, Long id);
    List<FilmEntity>findFilmsByGenres(GenreEntity genreEntity);


}
