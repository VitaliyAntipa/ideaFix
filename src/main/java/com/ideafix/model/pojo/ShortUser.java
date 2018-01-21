package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class ShortUser extends AbstractUser implements Serializable {
    public ShortUser() {
    }

    public ShortUser(String name, String nickname, String pic) {
        super(name, nickname, null, pic);
    }

    public ShortUser(User author) {
        super(author.getName(), author.getNickname(), null, author.getPic());
    }
}
