package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.GenreEntity;

public class GenreModel {
    private Long id;
    private String name;

    public GenreModel(){}
    public GenreModel(Long id, String name){
        this.id= id;
        this.name = name;
    }

    public GenreModel(GenreEntity genreEntity){
        this.id= genreEntity.getId();
        this.name = genreEntity.getName();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
