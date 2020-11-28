package com.softy.softy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "about";
    }

    @GetMapping("/academic")
    public String academic(Model model) {
        model.addAttribute("title", "Academic");
        return "academic";
    }

    @GetMapping("/academic/scholarship")
    public String scholarship(Model model) {
        model.addAttribute("title", "Scholarship");
        return "scholarship";
    }

    @GetMapping("/jobs")
    public String jobs(Model model) {
        model.addAttribute("title", "Jobs");
        return "jobs";
    }
}
