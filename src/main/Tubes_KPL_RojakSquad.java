package main;
import fitur_login.*;
import fitur_searching.*;
import fitur_referensi.*;
import java.io.IOException;
  
//PADA FOLDER SOURCE CODE ADA FOLDER "jar files" YANG BERISIKAN 4 FILE JAR SEBELUM MEMULAI PROGRAM,
//MASUKKAN DAHULU KEEMPAT FILE KEDALAM PROJECT LIBRARY DI BAGIAN KIRI KLIK KANAN "Libraries" DAN PILIH "Add Jar/Folder" DAN MASUKKAN 4 FILE TERSEBUT

public class Tubes_KPL_RojakSquad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
//        FiturLogin login = new FiturLogin();
//        login.login();
//        
//        System.out.println(" ");
//        
//        UploadReferensi upload = new UploadReferensi();
//        upload.upload();
//        
//        System.out.println(" ");
//
        Searching searching = new Searching();
        System.out.println(searching.cariBuku("Algoritma").get(0)[0]);
        System.out.println(searching.cariBuku("Algoritma").get(0)[1]);
        System.out.println(searching.cariBuku("Algoritma").get(0)[2]);

        //System.out.println(System.getProperty("user.dir"));
        

          
        
        
    }
}
