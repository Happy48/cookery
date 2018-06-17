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

    /**
     * 获取关注列表页数
     * @param userId
     * @return
     */
    int getFollowTotal(int userId);

    /**
     * 根据页数和用户id获得关注列表
     * @param userId
     * @param page
     * @return
     */
    List<FollowVO> getFollowByUserIdAndPage(int userId, int page);
}
