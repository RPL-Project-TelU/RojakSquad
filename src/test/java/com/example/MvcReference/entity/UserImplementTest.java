package com.example.MvcReference.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserImplementTest {

    private UserImplement testUser;

    @Test
    void testLogin(){
        testUser =  new UserImplement("test","test","test","Author");

        assertEquals("Author", testUser.Login());


        assertNotEquals("Mahasiswa", testUser.Login());

    }

   
    
}
