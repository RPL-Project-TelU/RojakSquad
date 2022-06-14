package com.example.MvcReference.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

//Restcontroller
@RestController
@RequestMapping(path = "/")
public class BukuController {

    private final BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }
    //add buku
    @RequestMapping(path = "/")
    @PostMapping
    public void addNewBuku(@RequestBody Buku buku) {
    bukuService.addNewBuku(buku);
    }

}
