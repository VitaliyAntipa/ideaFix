package com.ideafix.dao;

import com.ideafix.model.pojo.Idea;
import com.ideafix.model.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface IdeaDAO extends JpaRepository<Idea, Long> {

    public List<Idea> findAllByAuthor_Id(long id);

    @Query("update idea set is_banned = true where id = :id")
    @Transactional
    @Modifying
    public void setBanToIdea(long id);

    @Query("update idea set is_banned = false where id = :id")
    @Transactional
    @Modifying
    public void unbanIdea(long id);

    List<Idea> findAllBySetOfTags(Set<Tag> tags);
}
