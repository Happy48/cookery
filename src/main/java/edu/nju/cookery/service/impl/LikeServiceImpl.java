package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Like;
import edu.nju.cookery.repository.LikeRepository;
import edu.nju.cookery.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public int getLikeCount(int noteID) {
        List<Like> likeList = likeRepository.findThroughNoteID(noteID);
        return likeList.size();
    }
}
