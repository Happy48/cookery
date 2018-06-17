package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Follow;
import edu.nju.cookery.entity.UserInfo;
import edu.nju.cookery.repository.FollowRepository;
import edu.nju.cookery.repository.LoginRepository;
import edu.nju.cookery.repository.UserInfoRepository;
import edu.nju.cookery.service.FollowService;
import edu.nju.cookery.vo.FollowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public List<FollowVO> getMyAttention(int userID) {
        List<FollowVO> userInfoList = new ArrayList<>();
        List<Follow> followList = followRepository.findByUserID(userID);
        for(Follow follow: followList){
            UserInfo userInfo = userInfoRepository.findByUserID(follow.getFollowedID());
            FollowVO followVO = new FollowVO(loginRepository.findByUserID(follow.getFollowedID()).getUsername(), userInfo.getIcon());
            userInfoList.add(followVO);
        }
        return userInfoList;
    }

    @Override
    public int getFollowTotal(int userId) {
//        int all = followRepository.findByUserIDTotal(userId);
//        if(all/30==0){
//            return all/30;
//        }else{
//            return all/30+1;
//        }
        return followRepository.findByUserIDTotal(userId);
    }

    @Override
    public List<FollowVO> getFollowByUserIdAndPage(int userId, int page) {
        Pageable pageable = new PageRequest(page, 30);

        Page<Follow> follows = followRepository.findByUserID( userId , pageable);
        List<FollowVO> followVOList =new ArrayList<>(follows.getSize());
        for (Follow follow:follows.getContent()){
            UserInfo userInfo = userInfoRepository.findByUserID(follow.getFollowedID());
            FollowVO followVO = new FollowVO(loginRepository.findByUserID(follow.getFollowedID()).getUsername(), userInfo.getIcon());
            followVOList.add(followVO);
        }
        return followVOList;
    }
}
