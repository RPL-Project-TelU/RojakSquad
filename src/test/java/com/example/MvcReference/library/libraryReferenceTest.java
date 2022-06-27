package com.example.MvcReference.library;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MvcReference.library.libraryReference;
import com.example.MvcReference.entity.Buku;


@DataJpaTest
public class libraryReferenceTest {
    

    @Test
    void findBukuTest(){
        String expected = "SELECT b FROM test b WHERE b.test1 = ?1";
        libraryReference underTest = new libraryReference();
        String actual = underTest.findBuku("test", "test1");

        // Jika nilai expected dan actual sama
        assertEquals(expected, actual);     

        // Jika nilai expected dan actual tidak sama
        String actual2 = underTest.findBuku("test1", "test2");
        assertNotEquals(expected, actual2);
    }

    @Test
    void searchByValueTest(){
        String expected = "SELECT b FROM test b WHERE UPPER(b.test1) LIKE UPPER(CONCAT('%',:query,'%'))";
        libraryReference underTest = new libraryReference();
        String actual = underTest.searchByValue("test", "test1");

        // Jika nilai expected dan actual sama
        assertEquals(expected, actual);     

        // Jika nilai expected dan actual tidak sama
        String actual2 = underTest.searchByValue("test1", "test2");
        assertNotEquals(expected, actual2);
    }

    @Test
    void searchByValue2Test(){
        String expected = "SELECT b FROM test b WHERE UPPER(b.test1) LIKE UPPER(CONCAT('%',:query,'%'))";
        libraryReference underTest = new libraryReference();
        String actual = underTest.searchByValue2("test", "test1");

        // Jika nilai expected dan actual sama
        assertEquals(expected, actual);     

        // Jika nilai expected dan actual tidak sama
        String actual2 = underTest.searchByValue2("test1", "test2");
        assertNotEquals(expected, actual2);
    }

}
