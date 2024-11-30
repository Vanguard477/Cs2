package com.trade.cs2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "user_infos")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name, email, adres, phone;

    public UserInfo() {

    }

    public UserInfo(String name, String email, String adres, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adres = adres;
        this.phone = phone;
    }


}
