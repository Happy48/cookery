package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.UserService;
import edu.nju.cookery.util.DateHelper;
import edu.nju.cookery.vo.UserExceptIconVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.sql.Date;

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

    @Test
    public void changeUserInfo(){
        String strDate="1987-05-30";
        Date strtodate = DateHelper.strToSQLDate(strDate);
        UserExceptIconVO vo=new UserExceptIconVO(13,"唯幂nomie的厨房","内蒙古",false,
                strtodate,"你若安好便是晴天","13819231229","123456","member13@163.com");
        assertEquals(0, userService.changeInfo(vo));

        String strDate1="1987-05-30";
        Date strtodate1 = DateHelper.strToSQLDate(strDate1);
        UserExceptIconVO vo1=new UserExceptIconVO(13,"梅子厨艺","内蒙古",false,
                strtodate1,"你若安好便是晴天","13819231229","123456","member13@163.com");
        assertEquals(1, userService.changeInfo(vo1));

        String strDate2="1987-05-30";
        Date strtodate2 = DateHelper.strToSQLDate(strDate2);
        UserExceptIconVO vo2=new UserExceptIconVO(13,"唯幂nomie的厨房","内蒙古",false,
                strtodate2,"你若安好便是晴天","13819231229","123456","member7@163.com");
        assertEquals(2, userService.changeInfo(vo2));

    }

    @Test
    public void changeHeadIcon(){
        assertEquals(0,userService.changeHeadIcon(1,"https://cookery.oss-cn-beijing.aliyuncs.com/BF3FA20712B4ABB181B75F1FF669BE3F.jpg"));
    }
}