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
public class FollowRepositoryTest {

    @Autowired
    FollowRepository followRepository;

    @Test
    public void findByUserID() {
        assertEquals(4, followRepository.findByUserID(1).size());
        assertEquals(4, followRepository.findByUserID(2).size());
    }


    @Test
    public void findByUserIDTotal(){
        assertEquals(5, followRepository.findByUserIDTotal(1));
    }

    @Test
    public void findByUserID2(){
        Pageable pageable = new PageRequest(0, 5);
        assertEquals(3, followRepository.findByUserID(1,pageable).getContent().get(1).getFollowedID());
    }

    @Test
    public void findByUserName() {
        assertEquals(4, followRepository.findByUsername("月亮晶晶").size());
        assertEquals(2, followRepository.findByUsername("木可厨房").size());
    }
}

