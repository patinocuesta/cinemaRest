package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.ReviewEntity;
import online.patino.cinemaRest.entity.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


public class UserModel implements Serializable {

    private long id;
    private String surname;
    private String givenname;
    private String login;
    private String password;
    private Set<ReviewEntity> reviewEntities;

    public UserModel (){}
    public UserModel (Long id,String surname,String givenname,String login,String password,Set<ReviewEntity> reviewEntities){
        this.id =  id;
        this.surname = surname;
        this.givenname = givenname;
        this.login = login;
        this.password = password;
        this.reviewEntities =reviewEntities;
    }
    public UserModel (UserEntity userEntity){
        this.id = userEntity.getId();
        this.surname =userEntity.getSurname() ;
        this.givenname =userEntity.getGivenname() ;
        this.login =userEntity.getLogin() ;
        this.password = userEntity.getPassword();
        this.reviewEntities =userEntity.getReviewEntities();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<ReviewEntity> getReviewEntities() {
        return reviewEntities;
    }
    public void setReviewEntities(Set<ReviewEntity> reviewEntities) {
        this.reviewEntities = reviewEntities;
    }


}
