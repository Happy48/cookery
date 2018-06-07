package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}