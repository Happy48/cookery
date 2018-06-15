package edu.nju.cookery.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 用户信息（用户id，0女性1男性，生日，住址，联系电话，介绍）
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
    private int userID;
    private boolean sex;
    private Date birthday;
    private String address;
    private String phoneNumber;
    private String introduction;
    private String icon;

    @Id
    @Column(name = "user_id")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name="sex")
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name="birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Basic
    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Basic
    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name="introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name="icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userID=" + userID +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", introduction='" + introduction + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
