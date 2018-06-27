package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Post;
import edu.nju.cookery.repository.PostRepository;
import edu.nju.cookery.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public int leaveNote(int userId, int noteId, int mainPostId, String content) {
        Post post = new Post();
        post.setUserID(userId);
        post.setNoteID(noteId);
        post.setMainPostID(mainPostId);
        post.setContent(content);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        post.setTime(timestamp);
        postRepository.save(post);
        return 0;
    }

    @Override
    public int getOriginalPostid(int postId) {
        Post post = postRepository.findByPostID(postId);
        while(post.getMainPostID() != 0){
            post = postRepository.findByPostID(post.getMainPostID());
        }
        return post.getPostID();
    }
}
