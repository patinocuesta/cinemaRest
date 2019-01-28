package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.ReviewEntity;
import online.patino.cinemaRest.entity.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class ReviewModel implements Serializable {
    private long id;
    private String article;
    private Timestamp date;
    private FilmEntity filmModel;
    private UserEntity userModel;

    public ReviewModel(){}
    public ReviewModel (Long id, String article, Timestamp date, FilmEntity filmModel, UserEntity userModel){
        this.id=id;
        this.article=article;
        this.date=date;
        this.filmModel=filmModel;
        this.userModel=userModel;
    }
    public ReviewModel(ReviewEntity reviewEntity){
        this.id=reviewEntity.getId();
        this.article=reviewEntity.getArticle();
        this.date=reviewEntity.getDate();
        this.filmModel=reviewEntity.getFilmEntity();
        this.userModel=reviewEntity.getUserEntity();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) {
        this.article = article;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public FilmEntity getFilmModel() {
        return filmModel;
    }
    public void setFilmModel(FilmEntity filmModel) {
        this.filmModel = filmModel;
    }
    public UserEntity getUserModel() {
        return userModel;
    }
    public void setUserModel(UserEntity userModel) {
        this.userModel = userModel;
    }
}
