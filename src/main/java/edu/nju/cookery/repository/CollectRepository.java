package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectRepository  extends JpaRepository<Collect,Integer> {

    /**
     * 查找笔记的收藏用户
     * @param noteID 笔记id
     * @return
     */
    List<Collect> findByNoteID(int noteID);

    /**
     * 获取用户收藏列表
     * @param userID 用户id
     * @return
     */
    List<Collect> findByUserID(int userID);

}
