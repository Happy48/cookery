package edu.nju.cookery.repository;


import edu.nju.cookery.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post,Integer> {

    /**
     * 获取笔记评论
     * @param noteId
     * @return
     */
    List<Post> findByNoteID(int noteId);

    /**
     * 根据id获取帖子
     * @param postId
     * @return
     */
    Post findByPostID(int postId);
}
