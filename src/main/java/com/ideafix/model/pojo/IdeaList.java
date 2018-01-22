package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "idealist")
public class IdeaList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "idealist_id_seq")
    @SequenceGenerator(name = "idealist_id_seq",
            sequenceName = "idealist_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_private")
    private boolean isPrivate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "idealist_idea",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "idea_id")
    )
    private Set<Idea> setOfIdeas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public IdeaList(String name) {
        this.name = name;
        this.isPrivate = false;
        this.setOfIdeas = new HashSet<>();
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
        return new ShortUser(author);
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
