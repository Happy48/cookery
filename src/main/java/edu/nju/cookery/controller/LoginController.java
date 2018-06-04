package edu.nju.cookery.controller;

import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.util.MD5Util;
import edu.nju.cookery.util.ParamCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 登陆方法
     * @param email 用户名信息
     * @param pass 用户密码
     * @return 返回的JSON数据
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @CrossOrigin
    public String login(@RequestParam("email") String email,
                        @RequestParam("pass") String pass){
        HashMap<String,String> resultMap=new HashMap<>();
        if (ParamCheckUtil.judgeEmpty(email)||ParamCheckUtil.judgeEmpty(pass)){
            resultMap.put("code",3+"");
            return JsonUtil.toJson(resultMap);
        }
        int code = loginService.login(email, pass);
        resultMap.put("code",code+"");
        if (code==0){
            //TODO 生成token
            String token=createToken(email,pass);
            stringRedisTemplate.opsForValue().set(email,token);
            resultMap.put("message",token);
        }
        return JsonUtil.toJson(resultMap);
    }

    /**
     * token 生成
     * @param email
     * @param pass
     * @return
     */
    private String createToken(String email,String pass){
        return MD5Util.encode(email+pass+new Date().getTime());
    }
}
