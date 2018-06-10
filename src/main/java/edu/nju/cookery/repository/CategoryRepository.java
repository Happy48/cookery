package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
