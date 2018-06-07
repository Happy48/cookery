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

    /**
     * 获得喜欢人数最多的若干篇笔记
     * @param num 笔记数量
     * @return
     */
    List<Note> getTopPopularNote(int num);
}
