package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository  extends JpaRepository<Work,Integer> {
}
