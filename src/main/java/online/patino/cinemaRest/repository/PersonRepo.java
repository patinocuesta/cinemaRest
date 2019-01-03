package online.patino.cinemaRest.repository;

import online.patino.cinemaRest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Repository("PersonRepo")
public interface PersonRepo extends JpaRepository<Person, Serializable> {
    Person findById(Long Id);
    List<Person> findByGivenname(String givenname);
    List<Person> findBySurname(String surname);
    List<Person> findByGivennameAndSurname(String givenname, String surname);
    Person findByIdAndGivennameAndSurname(Long id,String givenname, String surname);
    List<Person> findByBirthday (Date birthday);

}
