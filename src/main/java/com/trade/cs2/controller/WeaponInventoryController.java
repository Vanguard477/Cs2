package com.trade.cs2.controller;

import com.trade.cs2.repo.WeaponInventoryRepository;
import com.trade.cs2.service.TradeService;
import com.trade.cs2.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class WeaponInventoryController {
    @Autowired
    private final WeaponService weaponService;
    @Autowired
    private WeaponInventoryRepository weaponInventoryRepository;

    @GetMapping("/profile/inventorySell")
    public String inventorySell(Model model) {
        model.addAttribute("inventory", weaponInventoryRepository.findAll());
        return "profileInventorySell";
    }

    @PostMapping("/profile/inventorySell/{id}/remove")
    public String weaponInventoryRemove(@PathVariable(value = "id") long id, Model model) {
        weaponService.getWeaponInventoryRemove(id);
        return "redirect:/profile/inventorySell";
    }

}
