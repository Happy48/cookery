package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer> {

    /**
     * 查找本人关注列表
     * @param userID 本人id
     * @return
     */
    List<Follow> findByUserID(int userID);

    /**
     * 关注的数量
     * @param userID
     * @return
     */
    @Query(value = "select count(f) from Follow f where f.userID = ?1")
    int findByUserIDTotal(int userID);

    /**
     * 按照页数获取关注
     * @param userID
     * @param pageable
     * @return
     */
    Page<Follow> findByUserID(int userID, Pageable pageable);
}
