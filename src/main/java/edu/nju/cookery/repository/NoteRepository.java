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

}
