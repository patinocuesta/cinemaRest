package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface ReviewRepoDao extends JpaRepository<ReviewEntity, Serializable> {
    ReviewEntity findById (Long id);
    List<ReviewEntity> findByFilmEntity_Id (Long Id);
    List<ReviewEntity> findByUserEntityId (Long Id);
}
