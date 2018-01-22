package com.ideafix.dao;

import com.ideafix.model.pojo.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaDAO extends JpaRepository<Idea, Long> {

    public List<Idea> findAllByAuthor_Id(long id);
}
