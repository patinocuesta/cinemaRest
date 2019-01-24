package online.patino.cinemaRest.model;

import online.patino.cinemaRest.entity.ReviewEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "surname", nullable = true, length = 40)
    private String surname;
    @Basic
    @Column(name = "givenname", nullable = true, length = 30)
    private String givenname;
    @Basic
    @Column(name = "login", nullable = false, length = 20)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 120)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReviewEntity> reviewEntities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

   public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ReviewEntity> getReviewEntities() {
        return reviewEntities;
    }

    public void setReviewEntities(Set<ReviewEntity> reviewEntities) {
        this.reviewEntities = reviewEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != userModel.id) return false;
        if (surname != null ? !surname.equals(userModel.surname) : userModel.surname != null) return false;
        if (givenname != null ? !givenname.equals(userModel.givenname) : userModel.givenname != null) return false;
        if (login != null ? !login.equals(userModel.login) : userModel.login != null) return false;
        if (password != null ? !password.equals(userModel.password) : userModel.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (givenname != null ? givenname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
