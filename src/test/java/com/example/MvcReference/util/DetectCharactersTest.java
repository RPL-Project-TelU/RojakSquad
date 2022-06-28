package com.example.MvcReference.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


public class DetectCharactersTest {

    private DetectCharacters tCharacters;

    @Test
    void testIsSpecialCharacters() {
        tCharacters = new DetectCharacters();
        boolean kondisi = true;
        String isi = null;
        assertEquals(kondisi, tCharacters.isSpecialCharacters(isi));

        isi = "%SPECIAL CHAR%";
        assertEquals(kondisi, tCharacters.isSpecialCharacters(isi));

        isi = "NO SPECIAL CHAR";
        assertNotEquals(kondisi, tCharacters.isSpecialCharacters(isi));


    }
}
