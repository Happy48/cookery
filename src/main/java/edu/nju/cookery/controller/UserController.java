package edu.nju.cookery.controller;

import edu.nju.cookery.service.UserService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.UserExceptIconVO;
import edu.nju.cookery.vo.UserVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    /**
     *  修改用户个人信息
     * @return 修改成功，code为0；修改失败，code为1
     */
    @RequestMapping(value="/api/changeInfo",method=RequestMethod.POST)
    @CrossOrigin
    public String changeInfo(@RequestParam("userExceptIconVO") UserExceptIconVO userExceptIconVO){
        HashMap<String,String> resultMap=new HashMap<>();
        int code=userService.changeInfo(userExceptIconVO);
        resultMap.put("code",code+"");
        return JsonUtil.toJson(resultMap);
    }

}
