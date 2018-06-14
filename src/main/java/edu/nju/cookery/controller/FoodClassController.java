package edu.nju.cookery.controller;

import edu.nju.cookery.service.FoodClassService;
import edu.nju.cookery.util.JsonUtil;
import edu.nju.cookery.vo.SubTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关于笔记分类的内容
 */
@RestController
@CrossOrigin
public class FoodClassController {
    @Autowired
    private FoodClassService foodClassService;

    /**
     * 获取全部笔记分类信息
     * @return
     */
    @RequestMapping(value = "/api/getList")
    public List<SubTagVO> getList(){
        return foodClassService.getFoodClass();
    }
}
