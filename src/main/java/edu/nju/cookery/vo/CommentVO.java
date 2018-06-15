package edu.nju.cookery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class CommentVO {

    private int userId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp time;
    private String content;
    private String userName;
    private String icon;

    public CommentVO(int userId, Timestamp time, String content, String userName, String icon) {
        this.userId = userId;
        this.time = time;
        this.content = content;
        this.userName = userName;
        this.icon = icon;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "userId=" + userId +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
