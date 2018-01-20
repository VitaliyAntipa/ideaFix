package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "id")
    @JsonIgnore
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
