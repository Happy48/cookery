package edu.nju.cookery.vo;


import java.sql.Date;

public class UserExceptIconVO {

    private int userID;
    private String userName;
    private String address;
    private boolean sex;
    private Date birthday;
    private String introduction;
    private String phoneNumber;
    private String userPwd;
    private String email;

    public UserExceptIconVO(int userID, String userName, String address, boolean sex, Date birthday,
                            String introduction,String phoneNumber,String userPwd,String email) {
        this.userID = userID;
        this.userName = userName;
        this.address=address;
        this.sex = sex;
        this.introduction=introduction;
        this.introduction = introduction;
        this.phoneNumber=phoneNumber;
        this.userPwd=userPwd;
        this.email=email;
        this.birthday=birthday;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
