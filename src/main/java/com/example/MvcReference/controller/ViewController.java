package com.example.MvcReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

@Controller
public class ViewController {

    private final BukuService bukuService;

    @Autowired
    public ViewController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping("/index")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "login from controller");
        return "login";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("listBuku", bukuService.getBuku());
        return "search";
    }

}
