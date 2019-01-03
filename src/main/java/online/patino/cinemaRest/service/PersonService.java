package online.patino.cinemaRest.service;

import online.patino.cinemaRest.converter.CPerson;
import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.model.MPerson;
import online.patino.cinemaRest.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PersonService")
public class PersonService {
    @Autowired
    @Qualifier ("PersonRepo")
    private PersonRepo personRepo;

    @Autowired
    @Qualifier ("CPerson")
    private CPerson cperson;

    public boolean create (Person person){
        try{
            personRepo.save(person);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update (Person person){
        try{
            personRepo.save(person);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean delete (Long id,String givenname, String surname){
        try{
            Person person= personRepo.findByIdAndGivennameAndSurname(id, givenname, surname);
            personRepo.delete(person);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public MPerson getMPersonByIdGivennameSurname(Long id,String givenname, String surname){
        return new MPerson(personRepo.findByIdAndGivennameAndSurname(id,givenname,surname));
    }
    public List<MPerson> getListMPerson(){
        return cperson.converList(personRepo.findAll());
    }

    public List<MPerson> getMPersonByGivennameSurname(String givenname, String surname){
        return cperson.converList(personRepo.findByGivennameAndSurname(givenname, surname));
    }
    public List<MPerson> getMPersonBySurname(String surname){
        return cperson.converList(personRepo.findBySurname( surname));
    }
    public List<MPerson> getMPersonByGivenname(String givenname){
        return cperson.converList(personRepo.findByGivenname(givenname));
    }
}
