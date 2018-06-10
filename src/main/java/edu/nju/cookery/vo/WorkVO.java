package edu.nju.cookery.vo;

public class WorkVO {

    private int userId;
    private String picture;
    private String desc;

    public WorkVO(int userId, String picture, String desc) {
        this.userId = userId;
        this.picture = picture;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "WorkVO{" +
                "userId=" + userId +
                ", picture='" + picture + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
