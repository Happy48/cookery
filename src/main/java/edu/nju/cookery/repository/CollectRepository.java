package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectRepository  extends JpaRepository<Collect,Integer> {
}
