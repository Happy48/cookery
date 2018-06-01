package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Login;
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

}
