package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Collect;
import edu.nju.cookery.entity.Like;
import edu.nju.cookery.entity.Note;
import edu.nju.cookery.entity.Category;
import edu.nju.cookery.repository.*;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.NewNoteVO;
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
    @Autowired
    private SubtagRepository subtagRepository;
    @Autowired
    private CategoryRepository categoryRepository;


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
     * 某人收藏笔记/取消收藏笔记
     * @param userid
     * @param noteid
     * @return
     */
    @Override
    public int addCollect(int userid, int noteid) {
        List<Collect>collectList=collectRepository.findByUserID(userid);
        for (Collect collect:collectList) {
            if (collect.getNoteID() == noteid) {
                collectRepository.delete(collect);
                return 1;  // 已经收藏过
            }
        }
        Collect collect=new Collect();
        collect.setNoteID(noteid);
        collect.setUserID(userid);
        collectRepository.save(collect);
        return 0;
    }

    /**
     * 某人喜欢笔记/取消喜欢笔记
     * @param userid
     * @param noteid
     * @return
     */
    @Override
    public int addLike(int userid, int noteid) {
        List<Like>likeList=likeRepository.findByUserID(userid);
        for (Like like:likeList) {
            if (like.getNoteID() == noteid) {
                likeRepository.delete(like);
                return 1;  // 已经喜欢过
            }
        }
        Like like=new Like();
        like.setNoteID(noteid);
        like.setUserID(userid);
        likeRepository.save(like);
        return 0;
    }


    /**
     * 新增笔记
     * @param newNoteVO
     * @return
     */
    public int createNote(NewNoteVO newNoteVO){
        // 添加笔记
        Note note=new Note();
        note.setCreatedTime(newNoteVO.getCreatedTime());
        note.setDescription(newNoteVO.getDescription());
        note.setMaterial(newNoteVO.getMaterial());
        note.setNoteCover(newNoteVO.getNoteCover());
        note.setNoteName(newNoteVO.getNoteName());
        note.setPractice(newNoteVO.getPractice());
        note.setTip(newNoteVO.getTip());
        note.setUserID(newNoteVO.getUserID());
        Note savedObject=noteRepository.saveAndFlush(note);
        int newNoteId=savedObject.getNoteID();
        System.out.println(newNoteId);
        // 添加标签
        ArrayList<String> subTagList=newNoteVO.getSubTagList();
        for(String tagStr:subTagList){
            if(subtagRepository.findByName(tagStr)==null){
                return 1;
            }
            int tagId=subtagRepository.findByName(tagStr).getId();
            Category category=new Category();
            category.setNoteID(newNoteId);
            category.setSubtagID(tagId);
            categoryRepository.saveAndFlush(category);
        }
        return 0;
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
