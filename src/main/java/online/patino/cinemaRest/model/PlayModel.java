package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.FilmEntity;
import online.patino.cinemaRest.entity.PersonEntity;
import online.patino.cinemaRest.entity.PlayEntity;

public class PlayModel {
    private Long id;
    private FilmEntity filmEntity;
    private PersonEntity personEntity;
    private Integer rank;
    private String name;

    private PlayModel(){}

    public PlayModel(Long id, FilmEntity filmEntity, PersonEntity personEntity, Integer rank, String name){
        this.id= id;
        this.filmEntity = filmEntity;
        this.personEntity = personEntity;
        this.rank = rank;
        this.name = name;
    }
    public PlayModel(PlayEntity playEntity){
        this.id= playEntity.getId();
        this.filmEntity = playEntity.getFilmEntity();
        this.personEntity = playEntity.getPersonEntity();
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
