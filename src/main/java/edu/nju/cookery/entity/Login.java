package edu.nju.cookery.entity;


import javax.persistence.*;

/**
 * 登录信息(用户id，用户名，密码，验证邮箱，验证码，验证码过期时间，0未激活1激活，注册时间)
 */
@Entity
public class Login {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String token;
    private int tokenExptime;
    private boolean activated;
    private int regTime;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name="token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name="token_exptime")
    public int getTokenExptime() {
        return tokenExptime;
    }

    public void setTokenExptime(int tokenExptime) {
        this.tokenExptime = tokenExptime;
    }

    @Basic
    @Column(name="activated")
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Basic
    @Column(name="reg_time")
    public int getRegTime() {
        return regTime;
    }

    public void setRegTime(int regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", tokenExptime=" + tokenExptime +
                ", activated=" + activated +
                ", regTime=" + regTime +
                '}';
    }
}
