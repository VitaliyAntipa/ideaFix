package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@MappedSuperclass
public class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_name", nullable =  false)
    private String nickname;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "picture")
    private String pic;

    @Column(name = "is_banned", nullable =  false)
    private boolean isBanned;

    public AbstractUser() {
    }

    public AbstractUser(String name, String nickname, String password, String pic) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.pic = pic;
        this.isBanned = false;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pic='" + pic + '\'' +
                ", isBanned=" + isBanned +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
