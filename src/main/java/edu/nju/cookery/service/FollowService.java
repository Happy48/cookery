package edu.nju.cookery.service;

import edu.nju.cookery.vo.FollowVO;

import java.util.List;

public interface FollowService {

    /**
     * 获得关注人的列表
     * @param userID 用户id
     * @return 关注人信息列表
     */
    List<FollowVO> getMyAttention(int userID);
}
