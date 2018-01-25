package com.ideafix.dao;

import com.ideafix.model.pojo.IdeaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IdeaListDAO extends JpaRepository<IdeaList, Long> {

    List<IdeaList> findAllByAuthor_Id(long authorId);

    @Query("update ideaList set is_private = :condition where id = :listId")
    @Transactional
    @Modifying
    void setListPrivate(@Param("listId") long listId, @Param("condition") boolean isPrivate);
}
