package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.entity.Subtag;
import edu.nju.cookery.service.FoodClassService;
import edu.nju.cookery.vo.SubTagVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class FoodClassServiceImplTest {

    @Autowired
    FoodClassService foodClassService;
    @Test
    public void getFoodClass() {
        assertEquals(24,foodClassService.getFoodClass().size());
    }

    @Test
    public void getFoodClass2() {
        List<SubTagVO> subTagVOS=foodClassService.getFoodClass(1);
        subTagVOS.forEach(subTagVO -> {
            System.out.println(subTagVO.getName());
        });
    }

    @Test
    public void getFoodClassByNoteId() {
        List<SubTagVO> subTagVOS=foodClassService.getFoodClassByNoteId(1);
        subTagVOS.forEach(subTagVO -> {
            System.out.println(subTagVO.getName());
        });
    }
}