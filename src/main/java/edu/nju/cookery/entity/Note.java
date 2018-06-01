package edu.nju.cookery.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 笔记信息（笔记id，用户id，笔记名，笔记封面照片，笔记描述，原料，步骤，创建时间，贴士）
 */
@Entity
public class Note {
    private int noteID;
    private int userID;
    private String noteName;
    private String noteCover;
    private String description;
    private String material;
    private String practice;
    private Timestamp createdTime;
    private String tip;

    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @Column(name="note_name")
    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    @Basic
    @Column(name="note_cover")
    public String getNoteCover() {
        return noteCover;
    }

    public void setNoteCover(String noteCover) {
        this.noteCover = noteCover;
    }

    @Basic
    @Column(name="description",columnDefinition="text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name="material",columnDefinition="text")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name="practice",columnDefinition="text")
    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    @Basic
    @Column(name="created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
    @Basic
    @Column(name="tip")
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", userID=" + userID +
                ", noteName='" + noteName + '\'' +
                ", noteCover='" + noteCover + '\'' +
                ", description='" + description + '\'' +
                ", material='" + material + '\'' +
                ", practice='" + practice + '\'' +
                ", createdTime=" + createdTime +
                ", tip='" + tip + '\'' +
                '}';
    }
}
