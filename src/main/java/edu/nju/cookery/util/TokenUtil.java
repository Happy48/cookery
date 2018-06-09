package edu.nju.cookery.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据token获取uid,如果uid找不到，设置uid为-1
     * @param token
     * @return
     */
    public int getUid(String token){
        int uid;
        try {
            uid=Integer.parseInt(stringRedisTemplate.opsForValue().get("aaa"));
        }catch (Exception e){
            uid=-1;
        }
        return uid;
    }
}
