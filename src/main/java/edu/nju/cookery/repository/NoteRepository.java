package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Note;
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

}
