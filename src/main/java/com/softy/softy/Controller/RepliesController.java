package com.softy.softy.Controller;

import com.softy.softy.Repository.RepliesRepositoy;
import com.softy.softy.model.Replies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RepliesController {
    
    @Autowired
    private RepliesRepositoy repliesRepository;

    @GetMapping("/post/replies")
    public String replies(Model model) {
        model.addAttribute("title", "Blog");
        Iterable<Replies> replies = repliesRepository.findAll();
        model.addAttribute("replies", replies);
        return "replies";
    }
}
