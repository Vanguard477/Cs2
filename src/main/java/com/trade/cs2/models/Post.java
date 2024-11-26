package com.trade.cs2.models;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameSkin, floatSkin, fullText;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSkin() {
        return nameSkin;
    }

    public void setNameSkin(String nameSkin) {
        this.nameSkin = nameSkin;
    }

    public String getFloatSkin() {
        return floatSkin;
    }

    public void setFloatSkin(String floatSkin) {
        this.floatSkin = floatSkin;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String full_text) {
        this.fullText = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Post() {
    }

    public Post(String floatSkin, String nameSkin, String full_text) {
        this.floatSkin = floatSkin;
        this.nameSkin = nameSkin;
        this.fullText = full_text;
    }
}
