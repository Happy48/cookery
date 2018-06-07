package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.CollectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CollectServiceImplTest {

    @Autowired
    CollectService  collectService;

    @Test
    public void getCollectCount() {
        assertEquals(4,collectService.getCollectCount(45));
        assertEquals(3,collectService.getCollectCount(69));
    }
}