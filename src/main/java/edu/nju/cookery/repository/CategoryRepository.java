package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer> {

    /**
     * 根据标签id查找笔记
     * @param subtag_id
     * @return
     */
    List<Category> findBySubtagID(int subtag_id);
    Page<Category> findBySubtagID(int subtag_id, Pageable pageable);
    Page<Category> findAll(Pageable pageable);

    /**
     * 根据标签获取总条数
     * @param subtag_id
     * @return
     */
    @Query(value = "select count(c) from Category c where c.subtagID = ?1")
    int findTotalBySubtagID(int subtag_id);

    @Query(value="SELECT c.category_id,c.note_id,c.subtag_id FROM  category c, note n WHERE n.user_id=?2 and c.subtag_id=?1 and n.note_id=c.note_id limit ?3,?4 ;",nativeQuery=true)
    List<Category> findBySubtagIDAndUserID(int subtag_id,int useriD,int offset,int limit);

    @Query(value="SELECT count(*) FROM  category c, note n WHERE n.user_id=?2 and c.subtag_id=?1 and n.note_id=c.note_id ",nativeQuery=true)
    int findTotalBySubtagIDAndUserID(int subtag_id,int useriD);

    Category findBySubtagIDAndNoteID(int subtagID,int noteID);

    List<Category> findByNoteID(int noteID);
}
