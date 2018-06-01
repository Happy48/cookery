package edu.nju.cookery.entity;
import javax.persistence.*;

/**
 * 笔记作品信息（作品id，笔记id，用户id，照片，描述）
 */
@Entity
public class Work {
    private int workID;
    private int noteID;
    private int userID;
    private String picture;
    private String description;

    @Id
    @Column(name = "work_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getWorkID() {
        return workID;
    }

    public void setWorkID(int workID) {
        this.workID = workID;
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

    @Basic
    @Column(name="picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workID=" + workID +
                ", noteID=" + noteID +
                ", userID=" + userID +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

