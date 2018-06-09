package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Login;
import edu.nju.cookery.entity.UserInfo;
import edu.nju.cookery.repository.LoginRepository;
import edu.nju.cookery.repository.UserInfoRepository;
import edu.nju.cookery.service.UserService;
import edu.nju.cookery.util.MD5Util;
import edu.nju.cookery.vo.UserExceptIconVO;
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

    /**
     * 修改个人信息
     * @param userExceptIconVO
     * @return
     */
    public int changeInfo(UserExceptIconVO userExceptIconVO){
        int userid=userExceptIconVO.getUserID();
        String icon=userInfoRepository.findByUserID(userid).getIcon();
        UserInfo userInfo=new UserInfo();

        userInfo.setAddress(userExceptIconVO.getAddress());
        userInfo.setBirthday(userExceptIconVO.getBirthday());
        userInfo.setIntroduction(userExceptIconVO.getIntroduction());
        userInfo.setPhoneNumber(userExceptIconVO.getPhoneNumber());
        userInfo.setSex(userExceptIconVO.isSex());
        userInfo.setIcon(icon);
        userInfo.setUserID(userid);
        userInfoRepository.saveAndFlush(userInfo);

        Login login=new Login();
        Login oldLogin=loginRepository.findByUserID(userid);
        login.setEmail(userExceptIconVO.getEmail());
        login.setPassword(MD5Util.encode(userExceptIconVO.getUserPwd()));
        login.setUsername(userExceptIconVO.getUserName());
        login.setActivated(oldLogin.isActivated());
        login.setRegTime(oldLogin.getRegTime());
        login.setToken(oldLogin.getToken());
        login.setTokenExptime(oldLogin.getTokenExptime());
        login.setUserID(userid);
        loginRepository.saveAndFlush(login);

        return 0;
    }

}
