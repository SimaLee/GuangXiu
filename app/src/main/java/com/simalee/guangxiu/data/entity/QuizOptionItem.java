package com.simalee.guangxiu.data.entity;

import java.io.Serializable;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizOptionItem implements Serializable{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuizOptionItem() {
    }

    public QuizOptionItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "QuizOptionItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * 选项id
     */
    int id;
    /**
     * 选项描述
     */
    String description;
}
