package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Collect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubtagRepositoryTest {

    @Autowired
    SubtagRepository subtagRepository;

    @Test
    public void findByName(){
        assertEquals(1,subtagRepository.findByName("家常菜").getId());
        assertEquals(16,subtagRepository.findByName("腌咸制品").getId());
        assertEquals(24,subtagRepository.findByName("特殊场合").getId());
    }

}