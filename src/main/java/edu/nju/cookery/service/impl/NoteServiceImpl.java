package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Collect;
import edu.nju.cookery.entity.Note;
import edu.nju.cookery.repository.CollectRepository;
import edu.nju.cookery.repository.LikeRepository;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Component
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteVOHelper noteVOHelper;

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CollectRepository collectRepository;
    @Autowired
    private LikeRepository likeRepository;


    private final String[] mouths=new String[]{
            "一月","二月","三月","四月",
            "五月","六月","七月","八月",
            "九月","十月","十一月","十二月",
    };

    @Override
    public List<NoteVO> getBlogListByUserID(int userID) {

        List<Note> noteList = noteRepository.findByUserID(userID);
        List<NoteVO> noteVOList =new ArrayList<>(noteList.size());
        for (Note note:noteList){
            noteVOList.add(noteVOHelper.getNoteVO(note));
        }
        return noteVOList;
    }

    @Override
    public List<NoteVO> getCollectedBlog(int userID) {
        List<NoteVO> noteList = new ArrayList<>();
        List<Collect> collectList = collectRepository.findByUserID(userID);
        for(Collect collect: collectList){
            int noteId = collect.getNoteID();
            noteList.add(noteVOHelper.getNoteVO(noteRepository.findByNoteID(noteId)));
        }
        return noteList;
    }

    @Override
    public List<NoteVO> getTopPopularNote(int num) {
        List<Integer> likes = likeRepository.findPopularLike();
        List<NoteVO> recommend = new ArrayList<>();

        for(int i=0;i<num;i++){
            recommend.add(noteVOHelper.getNoteVO(noteRepository.findByNoteID(likes.get(i))));
        }
        return recommend;
    }

    private List<NoteVO> getTopCollectNote(int num) {
        Pageable pageable=new PageRequest(0,num);
        List<Integer> collects=collectRepository.findPopularLike(pageable);
        List<NoteVO> recommend = new ArrayList<>();

        for(int i=0;i<num;i++){
            recommend.add(noteVOHelper.getNoteVO(noteRepository.findByNoteID(collects.get(i))));
        }
        return recommend;
    }

    @Override
    public List<NoteVO> getNoteListByUserIdAndPage(int userID, int page) {
        Pageable pageable = new PageRequest(page, 5);

        Page<Note> notes = noteRepository.findByUserID( userID , pageable);
        List<NoteVO> noteVOList =new ArrayList<>(notes.getSize());
        for (Note note:notes.getContent()){
            noteVOList.add(noteVOHelper.getNoteVO(note));
        }
        return noteVOList;
    }

    @Override
    public HashMap<String, String> getIndexRecommend() {
        HashMap<String,String> result=new HashMap<>();
        result.put("month",getCurrentMouth());
        result.put("recommend",JsonUtil.toJson(getTopCollectNote(3)));
        result.put("hot",JsonUtil.toJson(getTopPopularNote(3)));
        return result;
    }

    /**
     * 获取当前的月份
     * @return
     */
    private String getCurrentMouth() {
        Calendar calendar=Calendar.getInstance();
        return mouths[calendar.get(Calendar.MONTH)];
    }
}
