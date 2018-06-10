package edu.nju.cookery.vo;

public class StepVO {

    private int id;
    private String desc;
    private String picUrl;

    public StepVO(int id, String desc, String picUrl) {
        this.id = id;
        this.desc = desc;
        this.picUrl = picUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "StepVO{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
