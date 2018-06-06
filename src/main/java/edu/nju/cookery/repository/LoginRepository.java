package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository  extends JpaRepository<Login,Integer> {

    /**
     * 根据邮箱查找
     * @param email 邮箱
     * @return
     */
    Login findByEmail(String email);

    /**
     * 根据id查找
     * @param userID 用户id
     * @return
     */
    Login findByUserID(int userID);

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return
     */
    Login findByUsername(String userName);

}
