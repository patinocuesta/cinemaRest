package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserRepoDao extends JpaRepository<UserEntity, Serializable> {
    UserEntity findById (Long id);
    UserEntity findByLoginAndPassword (String login, String password);

}
