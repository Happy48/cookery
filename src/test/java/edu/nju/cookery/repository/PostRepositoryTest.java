package edu.nju.cookery.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void findByNoteID() {
        assertEquals(7, postRepository.findByNoteID(1).size());
    }

    @Test
    public void findByPostID() {
        assertEquals(4, postRepository.findByPostID(5).getMainPostID());
    }
}