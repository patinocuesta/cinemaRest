package online.patino.cinemaRest.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "films")
@Entity

public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "rating", nullable = false)
    private Double rating;
    @Column(name = "image_path", nullable = false, length = 120)
    private String image_path;
    @Column(name = "summary", nullable = false)
    private String summary;
    @ManyToOne @JoinColumn(name = "film_director")
    private Person film_director;
    @Column(name = "release_date", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date release_date;

    @OneToMany(
            mappedBy = "film",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Play> persons;

    @ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;


//Constructor vacio para uso de Hibernate
    public Film(){}
//Constructor
    public Film(Long id, String title, double rating, String image_path, String summary, Person film_director, Date release_date){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.image_path = image_path;
        this.summary = summary;
        this.film_director = film_director;
        this.release_date = release_date;
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
    public void setTitle(String title) {this.title = title;}
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

    public Set<Play> getPersons() {
        return persons;
    }
    public void setPersons(Set<Play> persons) {
        this.persons = persons;
    }
    public Set<Genre> getGenres() {
        return genres;
    }
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
