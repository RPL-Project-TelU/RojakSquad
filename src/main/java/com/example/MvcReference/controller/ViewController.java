package com.example.MvcReference.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.entity.Users;
import com.example.MvcReference.service.BukuServiceImpl;
import com.example.MvcReference.service.UserServiceImpl;
import com.example.MvcReference.util.FileUploadUtil;

// controller
@Controller
@ControllerAdvice
public class ViewController {
    @Autowired
    private BukuServiceImpl bukuService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String landing(){
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/searchPage")
    public String showBukuMhs(Model model) {
        model.addAttribute("listBuku", bukuService.getBuku());
        return "search";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "judul", required = false) String judul,
                         @RequestParam(value = "username", required = true) String username, Model model) {
        model.addAttribute("judul", bukuService.searchBuku(judul));
        model.addAttribute("user",userService.findUser(username));
        return "search";
    }

    @RequestMapping(path="/buku")
    public String test(@RequestParam(value = "judul", required = false) String judul,
                      @RequestParam(value="username",required = true) String username, Model model) throws IOException {
        Buku buku = bukuService.findBuku(judul);
        Users user = userService.findUser(username);
        String fileLocation = buku.getPenulis()+"/"+buku.getJudul()+"/"+buku.getFile();
        model.addAttribute("buku", buku);
        model.addAttribute("location", fileLocation);
        model.addAttribute("user", user);
        return "buku";
    }

    @RequestMapping(path = "/add")
    public String addNewBuku(RedirectAttributes redirAttrs,
            @RequestParam(value = "judul", required = true) String judul,
            @RequestParam(value = "penulis", required = true) String penulis,
            @RequestParam(value = "penerbit", required = true) String penerbit,
            @RequestParam(value = "deskripsi", required = true)String deskripsi,
            @RequestParam(value = "tglTerbit", required = true)String tglTerbit,
            @RequestParam(value = "file", required = true) MultipartFile file,
            @RequestParam(value = "username",required = true) String username) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Buku buku = new Buku(judul, penulis, penerbit, deskripsi, tglTerbit, fileName);
        String uploadDir = "src/main/resources/static/pdf/"+ buku.getPenulis()+"/"+buku.getJudul();
        FileUploadUtil.saveFile(uploadDir, fileName, file);
        bukuService.addNewBuku(buku);
        redirAttrs.addFlashAttribute("user",userService.findUser(username));
        return "redirect:/searchPage/";  
        
    }

    @RequestMapping(path="/delete")
    public String deleteBuku(RedirectAttributes redirAttrs,
            @RequestParam(value = "buttonDelete",required = true)String judul,
            @RequestParam(value = "username", required = true)String username, Model model) throws IOException{
        bukuService.deleteBukuByJudul(judul);
        redirAttrs.addFlashAttribute("user",userService.findUser(username));
        return "redirect:/searchPage/"; 
    }
}
