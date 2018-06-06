package edu.nju.cookery.service;

import edu.nju.cookery.entity.Note;

import java.util.List;

public interface NoteService {

    /**
     * 获取用户列表
     * @param userID
     * @return
     */
    List<Note> getBlogListByUserID(int userID);

    /**
     * 查找用户收藏笔记
     * @param userID
     * @return
     */
    List<Note> getCollectedBlog(int userID);

}
