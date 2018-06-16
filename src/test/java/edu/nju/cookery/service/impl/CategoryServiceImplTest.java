package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.vo.NoteVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getNoteByClazz() {
        assertEquals(7, categoryService.getNoteByClazz("汤羹",0).size());
    }


    @Test
    public void findBySubtagIDAndUserID(){
        List<NoteVO> noteVOS=categoryService.getNoteByClazz("家常菜",0,1);
        noteVOS.forEach(noteVO -> {
            System.out.println(noteVO.getFoodTitle());
        });
    }
    @Test
    public void findTotalBySubtagIDAndUserID(){
        System.out.println(categoryService.getNoteTotalByClazz("家常菜",1));
    }
}