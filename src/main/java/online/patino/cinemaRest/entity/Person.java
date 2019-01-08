package online.patino.cinemaRest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "surname", nullable = false, length = 60)
    private String surname;
    @Column(name = "givenname", nullable = false, length = 40)
    private String givenname;
    @Column(name = "image_path", nullable = false, length = 80)
    private String image_path;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JsonBackReference
    @OneToMany(mappedBy = "film_director")
    private Set<Film> filmsReal;

    @OneToMany(
            mappedBy = "person",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
           // orphanRemoval = true
    )
    private Set<Play> persons;

//Constructor vacio para uso de Hibernate
    public Person(){}

//Nuestro Constructor
    public Person(Long id, String surname, String givenname, String image_path, Date birthday) {
        this.id = id;
        this.surname = surname;
        this.givenname = givenname;
        this.image_path = image_path;
        this.birthday = birthday;
    }

//Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGivenname() {
        return givenname;
    }
    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Film> getFilmsReal() {
        return filmsReal;
    }
    public void setFilmsReal(Set<Film> filmsReal) {
        this.filmsReal = filmsReal;
    }
    public Set<Play> getPersons() {
        return persons;
    }
    public void setPersons(Set<Play> persons) {
        this.persons = persons;
    }
}
