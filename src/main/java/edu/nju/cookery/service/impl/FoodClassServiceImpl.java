package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Subtag;
import edu.nju.cookery.repository.NoteRepository;
import edu.nju.cookery.repository.SubtagRepository;
import edu.nju.cookery.service.FoodClassService;
import edu.nju.cookery.vo.SubTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Component
public class FoodClassServiceImpl implements FoodClassService {
    @Autowired
    private SubtagRepository subtagRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public List<SubTagVO> getFoodClass() {
        List<Subtag> subtags = subtagRepository.findAll();
        List<SubTagVO> subTagVOS=new ArrayList<>(subtags.size());
        for (Subtag subtag:subtags){
            subTagVOS.add(new SubTagVO(subtag.getId(),subtag.getName()));
        }

        return subTagVOS;

    }

    @Override
    public List<SubTagVO> getFoodClass(int userID) {
        List<Subtag> subtags = subtagRepository.findByUserID(userID);
        HashMap<Integer,SubTagVO> subTagVOS=new HashMap<>();
        List<SubTagVO> subTagVOList=new ArrayList<>();
        for (Subtag subtag:subtags){
            if(!subTagVOS.containsKey(subtag.getId())){
                SubTagVO subTagVO=new SubTagVO(subtag.getId(),subtag.getName());
                subTagVOS.put(subtag.getId(),subTagVO);
                subTagVOList.add(subTagVO);
            }
        }
        return subTagVOList;
    }
}
