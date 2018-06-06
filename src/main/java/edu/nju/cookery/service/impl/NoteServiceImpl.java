package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Collect;
import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.CollectRepository;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CollectRepository collectRepository;

    @Override
    public List<Note> getBlogListByUserID(int userID) {

        List<Note> noteList = noteRepository.findByUserID(userID);

        return noteList;
    }

    @Override
    public List<Note> getCollectedBlog(int userID) {
        List<Note> noteList = new ArrayList<>();
        List<Collect> collectList = collectRepository.findByUserID(userID);
        for(Collect collect: collectList){
            int noteId = collect.getNoteID();
            noteList.add(noteRepository.findByNoteID(noteId));
        }
        return noteList;
    }
}
