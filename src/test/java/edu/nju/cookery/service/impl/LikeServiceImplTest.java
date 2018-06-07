package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.LikeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LikeServiceImplTest {

    @Autowired
    LikeService likeService;

    @Test
    public void getLikeCount() {
        assertEquals(1, likeService.getLikeCount(10));
        assertEquals(2, likeService.getLikeCount(26));

    }
}