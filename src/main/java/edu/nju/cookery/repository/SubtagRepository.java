package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Subtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtagRepository  extends JpaRepository<Subtag,Integer> {
}
