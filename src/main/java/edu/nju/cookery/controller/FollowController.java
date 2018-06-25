package edu.nju.cookery.controller;

import edu.nju.cookery.service.FollowService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.FollowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FollowController {

    @Autowired
    private FollowService followService;
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 获取用户关注列表
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/myFollowList",method = RequestMethod.GET)
    @CrossOrigin
    public List<FollowVO> getMyAttention(@RequestParam("token") String token){
        int userid = tokenUtil.getUid(token);
        if(userid!=-1){
            List<FollowVO> followVOList = followService.getMyAttention(userid);
            return followVOList;
        }
        return null;
    }

    /**
     * 获取用户关注列表
     * @param username
     * @return
     */
    @RequestMapping(value = "/api/hisFollowList",method = RequestMethod.GET)
    @CrossOrigin
    public List<FollowVO> getHisAttention(@RequestParam("username") String username){
        List<FollowVO> followVOList = followService.getHisAttention(username);
        return followVOList;
    }

    /**
     * 获取我的关注页数
     * @param token
     * @return
     */
    @RequestMapping(value = "/api/myFollowTotal",method = RequestMethod.GET)
    @CrossOrigin
    public int getMyFollowTotal(@RequestParam("token") String token){
        int userid= tokenUtil.getUid(token);
        if(userid != -1){
            return followService.getFollowTotal(userid);
        }
        return 0;
    }

    /**
     * 获取我的关注列表
     */
    @RequestMapping(value = "/api/myFollowListByPage",method = RequestMethod.GET)
    @CrossOrigin
    public List<FollowVO> getMyFollowListByPage(@RequestParam("token") String token,
                                      @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userid= tokenUtil.getUid(token);
        if(userid != -1){
            List<FollowVO> followVOList = followService.getFollowByUserIdAndPage(userid, pageIndex);
            return followVOList;
        }
        return null;
    }
}
