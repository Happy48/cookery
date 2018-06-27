package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.*;
import edu.nju.cookery.repository.*;
import edu.nju.cookery.service.NoteDetailService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

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

        List<MaterialVO> materialVOList = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> unit = new ArrayList<>();
        try {
            com.alibaba.fastjson.JSONArray jarr = com.alibaba.fastjson.JSONArray.parseArray(note.getMaterial());
            for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) {
                com.alibaba.fastjson.JSONObject job = (com.alibaba.fastjson.JSONObject) iterator.next();
                Set<String> s=job.keySet();
                for (String string : s) {
                    if(string.equals("name")){
                        name.add(job.get(string).toString());
                    }else{
                        unit.add(job.get(string).toString());
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i<name.size();i++){
            MaterialVO materialVO = new MaterialVO(name.get(i), unit.get(i));
            materialVOList.add(materialVO);
        }
//        String material = note.getMaterial().substring(1, note.getMaterial().length()-1);
//        //
//        List<String> name = new ArrayList<>();
//        List<String> unit = new ArrayList<>();
//
//        String[] group = material.split(", ");
//        for(String sss:group){
//            if(!sss.endsWith("}")){
//                sss= sss + "}";
//            }
//            if(!sss.startsWith("{")){
//                sss = "{"+sss;
//            }
//            Map<String, String> map = JsonUtil.fromString(sss);
//            if(map.get("name")!=null){
//                name.add(map.get("name"));
//            }else{
//                unit.add(map.get("unit"));
//            }
//        }
//        for(int i=0;i<name.size();i++){
//            MaterialVO materialVO = new MaterialVO(name.get(i), unit.get(i));
//            materialVOList.add(materialVO);
//        }
        //

        List<StepVO> stepVOList = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> img = new ArrayList<>();
        List<String> information = new ArrayList<>();
        try {
            com.alibaba.fastjson.JSONArray jarr = com.alibaba.fastjson.JSONArray.parseArray(note.getPractice());
            for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) {
                com.alibaba.fastjson.JSONObject job = (com.alibaba.fastjson.JSONObject) iterator.next();
                Set<String> s=job.keySet();
                for (String string : s) {
                    if(string.equals("img")){
                        img.add(job.get(string).toString());
                    }else if(string.equals("information")){
                        information.add(job.get(string).toString());
                    }else{
                        id.add(job.get(string).toString());
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i<id.size();i++){
            StepVO stepVO = new StepVO(Integer.parseInt(id.get(i)), information.get(i), img.get(i));
            stepVOList.add(stepVO);
        }
//        String step = note.getPractice().substring(1, note.getPractice().length()-1);;
//        //
//        List<String> img = new ArrayList<>();
//        List<String> id = new ArrayList<>();
//        List<String> information = new ArrayList<>();
//
//        String[] groupS = step.split(", ");
//        for(String sss:groupS){
//            if(!sss.startsWith("{")){
//                sss = "{"+sss;
//            }
//            if(!sss.endsWith("}")){
//                sss= sss + "}";
//            }
//            Map<String, String> map = JsonUtil.fromString(sss);
//            if(map.get("img")!=null){
//                img.add(map.get("img"));
//            }else if(map.get("id")!=null){
//                id.add(map.get("id"));
//            }else{
//                information.add(map.get("information"));
//            }
//        }
//        for(int i=0;i<id.size();i++){
//            StepVO stepVO = new StepVO(Integer.parseInt(id.get(i)), information.get(i), img.get(i));
//            stepVOList.add(stepVO);
//        }
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
            CommentVO commentVO = new CommentVO(post.getPostID(), post.getMainPostID(), post.getUserID(), post.getTime(), post.getContent(), userVO.getUserName(), userVO.getIcon());
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

 //   public static void main(String[] args){
//        String material = "[{'name': '芋头', 'unit': '一个'}, {'name': '五花肉', 'unit': '适量'}, {'name': '冰糖', 'unit': '适量'}, {'name': '姜片', 'unit': '适量'}, {'name': '八角', 'unit': '两个'}, {'name': '桂皮', 'unit': '适量'}, {'name': '料酒', 'unit': '适量'}]";
//        List<String> name = new ArrayList<>();
//        List<String> unit = new ArrayList<>();
//        try {
//            com.alibaba.fastjson.JSONArray jarr = com.alibaba.fastjson.JSONArray.parseArray(material);
//            for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) {
//                com.alibaba.fastjson.JSONObject job = (com.alibaba.fastjson.JSONObject) iterator.next();
//                Set<String> s=job.keySet();
//                for (String string : s) {
//                    if(string.equals("name")){
//                        name.add(job.get(string).toString());
//                    }else{
//                        unit.add(job.get(string).toString());
//                    }
//                }
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            JSONArray jsonObject = JSONArray.fromObject(material);
//            for (Iterator<Object> iterator = jsonObject.iterator(); iterator.hasNext();) {
//                int ct = 0;
//                JSONObject job = (JSONObject) iterator.next();
//                Iterator<Object> it=job.keys();
//                while (it.hasNext()){
//                    Object o = job.get(it.next());
//                    System.out.println(o);
//                    if(ct%2==0){
//                        name.add(o.toString());
//                    }else{
//                        unit.add(o.toString());
//                    }
//                    ct++;
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println(name);
//        System.out.println(unit);

//        String step = "[{\"information\": \"?????????????????170???\", \"id\": 1, \"img\": \"http://127.0.0.1:10086/http:s2cdnxiachufangcomd4c524228c0011e6b87c0242ac110003_199w_301hjpgimageView22w300interlace1q90\"}, {\"information\": \"????\", \"id\": 2, \"img\": \"http://127.0.0.1:10086/http:s1cdnxiachufangcomd4e5554e8c0011e6b87c0242ac110003_200w_300hjpg@2o_50sh_1pr_1l_300w_90q_1wh\"}, {\"information\": \"????????????????\", \"id\": 3, \"img\": \"http://127.0.0.1:10086/http:s1cdnxiachufangcomd5096b648c0011e6a9a10242ac110002_202w_300hjpg@2o_50sh_1pr_1l_300w_90q_1wh\"}, {\"information\": \"??????2?????????????????\", \"id\": 4, \"img\": \"http://127.0.0.1:10086/http:s2cdnxiachufangcomd5287c488c0011e6a9a10242ac110002_201w_301hjpgimageView22w300interlace1q90\"}, {\"information\": \"???????????????\", \"id\": 5, \"img\": \"http://127.0.0.1:10086/http:s1cdnxiachufangcomd54343f28c0011e6b87c0242ac110003_203w_301hjpg@2o_50sh_1pr_1l_300w_90q_1wh\"}, {\"information\": \"??????????????????????\", \"id\": 6, \"img\": \"http://127.0.0.1:10086/http:s2cdnxiachufangcomd56837e88c0011e6b87c0242ac110003_201w_299hjpgimageView22w300interlace1q90\"}, {\"information\": \"???????????????\", \"id\": 7, \"img\": \"http://127.0.0.1:10086/http:s2cdnxiachufangcomd587764e8c0011e6a9a10242ac110002_201w_300hjpgimageView22w300interlace1q90\"}, {\"information\": \"??????????????????????????????????170????25?30????????????????????????????????\", \"id\": 8, \"img\": \"http://127.0.0.1:10086/http:s2cdnxiachufangcomd5a3aeea8c0011e6a9a10242ac110002_201w_298hjpgimageView22w300interlace1q90\"}]";
//        List<String> id = new ArrayList<>();
//        List<String> img = new ArrayList<>();
//        List<String> information = new ArrayList<>();
//        try {
//            com.alibaba.fastjson.JSONArray jarr = com.alibaba.fastjson.JSONArray.parseArray(step);
//            for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) {
//                com.alibaba.fastjson.JSONObject job = (com.alibaba.fastjson.JSONObject) iterator.next();
//                Set<String> s=job.keySet();
//                for (String string : s) {
//                    if(string.equals("img")){
//                        img.add(job.get(string).toString());
//                    }else if(string.equals("information")){
//                        information.add(job.get(string).toString());
//                    }else{
//                        id.add(job.get(string).toString());
//                    }
//                }
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println(id);
//        System.out.println(img);
//        System.out.println(information);
 //   }
}
