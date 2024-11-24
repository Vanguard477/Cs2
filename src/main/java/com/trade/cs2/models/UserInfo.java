package com.trade.cs2.models;

import jakarta.persistence.*;


@Entity
@Table(name = "user_Info")
public class UserInfo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
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



    public Long getId() {
        return id;
    }

   public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
