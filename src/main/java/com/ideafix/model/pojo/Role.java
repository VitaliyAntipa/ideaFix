package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    @JsonIgnore
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


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
