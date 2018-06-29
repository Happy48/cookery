package edu.nju.cookery.controller;

import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.UserService;
import edu.nju.cookery.util.DateHelper;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.UserExceptIconVO;
import edu.nju.cookery.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 获得用户个人信息
     * @param name
     * @return
     */
    @RequestMapping(value = "/api/userInfo",method = RequestMethod.GET)
    @CrossOrigin
    public UserVO getUserInfo(@RequestParam("name") String name){
        int userid = loginService.getUserIDByName(name);
        if(userid != -1){
            UserVO userVO = userService.getUserInfo(userid);
            return userVO;//???
        }
        return null;
    }

    /**
     * 获得用户个人信息（通过token）
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/userInfoByToken",method = RequestMethod.GET)
    @CrossOrigin
    public UserVO userInfoByToken(@RequestParam("token") String token){
        int userid = 0;
        if(!token.equals("")){
            userid= tokenUtil.getUid(token);
            if(userid != -1){
                UserVO userVO = userService.getUserInfo(userid);
                return userVO;
            }
        }else {
            return null;
        }
        return null;
    }

    /**
     * 修改用户个人头像
     * @param token
     *  @param imgUrl
     * @return 修改成功，返回0；修改失败，返回1；不存在该用户，返回2
     */
    @RequestMapping(value = "/api/changeHeadIcon",method = RequestMethod.GET)
    @CrossOrigin
    public HashMap<String, String> userInfoByToken(@RequestParam("token") String token, @RequestParam("imgUrl") String imgUrl){
        HashMap<String,String> resultMap=new HashMap<>();
        int userid = 0;
        if(!token.equals("")){
            userid= tokenUtil.getUid(token);
            if(userid != -1){
                int code=userService.changeHeadIcon(userid,imgUrl);
                resultMap.put("code",code+"");
            }
        }else {
            resultMap.put("code","2");
        }
        return resultMap;
    }



    /**
     * 修改用户个人信息
     * @param token
     * @param userName
     * @param address
     * @param sex
     * @param birthday
     * @param introduction
     * @param phoneNumber
     * @param userPwd
     * @param email
     * @return 0表示成功 1表示修改的用户名已存在 2表示修改的邮箱已存在 3表示用户不存在
     */
    @RequestMapping(value="/api/changeInfo",method=RequestMethod.POST)
    @CrossOrigin
    public HashMap<String, String> changeInfo(@RequestParam("token") String token, @RequestParam("userName") String userName, @RequestParam("address") String address,
                                              @RequestParam("sex") int sex, @RequestParam("birthday") String birthday,
                                              @RequestParam("introduction") String introduction, @RequestParam("phoneNumber") String phoneNumber,
                                              @RequestParam("userPwd") String userPwd, @RequestParam("email") String email){
        HashMap<String,String> resultMap=new HashMap<>();
        int uid= tokenUtil.getUid(token);
        if(uid != -1) {
            Date birthdayStr= DateHelper.strToSQLDate(birthday);
            boolean sex_boolean=(sex==0)?false:true;   // 女=0，男=1
            UserExceptIconVO vo=new UserExceptIconVO(uid,userName,address,sex_boolean,birthdayStr,introduction,phoneNumber,userPwd,email);
            int code=userService.changeInfo(vo);
            resultMap.put("code",code+"");
            return resultMap;
        }
        else{
            resultMap.put("code","3");
            return resultMap;
        }
    }

    /**
     * 获得某人对某个博主的关注
     *
     * @param token
     * @param name
     * @return 某人有关注某博主，code为0；某人没有喜欢某博主，code为1；不存在该用户，code为2
     */
    @CrossOrigin
    @RequestMapping(value = "/api/isFocus", method = RequestMethod.GET)
    public HashMap<String, String> isFocus(@RequestParam("token") String token, @RequestParam(name = "name") String name) {
        HashMap<String, String> resultMap = new HashMap<>();
        int userid = tokenUtil.getUid(token);
        int focusid = loginService.getUserIDByName(name);
        if (userid != -1) {
            int code = userService.isFocus(userid, focusid);
            resultMap.put("code", code + "");
        } else {
            resultMap.put("code", "2");
        }
        return resultMap;
    }

}
