package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "idealist")
public class IdeaList implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="idealist_id_seq")
    @SequenceGenerator(name="idealist_id_seq", sequenceName="idealist_id_seq", allocationSize=1)
    @Column(name = "id")
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

    public IdeaList(String name, boolean isPrivate,
                    Set<Idea> setOfIdeas, ShortUser author) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.setOfIdeas = setOfIdeas;
        this.author = author;
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
