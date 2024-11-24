package com.trade.cs2.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String password;
    private String passwordConfirm;
}
