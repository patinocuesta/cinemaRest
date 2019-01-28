package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.PersonEntity;

import java.io.Serializable;
import java.util.Date;

public class FilmModel implements Serializable {
    private Long id;
    private String title;
    private Double rating;
    private String image_path;
    private String summary;
    private PersonEntity film_director;
    private Date release_date;

    //Constructor default
    public FilmModel(){}

    public FilmModel(Long id, String title, double rating, String image_path, String summary, PersonEntity film_director, Date release_date){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.image_path = image_path;
        this.summary = summary;
        this.film_director = film_director;
        this.release_date = release_date;

    }
    //Constructor avec film como argumento para pasar de entidad a modelo

    public FilmModel(FilmEntity filmEntity){
        this.id = filmEntity.getId();
        this.title = filmEntity.getTitle();
        this.rating = filmEntity.getRating();
        this.image_path = filmEntity.getImage_path();
        this.summary = filmEntity.getSummary();
        this.film_director = filmEntity.getFilm_director() ;
        this.release_date = filmEntity.getRelease_date();
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public PersonEntity getFilm_director() {
        return film_director;
    }
    public void setFilm_director(PersonEntity film_director) {
        this.film_director = film_director;
    }
    public Date getRelease_date() {
        return release_date;
    }
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
