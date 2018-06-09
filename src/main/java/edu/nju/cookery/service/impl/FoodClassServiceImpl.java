package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Subtag;
import edu.nju.cookery.repository.SubtagRepository;
import edu.nju.cookery.service.FoodClassService;
import edu.nju.cookery.vo.SubTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodClassServiceImpl implements FoodClassService {
    @Autowired
    private SubtagRepository subtagRepository;
    @Override
    public List<SubTagVO> getFoodClass() {
        List<Subtag> subtags = subtagRepository.findAll();
        List<SubTagVO> subTagVOS=new ArrayList<>(subtags.size());
        for (Subtag subtag:subtags){
            subTagVOS.add(new SubTagVO(subtag.getId(),subtag.getName()));
        }

        return subTagVOS;

    }
}
