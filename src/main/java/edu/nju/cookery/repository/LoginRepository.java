package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository  extends JpaRepository<Login,Integer> {

}
