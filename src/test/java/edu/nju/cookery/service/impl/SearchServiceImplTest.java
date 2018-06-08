package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
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
public class SearchServiceImplTest {

    @Autowired
    SearchServiceImpl searchService;

    @Test
    public void searchTest(){
        List<NoteVO> search = searchService.search("奶", 0);
        assertTrue(search.size()!=0);
    }
}