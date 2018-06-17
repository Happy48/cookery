package edu.nju.cookery.service;

import edu.nju.cookery.vo.SubTagVO;

import java.util.List;

public interface FoodClassService {

    public List<SubTagVO> getFoodClass();

    public List<SubTagVO> getFoodClass(int userID);

    public List<SubTagVO> getFoodClassByNoteId(int noteId);
}
