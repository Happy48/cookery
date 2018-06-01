package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends JpaRepository<Like,Integer> {
}
