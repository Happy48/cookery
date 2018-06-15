package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.*;
import edu.nju.cookery.repository.*;
import edu.nju.cookery.service.NoteDetailService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class NoteDetailServiceImpl implements NoteDetailService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private CollectRepository collectRepository;
    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public NoteDetailVO getNoteDetail(int noteId) {
        Note note = noteRepository.findByNoteID(noteId);

        String foodTitle = note.getNoteName();
        String foodPic = note.getNoteCover();
        String foodDesc = note.getDescription();
        int foodLikes = likeRepository.findThroughNoteID(noteId).size();
        Timestamp foodCreateTime = note.getCreatedTime();
        int foodCollect = collectRepository.findByNoteID(noteId).size();

        List<MaterialVO> materialVOList = new ArrayList<>();//??????
        String material = note.getMaterial().substring(1, note.getMaterial().length()-1);
        //
        List<String> name = new ArrayList<>();
        List<String> unit = new ArrayList<>();

        String[] group = material.split(", ");
        for(String sss:group){
            if(!sss.endsWith("}")){
                sss= sss + "}";
            }
            if(!sss.startsWith("{")){
                sss = "{"+sss;
            }
            Map<String, String> map = JsonUtil.fromString(sss);
            if(map.get("name")!=null){
                name.add(map.get("name"));
            }else{
                unit.add(map.get("unit"));
            }
        }
        for(int i=0;i<name.size();i++){
            MaterialVO materialVO = new MaterialVO(name.get(i), unit.get(i));
            materialVOList.add(materialVO);
        }
        //

        List<StepVO> stepVOList = new ArrayList<>();//??????
        String step = note.getPractice().substring(1, note.getPractice().length()-1);;
        //
        List<String> img = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> information = new ArrayList<>();

        String[] groupS = step.split(", ");
        for(String sss:groupS){
            if(!sss.startsWith("{")){
                sss = "{"+sss;
            }
            if(!sss.endsWith("}")){
                sss= sss + "}";
            }
            Map<String, String> map = JsonUtil.fromString(sss);
            if(map.get("img")!=null){
                img.add(map.get("img"));
            }else if(map.get("id")!=null){
                id.add(map.get("id"));
            }else{
                information.add(map.get("information"));
            }
        }
        for(int i=0;i<id.size();i++){
            StepVO stepVO = new StepVO(Integer.parseInt(id.get(i)), information.get(i), img.get(i));
            stepVOList.add(stepVO);
        }
        //

        List<WorkVO> workVOList = new ArrayList<>();
        List<Work> works = workRepository.findByNoteID(noteId);
        for(Work work: works){
            int userID  = work.getUserID();
            String userName = loginRepository.findByUserID(userID).getUsername();
            WorkVO workVO = new WorkVO(work.getUserID(), work.getPicture(), work.getDescription(), userName);
            workVOList.add(workVO);
        }

        List<CommentVO> commentVOList = new ArrayList<>();
        List<Post> posts = postRepository.findByNoteID(noteId);
        for(Post post: posts){
            int userID = post.getUserID();
            UserVO userVO = null;
            UserInfo userInfo = userInfoRepository.findByUserID(userID);
            Login login = loginRepository.findByUserID(userID);
            if(userInfo != null && login != null){
                userVO = new UserVO(userID, login.getUsername(), userInfo.isSex(), userInfo.getIntroduction(), userInfo.getIcon(),
                        login.getPassword(), userInfo.getBirthday(), login.getEmail(), userInfo.getPhoneNumber(), userInfo.getAddress());
            }
            CommentVO commentVO = new CommentVO(post.getUserID(), post.getTime(), post.getContent(), userVO.getUserName(), userVO.getIcon());
            commentVOList.add(commentVO);
        }

        int userID =         note.getUserID();
;
        UserVO userVO = null;
        UserInfo userInfo = userInfoRepository.findByUserID(userID);
        Login login = loginRepository.findByUserID(userID);
        if(userInfo != null && login != null){
            userVO = new UserVO(userID, login.getUsername(), userInfo.isSex(), userInfo.getIntroduction(), userInfo.getIcon(),
                    login.getPassword(), userInfo.getBirthday(), login.getEmail(), userInfo.getPhoneNumber(), userInfo.getAddress());
        }

        NoteDetailVO noteDetailVO = new NoteDetailVO(foodTitle, foodPic, foodDesc, foodLikes, foodCreateTime, foodCollect, noteId, userVO, materialVOList, stepVOList, workVOList, commentVOList);
        return noteDetailVO;
    }
}
