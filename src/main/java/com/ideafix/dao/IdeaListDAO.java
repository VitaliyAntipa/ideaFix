package com.ideafix.dao;

import com.ideafix.model.pojo.IdeaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaListDAO extends JpaRepository<IdeaList, Long> {
}
