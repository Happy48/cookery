package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NoteVO> getBlogListByUserID(int userID) {
        List<NoteVO> noteVOList = new ArrayList<>();

        List<Note> noteList = noteRepository.findByUserID(userID);

        return noteVOList;
    }
}
