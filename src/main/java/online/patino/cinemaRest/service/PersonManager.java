package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CPerson;
import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.model.PersonModel;
import online.patino.cinemaRest.repository.PersonRepoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PersonService")
public class PersonManager {
    @Autowired
    @Qualifier ("PersonRepo")
    private PersonRepoDao personRepoDao;

    @Autowired
    @Qualifier ("CPerson")
    private CPerson cperson;

    public boolean create (PersonEntity personEntity){
        try{
            personRepoDao.save(personEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (PersonEntity personEntity){
        try{
            personRepoDao.save(personEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id,String givenname, String surname){
        try{
            PersonEntity personEntity = personRepoDao.findByIdAndGivennameAndSurname(id, givenname, surname);
            personRepoDao.delete(personEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public PersonModel getMPersonById (Long id){
        return new PersonModel(personRepoDao.findById(id));
    }

    public PersonModel getMPersonByIdGivennameSurname(Long id, String givenname, String surname){
        return new PersonModel(personRepoDao.findByIdAndGivennameAndSurname(id, givenname, surname));
    }
    public List<PersonModel> getListMPerson(){
        return cperson.converList(personRepoDao.findAll());
    }

    public List<PersonModel> getMPersonByGivennameSurname(String givenname, String surname){
        return cperson.converList(personRepoDao.findByGivennameAndSurname(givenname, surname));
    }
    public List<PersonModel> getMPersonBySurname(String surname){
        return cperson.converList(personRepoDao.findBySurname(surname));
    }
    public List<PersonModel> getMPersonByGivenname(String givenname){
        return cperson.converList(personRepoDao.findByGivenname(givenname));
    }
}
