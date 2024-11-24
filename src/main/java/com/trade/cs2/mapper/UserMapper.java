package com.trade.cs2.mapper;

import com.trade.cs2.dto.CreateUserDto;
import com.trade.cs2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public User toUser(CreateUserDto dto) {
        return new User()
                .setUsername(dto.getUsername())
                .setPassword(passwordEncoder.encode(dto.getPassword()));

    }
}
