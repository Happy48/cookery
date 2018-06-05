package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository  extends JpaRepository<Like,Integer> {

    /**
     * 找到笔记的所有喜欢
     * @param noteID 笔记id
     * @return
     */
    List<Like> findByNoteID(int noteID);

    /**
     * 找到用户的所有喜欢
     * @param userID 用户id
     * @return
     */
    List<Like> findByUserID(int userID);

}
