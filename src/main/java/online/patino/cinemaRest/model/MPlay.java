package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.Film;
import online.patino.cinemaRest.entity.Person;
import online.patino.cinemaRest.entity.Play;

public class MPlay {
    private Long id;
    private Film film;
    private Person person;
    private Integer rank;
    private String name;

    private MPlay(){}

    public MPlay(Long id, Film film, Person person, Integer rank, String name){
        this.id= id;
        this.film= film;
        this.person= person;
        this.rank = rank;
        this.name = name;
    }
    public MPlay(Play play){
        this.id= play.getId();
        this.film= play.getFilm();
        this.person= play.getPerson();
        this.rank = play.getRank();
        this.name = play.getName();
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
