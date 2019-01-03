package online.patino.cinemaRest.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="play")
public class Play implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @MapsId("filmId")
    private Film film;

    @ManyToOne(fetch = LAZY)
    @MapsId("person_Id")
    private Person person;

    @Column(name="rank")
    private Integer rank;

    @Column(name="name")
    private String name;

    private Play(){}

    public Play(Long id, Film film, Person person, Integer rank, String name){
        this.id= id;
        this.film= film;
        this.person= person;
        this.rank = rank;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
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
