package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Person;

import java.util.Date;

public class MFilm {
    private Long id;
    private String title;
    private Double rating;
    private String image_path;
    private String summary;
    private Person film_director;
    private Date release_date;

    //Constructor default
    public MFilm (){}

    public MFilm(Long id, String title, double rating, String image_path, String summary, Person film_director, Date release_date){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.image_path = image_path;
        this.summary = summary;
        this.film_director = film_director;
        this.release_date = release_date;

    }
    //Constructor avec film como argumento para pasar de entidad a modelo

    public MFilm(Film film){
        this.id = film.getId();
        this.title = film.getTitle();
        this.rating = film.getRating();
        this.image_path = film.getImage_path();
        this.summary = film.getSummary();
        this.film_director = film.getFilm_director();
        this.release_date = film.getRelease_date();
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
    public Person getFilm_director() {
        return film_director;
    }
    public void setFilm_director(Person film_director) {
        this.film_director = film_director;
    }
    public Date getRelease_date() {
        return release_date;
    }
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
