package edu.nju.cookery.controller;

import edu.nju.cookery.service.LoginService;
import edu.nju.cookery.service.SearchService;
import edu.nju.cookery.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @RequestMapping(value = "/api/search")
    public String search(@RequestParam(name = "key") String key,@RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);

        return JsonUtil.toJson(searchService.search(key,pageIndex));
    }

    @CrossOrigin
    @RequestMapping(value = "/api/searchFromPeople")
    public String searchFromCertainPerson(@RequestParam("name") String name, @RequestParam(name = "key") String key,
                                          @RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);
        int userId = loginService.getUserIDByName(name);
        return JsonUtil.toJson(searchService.searchFromPeople(userId, key, pageIndex));
    }
}
