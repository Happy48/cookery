package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.service.SearchService;
import edu.nju.cookery.vo.NoteVO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {
    @Autowired
    NoteVOHelper noteVOHelper;
    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<NoteVO> search(String key, int pageIndex) {
        Pageable pageable = new PageRequest(pageIndex, 5);

        Page<Note> notes = noteRepository.findByNoteNameLike( "%"+key+"%" , pageable);
        List<NoteVO> searchResult=new ArrayList<>(notes.getSize());
        for (Note note:notes.getContent()){
            searchResult.add(noteVOHelper.getNoteVO(note));
        }
        return searchResult;
    }

    @Override
    public List<NoteVO> searchFromPeople(int userId, String key, int pageIndex) {
        Pageable pageable = new PageRequest(pageIndex, 5);

        Page<Note> notes = noteRepository.findByUserIDAndNoteNameLike( userId, "%"+key+"%" , pageable);
        List<NoteVO> searchResult=new ArrayList<>(notes.getSize());
        for (Note note:notes.getContent()){
            searchResult.add(noteVOHelper.getNoteVO(note));
        }
        return searchResult;
    }
}
