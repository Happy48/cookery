package edu.nju.cookery.vo;

import edu.nju.cookery.util.PicUrl;
import org.springframework.beans.factory.annotation.Value;

public class FollowVO {

    private String name;
    private String icon;


    public FollowVO(String name, String icon) {
        this.name = name;
        this.icon = icon.replaceAll("127.0.0.1",PicUrl.picUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
