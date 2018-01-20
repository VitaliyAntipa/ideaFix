package com.ideafix.dao;

import com.ideafix.model.pojo.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaDAO extends JpaRepository<Idea, Long>{
}
