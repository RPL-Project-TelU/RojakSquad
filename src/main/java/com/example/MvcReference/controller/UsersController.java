package com.example.MvcReference.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MvcReference.entity.Users;
import com.example.MvcReference.service.UserServiceImpl;
import com.example.MvcReference.util.DetectCharacters;

@Controller
public class UsersController {

    @Autowired
    private UserServiceImpl userService;
    
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
        }
        try{
            Users user = userService.findUser(username);
            redirAttrs.addFlashAttribute("user", user);
              
            if(user.getUsername().equalsIgnoreCase(username)&&user.getPassword().equalsIgnoreCase(password)){
                redirAttrs.addAttribute("username", username);
                return "redirect:/searchPage";
            }else{
                redirAttrs.addFlashAttribute("error", "Wrong Username or Password");
                return "redirect:/loginPage/"; 
            }
        }catch(Exception e){
            redirAttrs.addFlashAttribute("error", "Wrong Username or Password");
            return "redirect:/loginPage/"; 
            
        }
        
    }
}

