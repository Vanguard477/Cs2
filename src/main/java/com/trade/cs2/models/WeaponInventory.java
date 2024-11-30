package com.trade.cs2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "weapons_inventory")
public class WeaponInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String quality;
    private String image;


    public WeaponInventory(String name, String quality, String image) {
        this.name = name;
        this.quality = quality;
        this.image = image;
    }

    public WeaponInventory() {

    }
}