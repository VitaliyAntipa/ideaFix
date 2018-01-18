package com.ideafix.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role() {

    }

    public Role(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
