package com.ideafix.model.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractUser {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_name")
    private String nickname;

    @Column(name = "picture")
    private String pic;

    @Column(name = "is_banned")
    private boolean isBanned;

    public AbstractUser() {
    }

    public AbstractUser(long id, String name, String nickname, String pic, boolean isBanned) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.pic = pic;
        this.isBanned = isBanned;
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
}
