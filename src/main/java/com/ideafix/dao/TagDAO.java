package com.ideafix.dao;

import com.ideafix.model.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface TagDAO extends JpaRepository<Tag, Long> {

    public boolean existsByName(String name);

    public Tag findByName(String name);

    public Tag deleteByName(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE  FROM tag WHERE id NOT IN (SELECT tag_id from idea_tag)")
    public void clearFreeTags();
}
