package com.simalee.guangxiu.data.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizItem implements Serializable,Comparable<QuizItem>{

    /**
     * 问题id
     */
    String id;
    /**
     * 问题序号
     */
    int sequence;
    /**
     * 问题描述
     */
    String question;
    /**
     * 问题相关的图片
     */
    String image;
    /**
     * 问题选项
     */
    List<QuizOptionItem> options;
    /**
     * 问题答案id
     */
    int answerId;
    /**
     * 答案解析
     */
    String explanation;

    public QuizItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<QuizOptionItem> getOptions() {
        return options;
    }

    public void setOptions(List<QuizOptionItem> options) {
        this.options = options;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "id='" + id + '\'' +
                ", sequence=" + sequence +
                ", question='" + question + '\'' +
                ", image='" + image + '\'' +
                ", options=" + options +
                ", answerId=" + answerId +
                ", explanation='" + explanation + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull QuizItem o) {

        if (o == null || !(o instanceof QuizItem)){
            return -1;
        }
        return this.sequence - o.getSequence();
    }
}
