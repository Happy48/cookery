package edu.nju.cookery.vo;

import java.sql.Timestamp;
import java.util.List;

public class NoteDetailVO {

    private String foodTitle;
    private String foodPic;
    private String foodDesc;
    private int foodLikes;
    private Timestamp foodCreateTime;
    private int foodCollect;
    private int noteId;

    private List<MaterialVO> materialVOList;
    private List<StepVO> stepVOList;
    private List<WorkVO> workVOList;
    private List<CommentVO> commentVOList;

    public NoteDetailVO(String foodTitle, String foodPic, String foodDesc, int foodLikes, Timestamp foodCreateTime, int foodCollect, int noteId, List<MaterialVO> materialVOList, List<StepVO> stepVOList, List<WorkVO> workVOList, List<CommentVO> commentVOList) {
        this.foodTitle = foodTitle;
        this.foodPic = foodPic;
        this.foodDesc = foodDesc;
        this.foodLikes = foodLikes;
        this.foodCreateTime = foodCreateTime;
        this.foodCollect = foodCollect;
        this.noteId = noteId;
        this.materialVOList = materialVOList;
        this.stepVOList = stepVOList;
        this.workVOList = workVOList;
        this.commentVOList = commentVOList;
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

    public List<MaterialVO> getMaterialVOList() {
        return materialVOList;
    }

    public void setMaterialVOList(List<MaterialVO> materialVOList) {
        this.materialVOList = materialVOList;
    }

    public List<StepVO> getStepVOList() {
        return stepVOList;
    }

    public void setStepVOList(List<StepVO> stepVOList) {
        this.stepVOList = stepVOList;
    }

    public List<WorkVO> getWorkVOList() {
        return workVOList;
    }

    public void setWorkVOList(List<WorkVO> workVOList) {
        this.workVOList = workVOList;
    }

    public List<CommentVO> getCommentVOList() {
        return commentVOList;
    }

    public void setCommentVOList(List<CommentVO> commentVOList) {
        this.commentVOList = commentVOList;
    }

    @Override
    public String toString() {
        return "NoteDetailVO{" +
                "foodTitle='" + foodTitle + '\'' +
                ", foodPic='" + foodPic + '\'' +
                ", foodDesc='" + foodDesc + '\'' +
                ", foodLikes=" + foodLikes +
                ", foodCreateTime=" + foodCreateTime +
                ", foodCollect=" + foodCollect +
                ", noteId=" + noteId +
                ", materialVOList=" + materialVOList +
                ", stepVOList=" + stepVOList +
                ", workVOList=" + workVOList +
                ", commentVOList=" + commentVOList +
                '}';
    }
}
