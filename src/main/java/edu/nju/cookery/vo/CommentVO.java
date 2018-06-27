package edu.nju.cookery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.nju.cookery.util.PicUrl;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;

public class CommentVO {

    private int postid;
    private int mainpostid;
    private int userId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp time;
    private String content;
    private String userName;
    private String icon;


    public CommentVO(int postid, int mainpostid, int userId, Timestamp time, String content, String userName, String icon) {
        this.postid = postid;
        this.mainpostid = mainpostid;
        this.userId = userId;
        this.time = time;
        this.content = content;
        this.userName = userName;
        this.icon = icon.replaceAll("127.0.0.1",PicUrl.picUrl);
    }

    public CommentVO(int userId, Timestamp time, String content, String userName, String icon) {
        this.userId = userId;
        this.time = time;
        this.content = content;

        this.userName = userName;
        this.icon = icon.replaceAll("127.0.0.1",PicUrl.picUrl);
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getMainpostid() {
        return mainpostid;
    }

    public void setMainpostid(int mainpostid) {
        this.mainpostid = mainpostid;
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
                "postid=" + postid +
                ", mainpostid=" + mainpostid +
                ", userId=" + userId +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
