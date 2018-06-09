package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Like;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LikeRepositoryTest {

    @Autowired
    LikeRepository likeRepository;

    @Test
    public void findThroughNoteID() {
        assertEquals(1, likeRepository.findThroughNoteID(3).size());
        assertEquals(4, likeRepository.findThroughNoteID(38).size());
    }

    @Test
    public void findByUserID() {
        assertEquals(8, likeRepository.findByUserID(1).size());
        assertEquals(8, likeRepository.findByUserID(2).size());
    }

    @Test
    public void addLike(){
        Like like=new Like();
        like.setNoteID(1);
        like.setUserID(5);
        likeRepository.saveAndFlush(like);
        likeRepository.delete(like);
    }

    @Test
    public void findPopularLike() {
        assertEquals("38", likeRepository.findPopularLike().get(0).toString());
    }
}