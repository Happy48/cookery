package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    public void leaveNote() {
        assertEquals(0, postService.leaveNote(5, 5, 0, "这是测试评论"));
    }

    @Test
    public void testGetOriginalPostId(){
        assertEquals(3, postService.getOriginalPostid(15));
    }

}