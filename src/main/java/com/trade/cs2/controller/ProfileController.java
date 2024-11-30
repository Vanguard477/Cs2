package com.trade.cs2.controller;

import com.trade.cs2.models.UserInfo;
import com.trade.cs2.repo.UserInfoRepository;
import com.trade.cs2.repo.WeaponInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequiredArgsConstructor
@Controller
public class ProfileController {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private WeaponInventoryRepository weaponInventoryRepository;

    @GetMapping("/profile")
    public String profiles(Model model) {
        model.addAttribute("userInfos", userInfoRepository.findAll());
        model.addAttribute("inventory", weaponInventoryRepository.findAll());
        return "profile";
    }

    @GetMapping("/profile/settings")
    public String userInfoProfileSettings(Model model) {
        return "profileSettings";
    }

    @PostMapping("/profile/settings")
    public String userInfoProfile(@RequestParam String name, @RequestParam String email, @RequestParam String adres, @RequestParam String phone) {
        UserInfo userInfo = new UserInfo(name, email, adres, phone);
        userInfoRepository.save(userInfo);
        return "redirect:/profile";
    }

}
