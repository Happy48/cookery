package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}