package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LoginServiceImplTest {

    @Autowired
    LoginService loginService;

    @Test
    public void login() {
        assertEquals(1,loginService.login("member1@163.com","123456"));
        assertEquals(-1,loginService.login("mem@163.com","123456"));
        assertEquals(-2,loginService.login("member1@163.com","123dsds456"));
    }

    @Test
    public void register(){
        assertEquals(1,loginService.register("民神大厨", "123", "123456@qq.com"));
        assertEquals(2,loginService.register("member9@163.com","123","member9@163.com"));
        //assertEquals(0,loginService.register("member9@163.com","123","member99@163.com"));

    }
}