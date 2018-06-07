package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserInfo() {
        assertEquals("食，乐也～", userService.getUserInfo(4).getIntroduction());
        assertEquals("下厨房等多家美食平台美食达人.如需合作，请至新浪微博发私信联系", userService.getUserInfo(11).getIntroduction());
    }
}