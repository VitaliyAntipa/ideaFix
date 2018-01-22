package com.ideafix.dao;

import com.ideafix.model.pojo.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MediaDAO extends JpaRepository<Media, Long> {

    @Transactional
    @Modifying
    @Query("delete from idea_media where idea_id =:id")
    public void deleteAllByIdeaId(@Param("id") long id);
}
