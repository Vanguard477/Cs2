package com.trade.cs2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSkin, floatSkin, fullText;
    private int views;

    public Post() {
    }

    public Post(String floatSkin, String nameSkin, String fullText) {
        this.floatSkin = floatSkin;
        this.nameSkin = nameSkin;
        this.fullText = fullText;
    }
}
