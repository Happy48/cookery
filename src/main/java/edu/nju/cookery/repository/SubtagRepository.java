package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Subtag;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
