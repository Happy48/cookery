package edu.nju.cookery.entity;


import javax.persistence.*;

/**
 * 笔记收藏信息（收藏id，笔记id，用户id）
 */
@Entity
public class Collect {
    private int collectID;
    private int noteID;
    private int userID;

    @Id
    @Column(name = "collect_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getCollectID() {
        return collectID;
    }

    public void setCollectID(int collectID) {
        this.collectID = collectID;
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
        return "Collect{" +
                "collectID=" + collectID +
                ", noteID=" + noteID +
                ", userID=" + userID +
                '}';
    }
}
