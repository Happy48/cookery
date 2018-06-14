package edu.nju.cookery.controller;

import edu.nju.cookery.service.PostService;
import edu.nju.cookery.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 发帖评论
     * @param token
     * @param noteId
     * @param content
     * @return
     */
    @RequestMapping(value = "/api/leaveReply",method = RequestMethod.POST)
    @CrossOrigin
    public HashMap<String, String> login(@RequestParam("token") String token,
                                         @RequestParam("noteId") int noteId, @RequestParam("content") String content){
        int userId = tokenUtil.getUid(token);

        HashMap<String,String> resultMap=new HashMap<>();
        int result = postService.leaveNote(userId, noteId, 0, content);
        resultMap.put("code",result+"");
        return resultMap;
    }
}
