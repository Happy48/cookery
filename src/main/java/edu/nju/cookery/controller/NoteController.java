package edu.nju.cookery.controller;

import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteService noteService;

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
        List<NoteVO> noteVOList=noteService.getCollectedBlog(userid);

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
        List<NoteVO> noteVOList =noteService.getTopPopularNote(number);
        return JsonUtil.toJson(noteVOList);
    }

    /**
     * 获取首页推荐
     * @return
     */
    @RequestMapping(value ="/api/indexRecommend")
    @CrossOrigin
    public String getIndexRecommend(){
        HashMap<String, String> result = noteService.getIndexRecommend();
        return JsonUtil.toJson(result);
    }

    /**
     * 某人收藏/取消收藏笔记
     * @param userid
     * @param noteid
     * @return 添加收藏成功，code为0；已有该收藏，code为1
     */
    @CrossOrigin
    @RequestMapping(value = "/api/collect",method = RequestMethod.GET)
    public String collectNote(@RequestParam("userid") int userid, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int code=noteService.addCollect(userid,noteid);
        resultMap.put("code",code+"");
        return JsonUtil.toJson(resultMap);
    }

    /**
     * 某人喜欢/取消喜欢笔记
     * @param userid
     * @param noteid
     * @return 对笔记添加喜欢成功，code为0；该笔记已有喜欢，调用此方法则取消喜欢，code为1
     */
    @CrossOrigin
    @RequestMapping(value = "/api/like",method = RequestMethod.GET)
    public String likeNote(@RequestParam("userid") int userid, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int code=noteService.addLike(userid,noteid);
        resultMap.put("code",code+"");
        return JsonUtil.toJson(resultMap);
    }
}
