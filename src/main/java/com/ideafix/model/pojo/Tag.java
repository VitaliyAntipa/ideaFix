package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tag_id_seq")
    @SequenceGenerator(name="tag_id_seq", sequenceName="tag_id_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {

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
