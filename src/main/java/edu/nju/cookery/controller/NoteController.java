package edu.nju.cookery.controller;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.service.CollectService;
import edu.nju.cookery.service.LikeService;
import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class NoteController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private LikeService likeService;

    /**
     * 获取某人的笔记列表
     * @param name
     * @param page
     * @return
     */
    @RequestMapping(value = "/api/blog",method = RequestMethod.GET)
    @CrossOrigin
    public String getNoteListByUserID(@RequestParam("name") String name,
                        @RequestParam("page") int page){
        List<NoteVO> noteVOList = new ArrayList<>();
        int userID = loginService.getUserIDByName(name);
        List<Note> noteList = noteService.getBlogListByUserID(userID);
        for(Note note: noteList){
            int noteID = note.getNoteID();
            int likeCnt = likeService.getLikeCount(noteID);
            int collectCnt = collectService.getCollectCount(noteID);
            NoteVO noteVO = new NoteVO(note.getNoteName(), note.getNoteCover(), note.getDescription(),
                    likeCnt, note.getCreatedTime(), collectCnt, noteID);
            noteVOList.add(noteVO);
        }
        return JsonUtil.toJson(noteVOList);
    }

    /**
     * 获取某人收藏的笔记列表
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/collection",method = RequestMethod.GET)
    @CrossOrigin
    public String getCollectNoteListByUserID(@RequestParam("token") String token){
        List<NoteVO> noteVOList = new ArrayList<>();
        int userID = 0;
        List<Note> noteList = noteService.getCollectedBlog(userID);
        for(Note note: noteList){
            int noteID = note.getNoteID();
            int likeCnt = likeService.getLikeCount(noteID);
            int collectCnt = collectService.getCollectCount(noteID);
            NoteVO noteVO = new NoteVO(note.getNoteName(), note.getNoteCover(), note.getDescription(),
                    likeCnt, note.getCreatedTime(), collectCnt, noteID);
            noteVOList.add(noteVO);
        }
        return JsonUtil.toJson(noteVOList);
    }

    /**
     * 获取推荐的笔记列表
     * @param number
     * @return
     */
    @RequestMapping(value = "/api/guessLike",method = RequestMethod.GET)
    @CrossOrigin
    public String getCollectNoteListByUserID(@RequestParam("number") int number){
        List<NoteVO> noteVOList = new ArrayList<>();
        List<Note> noteList = noteService.getTopPopularNote(number);
        for(Note note: noteList){
            int noteID = note.getNoteID();
            int likeCnt = likeService.getLikeCount(noteID);
            int collectCnt = collectService.getCollectCount(noteID);
            NoteVO noteVO = new NoteVO(note.getNoteName(), note.getNoteCover(), note.getDescription(),
                    likeCnt, note.getCreatedTime(), collectCnt, noteID);
            noteVOList.add(noteVO);
        }
        return JsonUtil.toJson(noteVOList);
    }
}
