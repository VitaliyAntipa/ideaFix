package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "idealist")
public class IdeaList implements Serializable{

    @Id
    @Column(name = "id",insertable = false, updatable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_private")
    private boolean isPrivate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "idealist_idea",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "idea_id")
    )
    private Set<Idea> setOfIdeas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private ShortUser author;

    public IdeaList(long id, String name, boolean isPrivate, Set<Idea> setOfIdeas) {
        this.id = id;
        this.name = name;
        this.isPrivate = isPrivate;
        this.setOfIdeas = setOfIdeas;
    }

    public IdeaList() {
    }

    public String getName() {
        return name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Set<Idea> getSetOfIdeas() {
        return setOfIdeas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setSetOfIdeas(Set<Idea> setOfIdeas) {
        this.setOfIdeas = setOfIdeas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public ShortUser getAuthor() {
        return author;
    }

    public void setAuthor(ShortUser author) {
        this.author = author;
    }
}
