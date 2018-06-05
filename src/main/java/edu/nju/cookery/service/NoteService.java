package edu.nju.cookery.service;

import edu.nju.cookery.vo.NoteVO;

import java.util.List;

public interface NoteService {

    /**
     * 获取笔记列表
     * @param userID 用户id
     * @return
     */
    List<NoteVO> getBlogListByUserID(int userID);

}
