package edu.nju.cookery.entity;

import javax.persistence.*;

/**
 * 子分类（子分类id，子分类名称）
 */
@Entity
public class Subtag {
    private int subtagID;
    private String subtagName;

    @Id
    @Column(name = "subtag_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getSubtagID() {
        return subtagID;
    }

    public void setSubtagID(int subtagID) {
        this.subtagID = subtagID;
    }

    @Basic
    @Column(name="subtag_name")
    public String getSubtagName() {
        return subtagName;
    }

    public void setSubtagName(String subtagName) {
        this.subtagName = subtagName;
    }

    @Override
    public String toString() {
        return "Subtag{" +
                "subtagID=" + subtagID +
                ", subtagName='" + subtagName + '\'' +
                '}';
    }
}
