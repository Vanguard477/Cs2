package com.trade.cs2.controller;

import com.trade.cs2.repo.WeaponRepository;
import com.trade.cs2.service.WeaponService;
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
    @Autowired
    private final WeaponService weaponService;


    @GetMapping("/shop")
    public String inventory(Model model, String name, String quality, String image) {
        weaponService.getWeaponInventory(name, quality, image);
        model.addAttribute("inventory", weaponRepository.findAll());
        return "shop";
    }
}
