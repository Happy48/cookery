package edu.nju.cookery.repository;

import edu.nju.cookery.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository   extends JpaRepository<UserInfo,Integer> {

    /**
     * 查找个人信息
     * @param userID 用户id
     * @return
     */
    UserInfo findByUserID(int userID);
}
