package edu.nju.cookery.entity;


import javax.persistence.*;

/**
 * 笔记分类信息（笔记分类id，笔记id，子分类id）
 */
@Entity
public class Category {
    private int categoryID;
    private int noteID;
    private int subtagID;

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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
    @Column(name="subtag_id")
    public int getSubtagID() {
        return subtagID;
    }

    public void setSubtagID(int subtagID) {
        this.subtagID = subtagID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", noteID=" + noteID +
                ", subtagID=" + subtagID +
                '}';
    }
}
