package edu.nju.cookery.entity;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 帖子信息（帖子id，用户id，笔记id，发布时间，内容，回帖id，主贴为0）
 */
@Entity
public class Post {
    private int postID;
    private int userID;
    private int noteID;
    private Timestamp time;
    private String content;
    private int mainPostID;

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    @Basic
    @Column(name="user_id")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name="note_id")
    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    @Basic
    @Column(name="time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name="content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name="mainpost_id")
    public int getMainPostID() {
        return mainPostID;
    }

    public void setMainPostID(int mainPostID) {
        this.mainPostID = mainPostID;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", userID=" + userID +
                ", noteID=" + noteID +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", mainPostID=" + mainPostID +
                '}';
    }
}
