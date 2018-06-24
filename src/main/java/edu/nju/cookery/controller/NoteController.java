package edu.nju.cookery.controller;

import edu.nju.cookery.service.CategoryService;
import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.NewNoteVO;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

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
    public List<NoteVO> getNoteListByUserID(@RequestParam("name") String name,
                        @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userid = loginService.getUserIDByName(name);
        if(userid != -1){
            List<NoteVO> noteVOList = noteService.getNoteListByUserIdAndPage(userid, pageIndex);
            return noteVOList;
        }
        return null;
    }

    /**
     * 获取别人的笔记页数
     * @param name
     * @return
     */
    @RequestMapping(value = "/api/userNoteListTotalByUserID",method = RequestMethod.GET)
    @CrossOrigin
    public int getNoteListTotalByUserID(@RequestParam("name") String name){
        int userid = loginService.getUserIDByName(name);
        if(userid != -1){
            return noteService.getBlogsTotal(userid);
        }
        return 0;
    }


    /**
     * 获取我的笔记页数
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/myNoteListTotal",method = RequestMethod.GET)
    @CrossOrigin
    public int getMyNoteListTotal(@RequestParam("token") String token){
        int userid= tokenUtil.getUid(token);
        if(userid != -1){
            return noteService.getBlogsTotal(userid);
        }
        return 0;
    }

    /**
     * 获取我的笔记列表
     */
    @RequestMapping(value = "/api/myNoteList",method = RequestMethod.GET)
    @CrossOrigin
    public List<NoteVO> getMyNoteList(@RequestParam("token") String token,
                                      @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userid= tokenUtil.getUid(token);
        if(userid != -1){
            List<NoteVO> noteVOList = noteService.getNoteListByUserIdAndPage(userid, pageIndex);
            return noteVOList;
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
    public List<NoteVO> getCollectNoteListByUserID(@RequestParam("token") String token){
        int userid = tokenUtil.getUid(token);

        if(userid != -1){
            List<NoteVO> noteVOList=noteService.getCollectedBlog(userid);
            return noteVOList;
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
    public Set<NoteVO> getRecommendNote(@RequestParam("number") int number){
        Set<NoteVO> noteVOList =noteService.getRecommendNote(number);
        return noteVOList;
    }

    /**
     * 获取首页推荐
     * @return
     */
    @RequestMapping(value ="/api/indexRecommend")
    @CrossOrigin
    public HashMap<String, Object> getIndexRecommend(){
        HashMap<String, Object> result = noteService.getIndexRecommend();
        return result;
    }

    /**
     * 某人收藏/取消收藏笔记
     * @param token
     * @param noteid
     * @return 添加收藏成功，code为0；已有该收藏，code为1；没有该用户，code为2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/collect",method = RequestMethod.GET)
    public HashMap<String, String> collectNote(@RequestParam("token") String token, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int userid= tokenUtil.getUid(token);
        if(userid!=-1){
            int code=noteService.addCollect(userid,noteid);
            resultMap.put("code",code+"");
        }
        else{
            resultMap.put("code","2");
        }
        return resultMap;
    }

    /**
     * 某人喜欢/取消喜欢笔记
     * @param token
     * @param noteid
     * @return 对笔记添加喜欢成功，code为0；该笔记已有喜欢，调用此方法则取消喜欢，code为1；没有该用户，code为2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/like",method = RequestMethod.GET)
    public HashMap<String, String> likeNote(@RequestParam("token") String token, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int userid= tokenUtil.getUid(token);
        if(userid!=-1){
            int code=noteService.addLike(userid,noteid);
            resultMap.put("code",code+"");
        }
        else{
            resultMap.put("code","2");
        }
        return resultMap;
    }

    /**
     * 获得某人对某个笔记的喜欢
     * @param token
     * @param noteid
     * @return 某人有喜欢某笔记，code为0；某人没有喜欢某笔记，code为1；不存在该用户，code为2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/isLike",method = RequestMethod.GET)
    public HashMap<String, String> isLike(@RequestParam("token") String token, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int userid= tokenUtil.getUid(token);
        if(userid!=-1){
            int code=noteService.isLike(userid,noteid);
            resultMap.put("code",code+"");
        }
        else{
            resultMap.put("code","2");
        }
        return resultMap;
    }

    /**
     * 得到某人是否已经收藏了某笔记
     * @param token
     * @param noteid
     * @return 收藏了，返回0；还没有收藏，返回1；不存在该用户，返回2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/isCollect",method = RequestMethod.GET)
    public HashMap<String, String> isCollect(@RequestParam("token") String token, @RequestParam(name = "noteid") int noteid){
        HashMap<String,String> resultMap=new HashMap<>();
        int userid= tokenUtil.getUid(token);
        if(userid!=-1){
            int code=noteService.isCollect(userid,noteid);
            resultMap.put("code",code+"");
        }
        else{
            resultMap.put("code","2");
        }
        return resultMap;
    }





    /**
     * 添加笔记
     * @param token
     * @param noteName
     * @param noteCover
     * @param description
     * @param material
     * @param practice
     * @param tip
     * @param subtag
     * @return 添加笔记成功，code为0；子标签不在定义范围之内，code为1；没有该用户，code为2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/createNote",method = RequestMethod.POST)
    public HashMap<String, String> createNote(@RequestParam("token") String token, @RequestParam("noteName") String noteName,
                                              @RequestParam("noteCover") String noteCover, @RequestParam("description") String description,
                                              @RequestParam("material") String material, @RequestParam("practice") String practice,
                                              @RequestParam("tip") String tip, @RequestParam("subtag") String subtag){

        HashMap<String,String> resultMap=new HashMap<>();
        int userid= tokenUtil.getUid(token);
        if(userid != -1){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String[]subtagArr=subtag.split(",");
            List<String>subtagList= Arrays.asList(subtagArr);
            NewNoteVO newNoteVO=new NewNoteVO(userid,noteName,noteCover,description,material,practice,timestamp,tip,subtagList);
            int code=noteService.createNote(newNoteVO);
            resultMap.put("code",code+"");
        }
        else{
            resultMap.put("code","2");
        }
        return resultMap;
    }

    /**
     * 根据分类寻找笔记
     * @param className
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/getNoteList",method = RequestMethod.GET)
    public List<NoteVO> getNoteList(@RequestParam("class")String className,@RequestParam("page")int page){
        List<NoteVO> noteVOList  = categoryService.getNoteByClazz(className,page);
        return noteVOList;
    }

    /**
     * 根据分类寻找笔记的总条数
     * @param className
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/getNoteListTotal",method = RequestMethod.GET)
    public int getNoteListTotal(@RequestParam("class")String className){

        return categoryService.getNoteTotalByClazz(className);
    }

    /**
     * 根据分类寻找我的或别人的笔记
     * @param className
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/getNoteListByTag",method = RequestMethod.GET)
    public List<NoteVO> getNoteListByTag(@RequestParam("class")String className,@RequestParam("page")int page,@RequestParam("token") String token,@RequestParam("name") String name){

        int userid=0;
        if(!token.equals("")){
            userid= tokenUtil.getUid(token);
        }else {
            userid = loginService.getUserIDByName(name);
        }
        List<NoteVO> noteVOList  = categoryService.getNoteByClazz(className,page,userid);
        return noteVOList;
    }

    /**
     * 根据分类寻找我的或别人的笔记的总条数
     * @param className
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/getNoteListTotalByTag",method = RequestMethod.GET)
    public int getNoteListTotalByTag(@RequestParam("class")String className,@RequestParam("token") String token,@RequestParam("name") String name){
        int userid=0;
        if(!token.equals("")){
            userid= tokenUtil.getUid(token);
        }else {
            userid = loginService.getUserIDByName(name);
        }

        return categoryService.getNoteTotalByClazz(className,userid);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getNoteByNoteID",method = RequestMethod.GET)
    public NoteVO getNoteInfo(@RequestParam("noteID")int noteID){
        return noteService.getNoteInfo(noteID);
    }
}
