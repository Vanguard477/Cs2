package com.trade.cs2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameSkin, floatSkin, full_text;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return nameSkin;
    }

    public void setTitle(String nameSkin) {
        this.nameSkin = nameSkin;
    }

    public String getAnons() {
        return floatSkin;
    }

    public void setAnons(String floatSkin) {
        this.floatSkin = floatSkin;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
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
        this.full_text = full_text;
    }
}
