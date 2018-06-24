package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.nju.cookery.entity.Work;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkRepositoryTest {

    @Autowired
    private WorkRepository workRepository;

    @Test
    public void findByNoteID() {
        assertEquals(3, workRepository.findByNoteID(3).size());
    }

//    @Test
    public void createWork (){
        Work work=new Work();
        work.setUserID(1);
        work.setNoteID(1);
        work.setPicture("123123123");
        work.setDescription("hello");
        workRepository.saveAndFlush(work);
    }
}