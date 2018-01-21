package com.ideafix.dao;

import com.ideafix.model.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagDAO extends JpaRepository<Tag, Long> {

    public boolean existsByName(String name);

    public Tag findByName(String name);
}
