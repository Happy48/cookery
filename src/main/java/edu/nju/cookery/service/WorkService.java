package edu.nju.cookery.service;

import edu.nju.cookery.vo.NoteVO;

import java.util.List;

public interface WorkService {

    /**
     * 创建作品
     * @param userid
     * @param noteid
     * @param picUrl
     * @param content
     * @return 0 成功 1失败 2用户不存在
     */
    int createWork(int userid,int noteid,String picUrl,String content);

}
