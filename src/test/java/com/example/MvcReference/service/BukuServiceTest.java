package com.example.MvcReference.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;

@DataJpaTest
public class BukuServiceTest {
    
    @Autowired
    private BukuRepository underTest;

    @Test
    void testFindBuku() {
        Buku buku1 = new Buku("test", "dadang", "terbit");
        underTest.save(buku1);

        assertEquals(buku1, underTest.findBuku("test"));

    }
}
