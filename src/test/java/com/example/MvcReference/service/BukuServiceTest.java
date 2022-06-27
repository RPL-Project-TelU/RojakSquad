package com.example.MvcReference.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        //Test Positive (query dengan judul yang tepat)
        assertEquals(buku1, underTest.findBuku("test"));
        //Test Negative (query dengan judul yang salah)
        assertNotEquals(buku1, underTest.findBuku("testFalse"));

    }

    @Test
    void testSearchBuku() {
        List<Buku> buku = new ArrayList<Buku>();
        Buku buku1 = new Buku("test", "dadang", "terbit");
        buku.add(buku1);

        underTest.saveAll(buku);

        //Test Positive (query dengan judul buku yang ada dalam list)
        assertEquals(buku, underTest.searchBukuByJudul("test"));
        //Test Negative (query dengan judul buku yang tidak ada dalam list)
        assertNotEquals(buku, underTest.searchBukuByJudul("testFalse"));
    }

    @Test
    void testAddNewBuku() {
        boolean kondisi = true;

        Buku buku = new Buku("test", "test", "test");
        underTest.save(buku);
        Optional<Buku> bukuOptional = underTest.searchBukuByJudulOp(buku.getJudul());

        //Test Positive (buku di save/add, dan dicek apakah sudah dimasukkan repo)
        assertEquals(kondisi, bukuOptional.isPresent());

        Buku buku2 = new Buku("testFalse", "test", "test");
        Optional<Buku> bukuOptional2 = underTest.searchBukuByJudulOp(buku2.getJudul());
        
        //Test Negative (jika buku tidak di save)
        assertNotEquals(kondisi, bukuOptional2.isPresent());
        
    }

    @Test
    void testGetBuku() {
        List<Buku> listBuku = new ArrayList<Buku>();

        //Test Positive (default state dari list kosong)
        assertEquals(listBuku, underTest.findAll());
        
        listBuku.add(new Buku("test", "test", "test"));

        //Test Negative (state dari kedua list berbeda karena ada method dilakukan add)
        assertNotEquals(listBuku, underTest.findAll());

    

    @Test
    void testDeleteBukuByJudul(){
        boolean kondisi = false;

        Buku buku = new Buku("test", "test", "test");
        underTest.save(buku);

        underTest.delete(buku);
        Optional<Buku> bukuOptional = underTest.searchBukuByJudulOp(buku.getJudul());
        //Test Positive (buku di save/add, dan dicek apakah buku ada di dalam repo
        assertEquals(kondisi, bukuOptional.isPresent());

        Buku buku2 = new Buku("test", "test", "test");
        underTest.save(buku2);
        Optional<Buku> bukuOptional2 = underTest.searchBukuByJudulOp(buku2.getJudul());
        // Test jika buku tidak di delete
        assertNotEquals(kondisi, bukuOptional2.isPresent());
    }

}