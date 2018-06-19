package edu.nju.cookery.service;

import edu.nju.cookery.vo.UserExceptIconVO;
import edu.nju.cookery.vo.UserVO;

public interface UserService {

    UserVO getUserInfo(int userID);

    /**
     * 修改个人信息
     * @param userExceptIconVO
     * @return 修改成功，返回0；修改失败，返回1
     */
    int changeInfo(UserExceptIconVO userExceptIconVO);

    /**
     * 修改用户个人头像
     * @param uid
     * @param imgSrc
     * @return 修改成功，返回0；修改失败，返回1
     */
    int changeHeadIcon(int uid,String imgSrc);

}
