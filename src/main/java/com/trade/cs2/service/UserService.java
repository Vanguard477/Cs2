package com.trade.cs2.service;


import com.trade.cs2.dto.CreateUserDto;
import com.trade.cs2.mapper.UserMapper;
import com.trade.cs2.models.User;
import com.trade.cs2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User findUserById(Long userId) {
        Optional<User> userFromBd = userRepository.findById(userId);
        return userFromBd.orElse(new User());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(CreateUserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return false;

        }
        userRepository.save(userMapper.toUser(userDto));
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

}

