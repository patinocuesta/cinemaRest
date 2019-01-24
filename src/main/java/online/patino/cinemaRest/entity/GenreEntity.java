package online.patino.cinemaRest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "genres")
    private Set<FilmEntity> filmEntities;
    private GenreEntity(){}

    public GenreEntity(Long id, String name){
        this.id= id;
        this.name = name;
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

    public Set<FilmEntity> getFilmEntities() {
        return filmEntities;
    }
    public void setFilmEntities(Set<FilmEntity> filmEntities) {
        this.filmEntities = filmEntities;
    }
}
