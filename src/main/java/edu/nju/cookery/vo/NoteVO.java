package edu.nju.cookery.vo;

import java.sql.Timestamp;

public class NoteVO {

    private String foodTitle;
    private String foodPic;
    private String foodDesc;
    private int foodLikes;
    private Timestamp foodCreateTime;
    private String foodShare;
    private String foodUrl;

    public NoteVO(String foodTitle, String foodPic, String foodDesc, int foodLikes, Timestamp foodCreateTime, String foodShare, String foodUrl) {
        this.foodTitle = foodTitle;
        this.foodPic = foodPic;
        this.foodDesc = foodDesc;
        this.foodLikes = foodLikes;
        this.foodCreateTime = foodCreateTime;
        this.foodShare = foodShare;
        this.foodUrl = foodUrl;
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

    public String getFoodShare() {
        return foodShare;
    }

    public void setFoodShare(String foodShare) {
        this.foodShare = foodShare;
    }

    public String getFoodUrl() {
        return foodUrl;
    }

    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }
}


