package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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



}