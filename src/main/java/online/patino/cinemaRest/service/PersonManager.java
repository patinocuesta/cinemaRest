package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.DtoToEntity.DtoToEntityPerson;
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
    private DtoToEntityPerson cperson;

    public boolean create (PersonModel personModel){
        try{
            personRepoDao.save(personModel);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (PersonModel personModel){
        try{
            personRepoDao.save(personModel);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id,String givenname, String surname){
        try{
            PersonModel personModel = personRepoDao.findByIdAndGivennameAndSurname(id, givenname, surname);
            personRepoDao.delete(personModel);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public PersonModel getPersonModelById (Long id){ return new PersonModel(personRepoDao.findById(id));
    }

    public List<PersonModel> findPersonsModelByFilmId(Long id){
        return cperson.converList(personRepoDao.findPersonsByFilmId(id));
    }
    public List<PersonModel> getListMPerson(){
        return cperson.converList(personRepoDao.findAll());
    }

    public List<PersonModel> getPersonModelByGivennameSurname(String givenname, String surname){
        return cperson.converList(personRepoDao.findByGivennameAndSurname(givenname, surname));
    }
    public List<PersonModel> getPersonModelBySurname(String surname){
        return cperson.converList(personRepoDao.findBySurname(surname));
    }
    public List<PersonModel> getMPersonModelByGivenname(String givenname){
        return cperson.converList(personRepoDao.findByGivenname(givenname));
    }
}
