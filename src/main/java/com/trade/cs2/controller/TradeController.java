package com.trade.cs2.controller;


import com.trade.cs2.models.Post;
import com.trade.cs2.repo.PostRepository;
import com.trade.cs2.service.TradeService;
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


    @GetMapping("/trade")
    public String trade(Model model) {
        model.addAttribute("post", postRepository.findAll());
        return "trade";
    }

    @GetMapping("/trade/add")
    public String tradeAdd(Model model) {
        return "trade-add";
    }

    @PostMapping("/trade/add")
    public String postTradeAdd(@RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        tradeService.getPostTradeAdd(nameSkin, floatSkin, fullText);
        return "redirect:/trade";
    }


    @GetMapping("/trade/{id}")
    public String tradeDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/trade";
        }
        model.addAttribute("post", tradeService.getTradeDetailInfo(id));
        return "trade-details";
    }




    @GetMapping("/trade/{id}/edit")
    public String tradeEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/trade";
        }
        model.addAttribute("post", tradeService.getTradeDetailInfo(id));
        return "trade-edit";
    }

    @PostMapping("/trade/{id}/edit")
    public String postTradeUpdate(@PathVariable(value = "id") long id, @RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        tradeService.getPostTradeUpdate(id, nameSkin, floatSkin, fullText);
        return "redirect:/trade";
    }

    @PostMapping("/trade/{id}/remove")
    public String postTradeRemove(@PathVariable(value = "id") long id, Model model) {
        tradeService.getPostTradeRemove(id);
        return "redirect:/trade";
    }

}
