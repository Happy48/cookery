package edu.nju.cookery.controller;

import edu.nju.cookery.service.FoodClassService;
import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.SubTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关于笔记分类的内容
 */
@RestController
@CrossOrigin
public class FoodClassController {

    @Autowired
    private FoodClassService foodClassService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private LoginService loginService;

    /**
     * 获取全部笔记分类信息
     * @return
     */
    @RequestMapping(value = "/api/getList")
    public List<SubTagVO> getList(){
        return foodClassService.getFoodClass();
    }

    /**
     * 获取用户笔记分类信息
     */
    @RequestMapping(value = "/api/getUserTagList")
    @CrossOrigin
    public List<SubTagVO> getUserTagList(@RequestParam("token") String token,@RequestParam("name") String name){
        int userid=0;
        if(!token.equals("")){
             userid= tokenUtil.getUid(token);
        }else {
            userid = loginService.getUserIDByName(name);
        }
        return foodClassService.getFoodClass(userid);
    }

    @RequestMapping(value = "/api/getTagByNoteId")
    @CrossOrigin
    public List<SubTagVO> getTagByNoteId(@RequestParam("noteId") int noteId){
        return foodClassService.getFoodClassByNoteId(noteId);
    }
}
