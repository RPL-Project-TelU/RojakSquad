package com.example.MvcReference.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void addNewBuku(HttpServletResponse response,
            @RequestParam(value = "judul", required = true) String judul,
            @RequestParam(value = "penulis", required = true) String penulis,
            @RequestParam(value = "penerbit", required = true) String penerbit) throws IOException {
        Buku buku = new Buku(judul, penulis, penerbit);
        bukuService.addNewBuku(buku);
        response.sendRedirect("/");
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
