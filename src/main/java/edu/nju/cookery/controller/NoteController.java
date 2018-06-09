package edu.nju.cookery.controller;

import edu.nju.cookery.entity.Note;
import edu.nju.cookery.service.CollectService;
import edu.nju.cookery.service.LikeService;
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
    private NoteService noteService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private LikeService likeService;

    /**
     * 按照页数获取某人的笔记列表
     * @param userid
     * @param page
     * @return
     */
    @RequestMapping(value = "/api/userNoteList",method = RequestMethod.GET)
    @CrossOrigin
    public String getNoteListByUserID(@RequestParam("userid") int userid,
                        @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        List<NoteVO> noteVOList = noteService.getNoteListByUserIdAndPage(userid, pageIndex);
        return JsonUtil.toJson(noteVOList);
    }

    /**
     * 获取某人收藏的笔记列表
     * @param userid
     * @return
     */
    @RequestMapping(value = "/api/userCollection",method = RequestMethod.GET)
    @CrossOrigin
    public String getCollectNoteListByUserID(@RequestParam("userid") int userid){
        List<NoteVO> noteVOList = new ArrayList<>();
        List<Note> noteList = noteService.getCollectedBlog(userid);
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
    public String getRecommendNote(@RequestParam("number") int number){
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
