package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.CollectRepository;
import edu.nju.cookery.repository.LikeRepository;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.service.CollectService;
import edu.nju.cookery.service.LikeService;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteVOHelper {
    @Autowired
    private CollectService collectService;
    @Autowired
    private LikeService likeService;

    public NoteVO getNoteVO(Note note){
        int noteID = note.getNoteID();
        int likeCnt = likeService.getLikeCount(noteID);
        int collectCnt = collectService.getCollectCount(noteID);
        return new NoteVO(note.getNoteName(), note.getNoteCover(), note.getDescription(),
                likeCnt, note.getCreatedTime(), collectCnt, noteID);
    }
}
