package edu.nju.cookery.service;

public interface LikeService {

    /**
     * 获得笔记喜欢人数
     * @param noteID
     * @return
     */
    int getLikeCount(int noteID);
}
