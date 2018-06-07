package edu.nju.cookery.entity;


import javax.persistence.*;

/**
 * 笔记喜欢信息（喜欢id，笔记id，用户id）
 */
@Entity
@Table(name="love")
public class Like {
    private int likeID;
    private int noteID;
    private int userID;

    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getLikeID() {
        return likeID;
    }

    public void setLikeID(int likeID) {
        this.likeID = likeID;
    }

    @Basic
    @Column(name="note_id")
    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    @Basic
    @Column(name="user_id")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeID=" + likeID +
                ", noteID=" + noteID +
                ", userID=" + userID +
                '}';
    }
}
