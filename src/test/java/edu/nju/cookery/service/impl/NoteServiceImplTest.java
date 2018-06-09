package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class NoteServiceImplTest {

    @Autowired
    NoteService noteService;

    @Test
    public void getBlogListByUserID() {
        assertEquals(1, noteService.getBlogListByUserID(1).get(0).getNoteID());
        assertEquals(10, noteService.getBlogListByUserID(2).get(0).getNoteID());
    }

    @Test
    public void getCollectedBlog() {
        assertEquals(8, noteService.getCollectedBlog(1).size());
        assertEquals(4, noteService.getCollectedBlog(2).size());
    }

    @Test
    public void getTopPopularNote() {
        assertEquals(38, noteService.getTopPopularNote(4).get(0).getNoteID());
    }

    @Test
    public void getNoteListByUserIdAndPage() {
        assertEquals(11, noteService.getNoteListByUserIdAndPage(2,0).get(1).getNoteId());
        assertEquals(37, noteService.getNoteListByUserIdAndPage(5,1).get(3).getNoteId());
    }
}