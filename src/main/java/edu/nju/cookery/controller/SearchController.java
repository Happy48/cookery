package edu.nju.cookery.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @CrossOrigin
    @RequestMapping(value = "/search")
    public String search(@RequestParam(name = "key") String key,@RequestParam(name = "page",required = false,defaultValue = "0")String page){
        int pageIndex=Integer.parseInt(page);

        return null;
    }
}
