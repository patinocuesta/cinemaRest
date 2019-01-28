package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Repository("PersonRepo")
public interface PersonRepoDao extends JpaRepository<PersonEntity, Serializable> {
    PersonEntity findById(Long Id);
    List<PersonEntity> findByGivenname(String givenname);
    List<PersonEntity> findBySurname(String surname);
    List<PersonEntity> findByGivennameAndSurname(String givenname, String surname);
    List<PersonEntity> findByBirthday (Date birthday);
    List<PersonEntity> findByFilms (Long id);
    List<PersonEntity> findByPlayId (Long id);

}
