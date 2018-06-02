package edu.nju.cookery.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class TestController {
    @RequestMapping(value="/test",method= RequestMethod.POST)
    @CrossOrigin
    public String sayHello(@RequestParam("file") MultipartFile file){
        long size=-1;
        if (!file.isEmpty()){
            size=file.getSize();
        }
        return size+"";
    }
}