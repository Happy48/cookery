package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Subtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtagRepository  extends JpaRepository<Subtag,Integer> {
    @Override
    List<Subtag> findAll();

    /**
     * 根据标签名查找
     * @param name 标签名
     * @return
     */
    Subtag findByName(String name);

    @Query(value="SELECT s.subtag_id,s.subtag_name FROM subtag s, category c, note n WHERE n.user_id=?1 and n.note_id=c.note_id and s.subtag_id=c.subtag_id",nativeQuery=true)
    List<Subtag> findByUserID(int userID);
}
