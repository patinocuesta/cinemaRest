package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.entity.PlayEntity;

import java.io.Serializable;

public class PlayModel implements Serializable {
    private Long id;
    private FilmEntity filmModel;
    private PersonEntity personModel;
    private Integer rank;
    private String name;

    private PlayModel(){}

    public PlayModel(Long id, FilmEntity filmModel, PersonEntity personModel, Integer rank, String name){
        this.id= id;
        this.filmModel = filmModel;
        this.personModel = personModel;
        this.rank = rank;
        this.name = name;
    }
    public PlayModel(PlayEntity playEntity){
        this.id= playEntity.getId();
        this.filmModel = playEntity.getFilmEntity();
        this.personModel = playEntity.getPersonEntity();
        this.rank = playEntity.getRank();
        this.name = playEntity.getName();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public FilmEntity getFilmEntity() {
        return filmModel;
    }
    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmModel = filmEntity;
    }
    public PersonEntity getPersonEntity() {
        return personModel;
    }
    public void setPersonEntity(PersonEntity personEntity) {
        this.personModel = personEntity;
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
