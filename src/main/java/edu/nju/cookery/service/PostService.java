package edu.nju.cookery.service;

public interface PostService {

    /**
     * 对于笔记评论或者回复评论
     * @param userId
     * @param noteId
     * @param mainPostId
     * @param content
     * @return
     */
    int leaveNote(int userId, int noteId, int mainPostId, String content);
}
