package com.example.MvcReference.controller;
import java.io.IOException;

import com.example.MvcReference.entity.Users;
import com.example.MvcReference.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Users;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private UserRepository testUser;

    @Mock
    @Autowired
    private UserService userSerTest;

    @InjectMocks
    private UsersController userCTest;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userCTest).build();
    }

    @Test
    void loginTest()throws Exception{
        Users user = new Users("test", "test", "test", "test");
        testUser.save(user);
        try{
            Users findU = userSerTest.findUser(user.getUsername());

            this.mockMvc.perform(get("/login").param("username", user.getUsername()).param("password", user.getPassword()))
            .andExpect(flash().attribute("user", findU))
            .andExpect(redirectedUrl("/searchPage"));
        } catch (Exception e){
            this.mockMvc.perform(get("/login").param("username", "test1", "test2"))
            .andExpect(flash().attribute("error", "Wrong Username or Password"))
            .andExpect(redirectedUrl("/loginPage/"));
        }
        
        // Jika terdapat special char
        this.mockMvc.perform(get("/login").param("username", "test!").param("password", "test!"))
        .andExpect(flash().attribute("error", "Username or Password must not contains special characters."))
        .andExpect(redirectedUrl("/loginPage/"));

        

    }
}
