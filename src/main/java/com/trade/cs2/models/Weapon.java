package com.trade.cs2.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String quality;
    private String image;


    public Weapon(String name, String quality, String image) {
        this.name = name;
        this.quality = quality;
        this.image = image;
    }

    public Weapon() {

    }
}
