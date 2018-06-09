package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void findByUserID() {
        assertEquals(2, noteRepository.findByUserID(2).size());
        assertEquals(6, noteRepository.findByUserID(7).size());
    }

    @Test
    public void findByNoteID() {
        assertEquals("香芋红烧肉", noteRepository.findByNoteID(1).getNoteName());
        assertEquals("粢饭团", noteRepository.findByNoteID(12).getNoteName());
    }

    @Test
    public void findByUserID2() {
        Pageable pageable = new PageRequest(0, 5);
        assertEquals(2, noteRepository.findByUserID(1,pageable).getContent().get(1).getNoteID());
        pageable = new PageRequest(1, 5);
        assertEquals(7, noteRepository.findByUserID(1,pageable).getContent().get(1).getNoteID());
    }
}