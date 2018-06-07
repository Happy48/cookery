package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Login;
import edu.nju.cookery.entity.UserInfo;
import edu.nju.cookery.repository.LoginRepository;
import edu.nju.cookery.repository.UserInfoRepository;
import edu.nju.cookery.service.UserService;
import edu.nju.cookery.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserVO getUserInfo(int userID) {
        UserVO userVO = null;
        UserInfo userInfo = userInfoRepository.findByUserID(userID);
        Login login = loginRepository.findByUserID(userID);
        if(userInfo != null && login != null){
            userVO = new UserVO(userID, login.getUsername(), userInfo.isSex(), userInfo.getIntroduction(), userInfo.getIcon());
        }
        return userVO;
    }

}
