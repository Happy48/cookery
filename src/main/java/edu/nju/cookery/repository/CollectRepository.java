package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Collect;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * 按照收藏人数降序排序笔记
     * @return
     */
    @Query("select c.noteID from Collect c group by c.noteID order by count(c.userID) desc")
    List<Integer> findPopularLike(Pageable pageable);

    /**
     * 获取用户收藏列表
     * @param username 用户name
     * @return
     */
    @Query("select c from Collect c, Login l where l.userID = c.userID and l.username = ?1")
    List<Collect> findByUseranme(String username);
}
