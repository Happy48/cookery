package edu.nju.cookery.vo;

import edu.nju.cookery.util.PicUrl;
import org.springframework.beans.factory.annotation.Value;

public class WorkVO {

    private int userId;
    private String picture;
    private String desc;
    private String userName;

    public WorkVO(int userId, String picture, String desc, String userName) {
        this.userId = userId;
        this.picture = picture.replaceAll("127.0.0.1",PicUrl.picUrl);
        this.desc = desc;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "WorkVO{" +
                "userId=" + userId +
                ", picture='" + picture + '\'' +
                ", desc='" + desc + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
