package com.example.MvcReference.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

@Controller
// controller untuk get method
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

    @GetMapping("/")
    public String showBuku(Model model) {
        model.addAttribute("listBuku", bukuService.getBuku());
        return "search";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "judul", required = false) String judul, Model model) {
        model.addAttribute("judul", bukuService.searchBuku(judul));
        return "search";
    }

    @RequestMapping(path = "/add")
    public void addNewBuku(HttpServletResponse response,
            @RequestParam(value = "judul", required = true) String judul,
            @RequestParam(value = "penulis", required = true) String penulis,
            @RequestParam(value = "penerbit", required = true) String penerbit) throws IOException {
        Buku buku = new Buku(judul, penulis, penerbit);
        bukuService.addNewBuku(buku);
        response.sendRedirect("/");
    }

}
