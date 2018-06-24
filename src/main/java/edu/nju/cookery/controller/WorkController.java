package edu.nju.cookery.controller;

import edu.nju.cookery.service.WorkService;
import edu.nju.cookery.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@CrossOrigin
public class WorkController {
    @Autowired
    private WorkService workService;
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = "/api/createWork", method = RequestMethod.POST)
    @CrossOrigin
    public HashMap<String, String> createWork(@RequestParam("token") String token, @RequestParam("noteid") int noteid,
                                              @RequestParam("picUrl") String picUrl, @RequestParam("content") String content) {
        HashMap<String, String> resultMap = new HashMap<>();
        int userid = tokenUtil.getUid(token);
        if (userid != -1) {
            int code=workService.createWork(userid,noteid,picUrl,content);
            resultMap.put("code",code + "");
        } else{
            resultMap.put("code","2");
        }
        return resultMap;
    }
}
