package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectRepositoryTest {

    @Autowired
    CollectRepository collectRepository;

    @Test
    public void findByNoteID() {
        assertEquals(3,collectRepository.findByNoteID(20).size());
        assertEquals(2,collectRepository.findByNoteID(28).size());
    }

    @Test
    public void findByUserID() {
        assertEquals(8,collectRepository.findByUserID(1).size());
        assertEquals(4,collectRepository.findByUserID(2).size());
    }
}