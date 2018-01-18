package com.ideafix.model.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "IdeaList")
public class IdeaList {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_private")
    private boolean isPrivate;

//    ?
    private List<Idea> listOfIdeas;

//    ?
    private User author;

    public IdeaList(long id, String name, boolean isPrivate, List<Idea> listOfIdeas) {
        this.id = id;
        this.name = name;
        this.isPrivate = isPrivate;
        this.listOfIdeas = listOfIdeas;
    }

    public IdeaList() {
    }

    public String getName() {
        return name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public List<Idea> getListOfIdeas() {
        return listOfIdeas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setListOfIdeas(List<Idea> listOfIdeas) {
        this.listOfIdeas = listOfIdeas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
