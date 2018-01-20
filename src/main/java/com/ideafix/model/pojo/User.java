package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractUser implements Serializable {

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "about")
    private String about;

    @Column(name = "picture")
    private String pic;

    @Column(name = "is_banned")
    private boolean isBanned;

    public User(String name, String nickname,
                String pic, boolean isBanned,
                int age, Role role, String email,
                String city, String country, String about,
                String pic1, boolean isBanned1) {
        super(name, nickname, pic, isBanned);
        this.age = age;
        this.role = role;
        this.email = email;
        this.city = city;
        this.country = country;
        this.about = about;
        this.pic = pic1;
        this.isBanned = isBanned1;
    }

    public User() {
        super();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
