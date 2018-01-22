package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users")
@Table(name = "users")
public class User extends AbstractUser implements Serializable {

    @Column(name = "age")
    private int age;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", updatable = false)
    private Role role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "about")
    private String about;

    public User(String name, String nickname, String password,
                String pic, int age, String email,
                String city, String country, String about) {
        super(name, nickname, password, pic);
        this.age = age;
        this.email = email;
        this.city = city;
        this.country = country;
        this.about = about;
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
}
