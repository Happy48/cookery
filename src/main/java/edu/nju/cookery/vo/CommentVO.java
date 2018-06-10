package edu.nju.cookery.vo;

import java.sql.Timestamp;

public class CommentVO {

    private int userId;
    private Timestamp time;
    private String content;

    public CommentVO(int userId, Timestamp time, String content) {
        this.userId = userId;
        this.time = time;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "userId=" + userId +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
