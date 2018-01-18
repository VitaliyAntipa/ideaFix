package com.ideafix.model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    public Tag() {

    }

    public Tag(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
