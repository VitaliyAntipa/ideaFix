package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class ShortUser extends AbstractUser implements Serializable {

    ShortUser(User author) {
        super(author.getId(),author.getName(), author.getNickname(), author.getPassword(), author.getPic());
    }
}
