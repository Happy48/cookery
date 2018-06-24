package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.service.WorkService;
import edu.nju.cookery.vo.NoteVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class WorkServiceImplTest {

    @Autowired
    private WorkService workService;

//    @Test
    public void createNote(){
        assertEquals(0,workService.createWork(1,1,"pic","hello"));
    }
}