package com.trade.cs2.controller;

import com.trade.cs2.repo.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class WeaponInventController {
    @Autowired
    private WeaponRepository weaponRepository;


    @GetMapping("/shop")
    public String inventory(Model model) {
        model.addAttribute("inventory", weaponRepository.findAll());
        return "shop";
    }
}
