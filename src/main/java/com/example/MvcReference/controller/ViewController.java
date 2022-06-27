package com.example.MvcReference.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuServiceImpl;
import com.example.MvcReference.util.DetectCharacters;
import com.example.MvcReference.util.FileUploadUtil;

// controller
@Controller
public class ViewController {
    @Autowired
    private BukuServiceImpl bukuService;

    @GetMapping("/login")
    public String login(RedirectAttributes redirAttrs,
                        @RequestParam(value = "username",required = true)String username,
                        @RequestParam(value = "password", required = true)String password) throws IOException {
        DetectCharacters check = new DetectCharacters();
        boolean checkUsername = check.isSpecialCharacters(username);                  
        boolean checkPassword = check.isSpecialCharacters(password);
        if(checkUsername == true || checkPassword == true){  
            redirAttrs.addFlashAttribute("error", "Username or Password must not contains special characters.");
            return "redirect:/loginPage/";   
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/landing")
    public String landing(){
        return "landing";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
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

    @RequestMapping(path="/buku", method = RequestMethod.GET)
    public String test(@RequestParam(value = "judul", required = false) String judul, Model model) throws IOException {
        Buku buku = bukuService.findBuku(judul);
       
        String fileLocation = buku.getPenulis()+"/"+buku.getJudul()+"/"+buku.getFile();
        model.addAttribute("buku", buku);
        model.addAttribute("location", fileLocation);
        System.out.println(bukuService.findBuku(judul).getClass()); 
        return "buku";
    }

    @RequestMapping(path = "/add")
    public void addNewBuku(HttpServletResponse response,
            @RequestParam(value = "judul", required = true) String judul,
            @RequestParam(value = "penulis", required = true) String penulis,
            @RequestParam(value = "penerbit", required = true) String penerbit,
            @RequestParam(value = "deskripsi", required = true)String deskripsi,
            @RequestParam(value = "tglTerbit", required = true)String tglTerbit,
            @RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Buku buku = new Buku(judul, penulis, penerbit, deskripsi, tglTerbit, fileName);
        String uploadDir = "src/main/resources/static/pdf/"+ buku.getPenulis()+"/"+buku.getJudul();
        FileUploadUtil.saveFile(uploadDir, fileName, file);
        bukuService.addNewBuku(buku);
        response.sendRedirect("/");
        
    }

    @RequestMapping(path="/delete")
    public void deleteBuku(HttpServletResponse response,
            @RequestParam(value = "buttonDelete",required = true)String judul) throws IOException{
        bukuService.deleteBukuByJudul(judul);
        response.sendRedirect("/");
    }
}
