package edu.nju.cookery.controller;

import edu.nju.cookery.service.UserService;
import edu.nju.cookery.vo.UserVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获得用户个人信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "/api/userInfo",method = RequestMethod.GET)
    @CrossOrigin
    public String getUserInfo(@RequestParam("userid") int userid){
        UserVO userVO = userService.getUserInfo(userid);
        return JSONObject.fromObject(userVO).toString();//????
    }
}
