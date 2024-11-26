package com.trade.cs2.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String quality;
    private String image;

    public Weapon() {

    }

    public Weapon(String name, String quality, String image) {
        this.name = name;
        this.quality = quality;
        this.image = image;
    }

}
