package edu.nju.cookery.vo;

public class StepVO {

    private String desc;
    private String picUrl;

    public StepVO(String desc, String picUrl) {
        this.desc = desc;
        this.picUrl = picUrl;
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
                "desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
