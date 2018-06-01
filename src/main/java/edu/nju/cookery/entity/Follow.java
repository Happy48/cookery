package edu.nju.cookery.entity;


import javax.persistence.*;

/**
 * 关注用户信息(关注id,用户id,关注用户id)
 */
@Entity
public class Follow {
    private int followID;
    private int userID;
    private int followedID;

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getFollowID() {
        return followID;
    }

    public void setFollowID(int followID) {
        this.followID = followID;
    }

    @Basic
    @Column(name="user_id")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name="followed_id")
    public int getFollowedID() {
        return followedID;
    }

    public void setFollowedID(int followedID) {
        this.followedID = followedID;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followID=" + followID +
                ", userID=" + userID +
                ", followedID=" + followedID +
                '}';
    }
}
