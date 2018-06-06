package edu.nju.cookery.service;

public interface CollectService {

    /**
     * 查找收藏笔记人数
     * @param noteID
     * @return
     */
    int getCollectCount(int noteID);

}
