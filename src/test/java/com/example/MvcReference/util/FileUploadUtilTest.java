package com.example.MvcReference.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import com.example.MvcReference.entity.Buku;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileUploadUtilTest {
    
    @Test
    void testSaveFile() throws Exception {
        
        boolean kondisi = true;
        
        String fileName = "sampleFile.txt";
        Buku buku = new Buku("test","test","test","test","test",fileName);
        String uploadDir = "src/main/resources/static/pdf/"+ buku.getPenulis()+"/"+buku.getJudul();
        

        MockMultipartFile sampleFile = new MockMultipartFile(
            "uploaded-file",
            fileName,
            "text/plain",
            "This is the file content".getBytes()
        );

        try{
            FileUploadUtil.saveFile(uploadDir, fileName, sampleFile);
        }catch(Exception e){
            e.getMessage();
        }
        

        Path uploadPath = Paths.get(uploadDir);
        assertEquals(kondisi, Files.exists(uploadPath));



        

        

        
        


    }



}
