package com.trade.cs2.controller;


import com.trade.cs2.repo.PostRepository;
import com.trade.cs2.repo.WeaponInventoryRepository;
import com.trade.cs2.repo.WeaponRepository;
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
public class TradeController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private final TradeService tradeService;
    @Autowired
    private final WeaponService weaponService;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private WeaponInventoryRepository weaponInventoryRepository;

    @GetMapping("/trade")
    public String trade(Model model) {
        model.addAttribute("trade", weaponInventoryRepository.findAll());
        return "trade";
    }

    @GetMapping("/trade/add")
    public String tradeAdd(Model model) {
        return "trade-add";
    }

    @PostMapping("/trade/add")
    public String postTradeAdd(String name, String quality, String image) {
        weaponService.getWeaponInventoryAdd(name, quality, image);
        return "redirect:/trade";
    }

    @GetMapping("/trade/{id}/edit")
    public String tradeEdit(@PathVariable(value = "id") long id, Model model) {
        if (!weaponInventoryRepository.existsById(id)) {
            return "redirect:/trade";
        }
        model.addAttribute("tradeEdit", weaponService.getWeaponDetailInfo(id));
        model.addAttribute("inventoryTradeShop", weaponRepository.findAll());
        return "trade-edit";
    }

    @PostMapping("/trade/{id}/edit")
    public String postTradeUpdate(@PathVariable(value = "id") long id, String name, String quality, String image) {
        weaponService.getWeaponTradeUpdate(id, name, quality, image);
        return "redirect:/trade";
    }

    @PostMapping("/trade/{id}/remove")
    public String postTradeRemove(@PathVariable(value = "id") long id, Model model) {
        weaponService.getWeaponInventoryRemove(id);
        return "redirect:/trade";
    }

}
