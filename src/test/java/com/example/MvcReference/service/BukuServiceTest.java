package com.example.MvcReference.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

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
        Buku buku2 = new Buku("testing", "dadang", "terbit");
        underTest.save(buku1);
        underTest.save(buku2);

        assertEquals(buku1, underTest.findBuku("test"));
        assertNotEquals(buku2, underTest.findBuku("test"));

    }

    @Test
    void testSearchBuku() {
        List<Buku> buku = new ArrayList<Buku>();
        Buku buku1 = new Buku("test", "dadang", "terbit");
        Buku buku2 = new Buku("testing", "dadang", "terbit");
        buku.add(buku1);
        buku.add(buku2);

        underTest.saveAll(buku);

        assertEquals(buku, underTest.searchBukuByJudul("test"));
    }



}
