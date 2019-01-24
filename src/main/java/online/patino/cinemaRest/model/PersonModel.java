package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.PersonEntity;

import java.util.Date;

public class PersonModel {

    private Long id;
    private String surname;
    private String givenname;
    private String image_path;
    private Date birthday;

    //Nuestro Constructor
    public PersonModel(Long id, String surname, String givenname, String image_path, Date birthday) {
        this.id = id;
        this.surname = surname;
        this.givenname = givenname;
        this.image_path = image_path;
        this.birthday = birthday;
    }

    //Constructor avec personEntity como argumento para pasar de entidad a modelo
    public PersonModel(PersonEntity personEntity) {
        this.id = personEntity.getId();
        this.surname = personEntity.getSurname();
        this.givenname = personEntity.getGivenname();
        this.image_path = personEntity.getImage_path();
        this.birthday = personEntity.getBirthday();
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGivenname() {
        return givenname;
    }
    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
