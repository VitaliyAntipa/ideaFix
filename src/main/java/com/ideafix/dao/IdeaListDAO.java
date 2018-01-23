package com.ideafix.dao;

import com.ideafix.model.pojo.IdeaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaListDAO extends JpaRepository<IdeaList, Long> {

    List<IdeaList> findAllByAuthor_Id(long authorId);
}
