package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class ShortUser extends AbstractUser implements Serializable {
    public ShortUser() {
    }

    public ShortUser(String name, String nickname, String password, String pic) {
        super(name, nickname, password, pic);
    }

    public ShortUser(User author) {
        super(author.getName(), author.getNickname(), author.getPassword(), author.getPic());
    }
}
