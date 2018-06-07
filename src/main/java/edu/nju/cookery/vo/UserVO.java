package edu.nju.cookery.vo;

public class UserVO {

    private int userID;
    private String userName;
    private boolean sex;
    private String introduction;
    private String icon;

    public UserVO(int userID, String userName, boolean sex, String introduction, String icon) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.introduction = introduction;
        this.icon = icon;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
