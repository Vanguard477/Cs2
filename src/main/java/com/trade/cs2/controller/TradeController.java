package com.trade.cs2.controller;


import com.trade.cs2.models.Post;
import com.trade.cs2.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TradeController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/trade")
    public String trade(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "trade";
    }

    @GetMapping("/trade/add")
    public String tradeAdd(Model model) {
        return "trade-add";
    }

    @PostMapping("/trade/add")
    public String postTradeAdd(@RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        Post post = new Post(nameSkin, floatSkin, fullText);
        postRepository.save(post);
        return "redirect:/trade";
    }


    @GetMapping("/trade/{id}")
    public String tradeDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/trade";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "trade-details";
    }

    @GetMapping("/trade/{id}/edit")
    public String tradeEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/trade";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "trade-edit";
    }

    @PostMapping("/trade/{id}/edit")
    public String postTradeUpdate(@PathVariable(value = "id") long id, @RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setNameSkin(nameSkin);
        post.setFloatSkin(floatSkin);
        post.setFullText(fullText);
        postRepository.save(post);
        return "redirect:/trade";
    }

    @PostMapping("/trade/{id}/remove")
    public String postTradeRemove(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/trade";
    }


}
