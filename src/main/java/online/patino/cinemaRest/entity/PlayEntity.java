package online.patino.cinemaRest.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="play")
public class PlayEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @MapsId("filmId")
    private FilmEntity filmEntity;

    @ManyToOne(fetch = LAZY)
    @MapsId("person_Id")
    private PersonEntity personEntity;

    @Column(name="rank")
    private Integer rank;

    @Column(name="name")
    private String name;

    private PlayEntity(){}

    public PlayEntity(Long id, FilmEntity filmEntity, PersonEntity personEntity, Integer rank, String name){
        this.id= id;
        this.filmEntity = filmEntity;
        this.personEntity = personEntity;
        this.rank = rank;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public FilmEntity getFilmEntity() {
        return filmEntity;
    }
    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }
    public PersonEntity getPersonEntity() {
        return personEntity;
    }
    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
