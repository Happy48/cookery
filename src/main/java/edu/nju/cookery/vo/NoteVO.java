package edu.nju.cookery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.nju.cookery.util.PicUrl;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;

public class NoteVO {

    private String foodTitle;
    private String foodPic;
    private String foodDesc;
    private int foodLikes;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp foodCreateTime;
    private int foodCollect;
    private int noteId;


    public NoteVO(String foodTitle, String foodPic, String foodDesc, int foodLikes, Timestamp foodCreateTime, int foodCollect, int noteId) {
        this.foodTitle = foodTitle;
        this.foodPic = foodPic.replaceAll("127.0.0.1",PicUrl.picUrl);
        this.foodDesc = foodDesc;
        this.foodLikes = foodLikes;
        this.foodCreateTime = foodCreateTime;
        this.foodCollect = foodCollect;
        this.noteId = noteId;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public int getFoodLikes() {
        return foodLikes;
    }

    public void setFoodLikes(int foodLikes) {
        this.foodLikes = foodLikes;
    }

    public Timestamp getFoodCreateTime() {
        return foodCreateTime;
    }

    public void setFoodCreateTime(Timestamp foodCreateTime) {
        this.foodCreateTime = foodCreateTime;
    }

    public int getFoodCollect() {
        return foodCollect;
    }

    public void setFoodCollect(int foodCollect) {
        this.foodCollect = foodCollect;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

}


