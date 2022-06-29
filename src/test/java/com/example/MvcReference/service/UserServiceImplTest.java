package com.example.MvcReference.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Users;

@DataJpaTest
public class UserServiceImplTest {

    @Autowired
    private UserRepository testUser;


    @Test
    void testFindUser() {
        
        //List<Users> listUser = new ArrayList<Users>();
        Users user = new Users("test","test","test","Mahasiswa");
        //listUser.add(user);
        testUser.save(user);

        assertEquals(user, testUser.findUser("test"));
        
        assertNotEquals(user, testUser.findUser("testFalse"));
        
    }
}
