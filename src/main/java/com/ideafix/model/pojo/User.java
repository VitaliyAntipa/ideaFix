package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

//    ?
    private Role role;

    @Column(name = "email")
    private String email;

    @Column(name = "nick_name")
    private String nickname;

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

    //    ?
    private List<IdeaList> ideaLists;

    public User(long id, String name,
                int age, Role role, String email,
                String nickname, String city,
                String country, String about, String pic,
                boolean isBanned, List<IdeaList> ideaLists) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.email = email;
        this.nickname = nickname;
        this.city = city;
        this.country = country;
        this.about = about;
        this.pic = pic;
        this.isBanned = isBanned;
        this.ideaLists = ideaLists;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public List<IdeaList> getIdeaLists() {
        return ideaLists;
    }

    public void setIdeaLists(List<IdeaList> ideaLists) {
        this.ideaLists = ideaLists;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
