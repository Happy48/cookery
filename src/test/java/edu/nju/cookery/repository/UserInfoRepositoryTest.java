package edu.nju.cookery.repository;

import edu.nju.cookery.entity.UserInfo;
import edu.nju.cookery.util.DateHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Test
    public void findByUserID() {
        assertEquals("每一天，都有一些事情将会发生，每段路，都有即将到来的旅程，每颗心，都有值得期待的成份，每个人，都有爱", userInfoRepository.findByUserID(1).getIntroduction());
        assertEquals("著有美食书《简单。菜》《爱上简单菜》《烹享慢生活：我的珐琅锅菜谱》 ", userInfoRepository.findByUserID(3).getIntroduction());
    }

    @Test
    public void changeInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setAddress("内蒙古");

        String strDate="1987-05-30";
        Date strtodate = DateHelper.strToSQLDate(strDate);
        userInfo.setBirthday(strtodate);
        userInfo.setIntroduction("你若安好便是晴天!");
        userInfo.setPhoneNumber("13819231229");
        userInfo.setSex(false);
        userInfo.setIcon("http://s1.cdn.xiachufang.com/7a2c01e68db111e5b5fee0db5512b208.jpg@2o_50sh_1pr_1l_160w_160h_1c_1e_90q_1wh");
        userInfo.setUserID(13);
        userInfoRepository.saveAndFlush(userInfo);
    }
}