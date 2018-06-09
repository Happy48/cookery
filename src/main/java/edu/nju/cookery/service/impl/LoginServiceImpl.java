package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Login;
import edu.nju.cookery.repository.LoginRepository;
import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginRepository loginRepository;

    @Override
    public int login(String email, String pass) {

        Login user = loginRepository.findByEmail(email);
        if (user==null){
            return -1;
        }else if (user.getPassword().equals(MD5Util.encode(pass))){
            return user.getUserID();
        }else{
            return -2;
        }
    }

    @Override
    public int getUserIDByName(String userName) {
        Login user = loginRepository.findByUsername(userName);
        return user.getUserID();
    }

    @Override
    public int register(String name, String pass, String email) {
        Login nameUser=loginRepository.findByUsername(name);
        if (nameUser!=null){
            return 1;
        }
        Login emailUser=loginRepository.findByEmail(email);
        if (emailUser!=null){
            return 2;
        }
        Login login=new Login();
        login.setEmail(email);
        login.setPassword(MD5Util.encode(pass));
        login.setUsername(name);
        loginRepository.save(login);
        return 0;
    }

}
