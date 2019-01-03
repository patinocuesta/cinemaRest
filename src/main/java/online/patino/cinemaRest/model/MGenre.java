package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.Genre;

public class MGenre {
    private Long id;
    private String name;

    public MGenre(){}
    public MGenre(Long id, String name){
        this.id= id;
        this.name = name;
    }

    public MGenre(Genre genre){
        this.id= genre.getId();
        this.name = genre.getName();
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
