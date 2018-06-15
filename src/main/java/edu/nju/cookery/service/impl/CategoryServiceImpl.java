package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Category;
import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.CategoryRepository;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.repository.SubtagRepository;
import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<NoteVO> getNoteByClazz(String clazz,int page) {
        List<NoteVO> result = new ArrayList<>();
        Pageable pageable = new PageRequest(page, 9);
        if(subtagRepository.findByName(clazz) ==null){
            List<Note>noteList=noteRepository.findAll(pageable).getContent();
            noteList.forEach(note -> {
                result.add(noteVOHelper.getNoteVO(note));
            });
        }else{
            int subtag_id = subtagRepository.findByName(clazz).getId();
            List<Category> list = categoryRepository.findBySubtagID(subtag_id,pageable).getContent();

            for(Category category: list){
                int note_id  =category.getNoteID();
                Note note = noteRepository.findByNoteID(note_id);
                result.add(noteVOHelper.getNoteVO(note));
            }

        }
        return result;
    }

    /**
     * 获取总条数
     * @param clazz
     * @return
     */
    @Override
    public int getNoteTotalByClazz(String clazz) {
        int result=0;
        if(subtagRepository.findByName(clazz) ==null){
            result=noteRepository.findAllTotal();
        }else{
            int subtag_id = subtagRepository.findByName(clazz).getId();
            result=categoryRepository.findTotalBySubtagID(subtag_id);
        }
        return result;
    }
}
