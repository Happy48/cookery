package edu.nju.cookery.controller;

import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.SearchService;
import edu.nju.cookery.util.TokenUtil;
import edu.nju.cookery.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenUtil tokenUtil;

    @CrossOrigin
    @RequestMapping(value = "/api/search")
    public List<NoteVO> search(@RequestParam(name = "key") String key, @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);

        return searchService.search(key,pageIndex);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchFromPeople")
    public List<NoteVO> searchFromCertainPerson(@RequestParam("name") String name, @RequestParam(name = "key") String key,
                                                @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userId = loginService.getUserIDByName(name);
        return searchService.searchFromPeople(userId, key, pageIndex);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchMyBlog")
    public List<NoteVO> searchMyBlog(@RequestParam("token") String token, @RequestParam(name = "key") String key,
                                                @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);

        int userId= tokenUtil.getUid(token);
        return searchService.searchFromPeople(userId, key, pageIndex);
    }

}
