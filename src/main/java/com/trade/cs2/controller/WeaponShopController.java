package com.trade.cs2.controller;

import com.trade.cs2.repo.WeaponRepository;
import com.trade.cs2.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class WeaponShopController {
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private final WeaponService weaponService;


    @GetMapping("/shop")
    public String inventoryShop(Model model) {
        model.addAttribute("inventoryShop", weaponRepository.findAll());
        return "shop";
    }

    @GetMapping("/shop/{id}")
    public String weaponShopDetails(@PathVariable(value = "id") long id, Model model) {
        if (!weaponRepository.existsById(id)) {
            return "redirect:/shop";
        }
        model.addAttribute("weaponDetails", weaponService.getWeaponShopDetailInfo(id));
        return "shopWeaponBuy";
    }

    @GetMapping("/shop/{id}/add")
    public String shopInventoryAdd(Model model) {
        return "/shop";
    }

    @PostMapping("/shop/{id}/add")
    public String weaponShopInventoryAdd(String name, String quality, String image) {
        weaponService.getWeaponInventoryAdd(name, quality, image);
        return "redirect:/shop";
    }

    @GetMapping("/shop/add")
    public String weaponAdd(Model model) {
        return "shopWeaponBuy";
    }


}
