package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.*;
import edu.nju.cookery.repository.*;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.vo.NewNoteVO;
import edu.nju.cookery.vo.NoteVO;
import edu.nju.cookery.vo.UpdateNoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;

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
    public int getBlogsTotal(int userID) {
        return noteRepository.findByUserIDTotal(userID);
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

    @Override
    public Set<NoteVO> getRecommendNote(int num) {
        List<Note> notes = noteRepository.findAll();
        Set<NoteVO> recommend = new HashSet<>();

        // 初始化随机数
        Random rand = new Random();
        while (recommend.size()<num){
            int index = rand.nextInt(notes.size());
            recommend.add(noteVOHelper.getNoteVO(notes.get(index)));
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
        Pageable pageable = new PageRequest(page, 5, Sort.Direction.DESC,"createdTime");

        Page<Note> notes = noteRepository.findByUserID( userID , pageable);
        List<NoteVO> noteVOList =new ArrayList<>(notes.getSize());
        for (Note note:notes.getContent()){
            noteVOList.add(noteVOHelper.getNoteVO(note));
        }
        return noteVOList;
    }

    @Override
    public HashMap<String, Object> getIndexRecommend() {
        HashMap<String,Object> result=new HashMap<>();
        result.put("month",getCurrentMouth());
        result.put("recommend",getTopCollectNote(12));
        result.put("hot",getTopPopularNote(12));
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
     * 得到某人是否喜欢某笔记
     * @param userid
     * @param noteid
     * @return 喜欢，返回0；还未喜欢，返回1
     */
    public int isLike(int userid,int noteid){
        List<Like>likeList=likeRepository.findByUserID(userid);
        for (Like like:likeList) {
            if (like.getNoteID() == noteid) {
                return 0;
            }
        }
        return 1;
    }

    /**
     * 得到某人是否收藏了某笔记
     * @param userid
     * @param noteid
     * @return 收藏了，返回0；还未收藏，返回1
     */
    public int isCollect(int userid,int noteid){
        List<Collect>collectList=collectRepository.findByUserID(userid);
        for (Collect collect:collectList) {
            if (collect.getNoteID() == noteid) {
                return 0;
            }
        }
        return 1;
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
        note.setMaterial(newNoteVO.getMaterial().replaceAll("\"","\'"));
        note.setNoteCover(newNoteVO.getNoteCover());
        note.setNoteName(newNoteVO.getNoteName());
        note.setPractice(newNoteVO.getPractice());
        note.setTip(newNoteVO.getTip());
        note.setUserID(newNoteVO.getUserID());
        Note savedObject=noteRepository.saveAndFlush(note);
        int newNoteId=savedObject.getNoteID();
        System.out.println(newNoteId);
        // 添加标签
        List<String> subTagList=newNoteVO.getSubTagList();
        for(String tagStr:subTagList){
            if(subtagRepository.findByName(tagStr)==null){
                return -1;
            }
            int tagId=subtagRepository.findByName(tagStr).getId();
            Category category=new Category();
            category.setNoteID(newNoteId);
            category.setSubtagID(tagId);
            categoryRepository.saveAndFlush(category);
        }
        return newNoteId;
    }

    @Override
    public NoteVO getNoteInfo(int noteID) {
        return noteVOHelper.getNoteVO(noteRepository.findByNoteID(noteID));
    }

    /**
     * 获取更新笔记的信息
     * @param noteID
     * @return
     */
    @Override
    public UpdateNoteVO getNoteUpdateInfo(int noteID) {
        Note note=noteRepository.findByNoteID(noteID);
        List<Category> categories=categoryRepository.findByNoteID(noteID);
        List<String> tags=new ArrayList<>();
        categories.forEach(category -> {
            Subtag subtag=subtagRepository.findOne(category.getSubtagID());
            tags.add(subtag.getName());
        });
        UpdateNoteVO updateNoteVO=new UpdateNoteVO(note.getNoteID(),note.getNoteName(),note.getNoteCover(),note.getDescription(),note.getMaterial(),note.getPractice(),note.getCreatedTime(),note.getTip(),tags);
        return updateNoteVO;
    }

    /**
     * 更新笔记
     * @param updateNoteVO
     * @return
     */
    @Override
    public int updateNote(UpdateNoteVO updateNoteVO) {
        // 添加笔记
        Note note=noteRepository.findByNoteID(updateNoteVO.getNoteID());
        note.setCreatedTime(updateNoteVO.getCreatedTime());
        note.setDescription(updateNoteVO.getDescription());
        note.setMaterial(updateNoteVO.getMaterial().replaceAll("\"","\'"));
        note.setNoteCover(updateNoteVO.getNoteCover());
        note.setNoteName(updateNoteVO.getNoteName());
        note.setPractice(updateNoteVO.getPractice());
        note.setTip(updateNoteVO.getTip());
        Note savedObject=noteRepository.saveAndFlush(note);
        int newNoteId=savedObject.getNoteID();
        System.out.println(newNoteId);
        // 添加标签
        List<String> subTagList=updateNoteVO.getSubTagList();
        for(String tagStr:subTagList){
            if(subtagRepository.findByName(tagStr)==null){
                return -1;
            }
            int tagId=subtagRepository.findByName(tagStr).getId();
            Category category=categoryRepository.findBySubtagIDAndNoteID(tagId,newNoteId);
            if(category==null){
                category=new Category();
            }
            category.setNoteID(newNoteId);
            category.setSubtagID(tagId);
            categoryRepository.saveAndFlush(category);
        }
        return newNoteId;
    }

    @Override
    public List<NoteVO> getCollectedBlog(String username) {
        List<NoteVO> noteList = new ArrayList<>();
        List<Collect> collectList = collectRepository.findByUseranme(username);
        for(Collect collect: collectList){
            int noteId = collect.getNoteID();
            noteList.add(noteVOHelper.getNoteVO(noteRepository.findByNoteID(noteId)));
        }
        return noteList;
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
