package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.vo.NoteVO;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    /**
     * 根据用户查找笔记
     * @param userID 用户id
     * @return
     */
    List<Note> findByUserID(int userID);

    /**
     * 查看所有笔记
     * @param pageable
     * @return
     */
    Page<Note> findAll(Pageable pageable);


    /**
     * 查找笔记
     * @param noteID 笔记Id
     * @return
     */
    Note findByNoteID(int noteID);

    /**
     * 搜索笔记
     * @param key 匹配模式
     * @return
     */
    Page<Note> findByNoteNameLike(String key, Pageable pageable);

    /**
     * 搜索笔记的数量
     * @param key
     * @return
     */
    @Query(value = "select count(n) from Note n where n.noteName like %?1%")
    int searchTotal(String key);

    /**
     * 按照页数获取笔记
     * @param userID
     * @param pageable
     * @return
     */
    Page<Note> findByUserID(int userID, Pageable pageable);

    /**
     * 搜索笔记
     * @param userId
     * @param key
     * @param pageable
     * @return
     */
    @Query(value = "select n from Note n where n.userID = ?1 and n.noteName like %?2%")
    Page<Note> findByUserIDAndNoteNameLike(int userId, String key, Pageable pageable);
    /**
     * 搜索笔记的数量
     * @param userId
     * @param key
     * @return
     */
    @Query(value = "select count(n) from Note n where n.userID = ?1 and n.noteName like %?2%")
    int findByUserIDAndNoteNameLikeTotal(int userId, String key);

    /**
     * 笔记的数量
     * @param userID
     * @return
     */
    @Query(value = "select count(n) from Note n where n.userID = ?1")
    int findByUserIDTotal(int userID);

    /**
     * 获取总条数
     * @return
     */
    @Query(value = "select count(n) from Note n ")
    int findAllTotal();

    /**
     * 获取用户的笔记ID
     * @param userID
     * @return
     */
    @Query(value = "select n.noteID from Note n where n.userID=?1")
    List<Integer> findNoteIDByUserID(int userID);

}
