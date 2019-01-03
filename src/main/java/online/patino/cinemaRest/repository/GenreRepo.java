package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("GenreRepo")
public interface GenreRepo extends JpaRepository<Genre, Serializable> {
    Genre findById(Long Id);
    Genre findByName (String name);
    Genre findByIdAndName(Long id, String name);
}
