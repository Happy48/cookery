package edu.nju.cookery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.nju.cookery.util.PicUrl;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;

public class UserVO {

    private int userID;
    private String userName;
    private boolean sex;
    private String introduction;
    private String icon;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String email;
    private String phoneNum;
    private String address;


    public UserVO(int userID, String userName, boolean sex, String introduction, String icon, String password, Date birthday, String email, String phoneNum, String address) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.introduction = introduction;
        this.icon = icon.replaceAll("127.0.0.1",PicUrl.picUrl);
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", introduction='" + introduction + '\'' +
                ", icon='" + icon + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
