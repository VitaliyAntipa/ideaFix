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

    List<Idea> findAllByAuthorId(long id);

    @Query("update idea set is_banned = true where id = :id")
    @Transactional
    @Modifying
    void setBanToIdea(long id);

    @Query("update idea set is_banned = false where id = :id")
    @Transactional
    @Modifying
    void unbanIdea(long id);

    @Query(nativeQuery = true, value = "INSERT INTO user_idea (user_id, idea_id) VALUES (:userId,:ideaId)")
    @Transactional
    @Modifying
    void addIdeaToFavorite(@Param("ideaId") long ideaId, @Param("userId") long userId);

    @Query(nativeQuery = true, value = "SELECT EXISTS(SELECT * FROM user_idea WHERE  user_id = :userId AND idea_id = :ideaId)")
    @Transactional
    Boolean existsIdeaInUsersFavorite(@Param("ideaId") long ideaId, @Param("userId") long userId);

    @Query(nativeQuery = true, value = "DELETE FROM user_idea WHERE  user_id = :userId AND idea_id = :ideaId")
    @Transactional
    @Modifying
    void deleteIdeaFromFavorite(@Param("ideaId") long ideaId, @Param("userId") long userId);

    @Query(nativeQuery = true, value = "SELECT id FROM idea WHERE id IN (SELECT idea_id from user_idea WHERE user_id = :id)")
    @Transactional
    List<Integer> getAllFavoriteIdeasByUserId(@Param("id")long userId);

    @Query("update idea set views = views + 1 where id = :id")
    @Transactional
    @Modifying
    void incrementViews(@Param("id") long ideaId);
}
