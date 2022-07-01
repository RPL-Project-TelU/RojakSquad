package com.example.MvcReference.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.entity.Users;
import com.example.MvcReference.service.BukuService;
import com.example.MvcReference.service.UserService;
import com.example.MvcReference.util.FileUploadUtil;
import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.dao.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ViewControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository testUser;

    @Autowired
    private BukuRepository testBuku;

    @Mock
    private BukuService  bukuSerTest;

    @Mock
    private UserService  UserSerTest;

    @InjectMocks
    private ViewController controller;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testLanding() throws Exception {
        this.mvc.perform(get("/")).andExpect(view().name("index"));
    }

    @Test
    void testLoginPage() throws Exception {
         this.mvc.perform(get("/loginPage")).andExpect(view().name("login"));
    }

    @Test
    void testShowBukuMhs() throws Exception {
        Users user = new Users("test", "test", "test", "test");
        testUser.save(user);

        List<Buku> buku = new ArrayList<Buku>();
        Buku buku1 = new Buku("test", "test", "test");
        buku.add(buku1);
        testBuku.saveAll(buku);

        when(bukuSerTest.getBuku()).thenReturn(buku);
        when(UserSerTest.findUser(user.getUsername())).thenReturn(user);

        this.mvc.perform(get("/searchPage").param("username", user.getUsername()))
        .andExpect(model().attribute("listBuku",status().isFound()))
        .andExpect(model().attribute("user", status().isFound()))
        .andExpect(view().name("search"));
    } 

    @Test
    void testAddNewBuku() {
        

    }

    @Test
    void testDeleteBuku() {

    }

    @Test
    void testSearch() {

    }

    @Test
    void testTest() {

    }
}