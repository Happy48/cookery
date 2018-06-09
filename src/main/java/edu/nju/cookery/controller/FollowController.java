package edu.nju.cookery.controller;

import edu.nju.cookery.service.FollowService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.FollowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FollowController {

    @Autowired
    private FollowService followService;

    @RequestMapping(value = "/api/myFollowList",method = RequestMethod.GET)
    @CrossOrigin
    public String getMyAttention(@RequestParam("userid") int userid){
        List<FollowVO> followVOList = followService.getMyAttention(userid);

        return JsonUtil.toJson(followVOList);
    }
}
