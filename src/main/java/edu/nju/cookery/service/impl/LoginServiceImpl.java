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
            return 1;
        }else if (user.getPassword().equals(MD5Util.encode(pass))){
            return 0;
        }else{
            return 2;
        }
    }
}
