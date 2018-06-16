package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Category;
import edu.nju.cookery.vo.NoteVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testAddCategory() {
        Category category=new Category();
        category.setNoteID(3);
        category.setSubtagID(8);
        categoryRepository.saveAndFlush(category);
        categoryRepository.delete(category);
    }

    @Test
    public void findBySubtagID(){
        assertEquals(7, categoryRepository.findBySubtagID(5).size());
    }

    @Test
    public void findBySubtagIDAndUserID(){
        List<Category> categories=categoryRepository.findBySubtagIDAndUserID(1,1,0,9);
        categories.forEach(category -> {
            System.out.println(category.getNoteID());
        });
    }
}