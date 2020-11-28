package com.softy.softy.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.softy.softy.Repository.PostRepository;
import com.softy.softy.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("title", "Blog");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "post";
    }
    @GetMapping("/post/add")
    public String postAdd(Model model) {
        model.addAttribute("title", "Add a post");
        return "post-add";
    }
    @PostMapping("/post/add")
    public String postAdding(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/post";
    }
    @GetMapping("/post/{id}")
    public String postDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/post";
        }
        Optional<Post> post = postRepository.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("title", "Details...");
        model.addAttribute("post", res);
        return "post-details";
    }
    @GetMapping("/post/{id}/edit")
    public String postEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/post";
        }
        Optional<Post> post = postRepository.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("title", "Editing...");
        model.addAttribute("post", res);
        return "post-edit";
    }
    @PostMapping("/post/{id}/edit")
    public String postEditting(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/post/{id}";
    }
    @PostMapping("/post/{id}/remove")
    public String postRemove(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/post";
    }
}
