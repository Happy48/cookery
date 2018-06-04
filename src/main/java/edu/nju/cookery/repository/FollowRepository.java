package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
