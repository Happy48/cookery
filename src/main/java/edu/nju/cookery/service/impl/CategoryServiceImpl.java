package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Category;
import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.CategoryRepository;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.repository.SubtagRepository;
import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubtagRepository subtagRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteVOHelper noteVOHelper;

    /**
     * 根据标签名找笔记
     * @param clazz
     * @return
     */
    @Override
    public List<NoteVO> getNoteByClazz(String clazz) {
        int subtag_id = subtagRepository.findByName(clazz).getId();
        List<Category> list = categoryRepository.findBySubtagID(subtag_id);

        List<NoteVO> result = new ArrayList<>();
        for(Category category: list){
            int note_id  =category.getNoteID();
            Note note = noteRepository.findByNoteID(note_id);
            result.add(noteVOHelper.getNoteVO(note));
        }
        return result;
    }
}
