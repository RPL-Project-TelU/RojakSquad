package com.example.MvcReference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

//Restcontroller untuk post method
@RestController
@RequestMapping(path = "/")
public class BukuController {

    private final BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @RequestMapping(path = "/add")
    @PostMapping
    public void addNewBuku(
            @RequestParam(value = "judul", required = true) String judul,
            @RequestParam(value = "penulis", required = true) String penulis,
            @RequestParam(value = "penerbit", required = true) String penerbit) {
        Buku buku = new Buku(judul, penulis, penerbit);
        bukuService.addNewBuku(buku);
    }

    // add buku
    // @RequestMapping(path = "/")
    // @PostMapping
    // public void addNewBuku(@RequestBody Buku buku) {
    // bukuService.addNewBuku(buku);
    // }

    // @PostMapping("/search")
    // public String searchBuku(@RequestParam("buku") String buku, Model model) {
    // model.addAttribute("buku", buku);
    // return "search";
    // }

    // search buku
    // @GetMapping("/search")
    // public ResponseEntity<List<Buku>> searchBuku(@RequestParam("query") String
    // query) {
    // return ResponseEntity.ok(bukuService.searchBuku(query));
    // }

}
