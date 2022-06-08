package com.example.MvcReference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

@RestController
@RequestMapping(path = "api/listbuku")
public class BukuController {

    private final BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    // @GetMapping
    // public List<Buku> getBuku() {
    // return bukuService.getBuku();
    // }
    @GetMapping("/search")
    public String search(@ModelAttribute Buku buku, Model model) {
        model.addAllAttributes(bukuService.getBuku());
        model.addAttribute("message", "test from controller");
        return "search";
    }

    @PostMapping
    public void addNewBuku(@RequestBody Buku buku) {
        bukuService.addNewBuku(buku);
    }

}
