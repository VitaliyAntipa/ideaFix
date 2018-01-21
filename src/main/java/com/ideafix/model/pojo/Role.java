package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Embeddable public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="role_id_seq")
    @SequenceGenerator(name="role_id_seq", sequenceName="role_id_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
