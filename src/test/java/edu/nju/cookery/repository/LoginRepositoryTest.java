package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Login;
import edu.nju.cookery.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRepositoryTest {
    @Autowired
    LoginRepository loginRepository;

    @Test
    public void testLogin(){
        Login login=new Login();
        login.setUsername("民神大厨");
        login.setPassword("123456");
        login.setEmail("123456@qq.com");
        login.setToken("123456");
        login.setTokenExptime(1);
        login.setActivated(true);
        login.setRegTime(1);
        loginRepository.saveAndFlush(login);

    }

    @Test
    public void changeInfo(){
        Login login=new Login();
        login.setEmail("member13@163.com");
        login.setPassword(MD5Util.encode("123456"));
        login.setUsername("唯幂nomie的厨房");
        login.setActivated(true);
        login.setRegTime(1527596152);
        login.setToken("asdhaisudqweq.123askjfgasd");
        login.setTokenExptime(1527596452);
        login.setUserID(13);
        loginRepository.saveAndFlush(login);
    }

}
