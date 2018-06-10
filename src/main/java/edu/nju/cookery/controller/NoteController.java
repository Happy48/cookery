package edu.nju.cookery.controller;

import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.NewNoteVO;
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
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 按照页数获取某人的笔记列表
     * @param name
     * @param page
     * @return
     */
    @RequestMapping(value = "/api/userNoteList",method = RequestMethod.GET)
    @CrossOrigin
    public String getNoteListByUserID(@RequestParam("name") String name,
                        @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userid = loginService.getUserIDByName(name);
        if(userid != -1){
            List<NoteVO> noteVOList = noteService.getNoteListByUserIdAndPage(userid, pageIndex);
            return JsonUtil.toJson(noteVOList);
        }
        return null;
    }

    /**
     * 获取某人收藏的笔记列表
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/userCollection",method = RequestMethod.GET)
    @CrossOrigin
    public String getCollectNoteListByUserID(@RequestParam("token") String token){
        int userid = tokenUtil.getUid(token);

        if(userid != -1){
            List<NoteVO> noteVOList=noteService.getCollectedBlog(userid);
            return JsonUtil.toJson(noteVOList);
        }
        return null;
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

    @CrossOrigin
    @RequestMapping(value = "/api/createNote",method = RequestMethod.POST)
    public String createNote(@RequestParam("newNote")NewNoteVO newNoteVO){
        HashMap<String,String> resultMap=new HashMap<>();
        int code=noteService.createNote(newNoteVO);
        resultMap.put("code",code+"");
        return JsonUtil.toJson(resultMap);
    }

    /**
     * 根据分类寻找笔记
     * @param className
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/getNoteList",method = RequestMethod.GET)
    public String getNoteList(@RequestParam("class")String className){
        List<NoteVO> noteVOList  = categoryService.getNoteByClazz(className);
        return JsonUtil.toJson(noteVOList);
    }
}
