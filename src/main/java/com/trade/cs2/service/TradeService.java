package com.trade.cs2.service;

import com.trade.cs2.models.Post;
import com.trade.cs2.repo.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TradeService {
    private final PostRepository postRepository;
    private Post post;

    public Post getTradeDetailInfo(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    public Post getPostTradeUpdate(Long id, @RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setNameSkin(nameSkin);
        post.setFloatSkin(floatSkin);
        post.setFullText(fullText);
        return postRepository.save(post);
    }

    public Post getPostTradeRemove(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return post;
    }

    public Post getPostTradeAdd(@RequestParam String nameSkin, @RequestParam String floatSkin, @RequestParam String fullText) {
        Post post = new Post(nameSkin, floatSkin, fullText);
        return postRepository.save(post);
    }

}
