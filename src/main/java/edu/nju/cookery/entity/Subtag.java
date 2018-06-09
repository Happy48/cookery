package edu.nju.cookery.entity;

import javax.persistence.*;

/**
 * 子分类（子分类id，子分类名称）
 */
@Entity
public class Subtag {
    private int id;
    private String name;

    @Id
    @Column(name = "subtag_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="subtag_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
