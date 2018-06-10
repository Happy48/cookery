package edu.nju.cookery.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

public class NewNoteVO {

    private int userID;
    private String noteName;
    private String noteCover;
    private String description;
    private String material;
    private String practice;
    private Timestamp createdTime;
    private String tip;
    private ArrayList<String> subTagList;

    public NewNoteVO(int userID,String noteName,String noteCover,String description,String material,String practice,
                     Timestamp createdTime,String tip,ArrayList<String>subTagList){
        this.userID=userID;
        this.noteName=noteName;
        this.noteCover=noteCover;
        this.description=description;
        this.material=material;
        this.practice=practice;
        this.createdTime=createdTime;
        this.tip=tip;
        this.subTagList=subTagList;
    }

    public ArrayList<String> getSubTagList() {
        return subTagList;
    }

    public void setSubTagList(ArrayList<String> subTagList) {
        this.subTagList = subTagList;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteCover() {
        return noteCover;
    }

    public void setNoteCover(String noteCover) {
        this.noteCover = noteCover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
