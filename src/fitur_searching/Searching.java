/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur_searching;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author powny
 */
public class Searching {
    private String hasil = "";
    public <T> List<String> cariBuku(T judul){ 
        // searching by string
        if(judul instanceof String){    
            // membuat array untuk mengecek huruf pada setiap data
            String[] splited = judul.toString().split("\\s");
            List<String> bukuSerupa = new ArrayList<String>();
            
            Gson gson = new Gson();
            try {
                Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"\\src\\fitur_searching\\buku.json"));
                bukuClass buku = gson.fromJson(reader,bukuClass.class);
                    
                for(int i=0; i<buku.getBuku().size();i++){
                   //memasukan buku serupa kedalam array
                   for(int j = 0; j<splited.length;j++){
                      if(buku.getBuku().get(i).getJudul().contains(splited[j])&&judul!= buku.getBuku().get(i).getJudul()){
                      bukuSerupa.add(buku.getBuku().get(i).getJudul());
                      break;  
                        }
                    }
                }
                return bukuSerupa;  
                }
            catch(Exception ex){
                        System.out.println(ex.toString());
            }
        // Searching By Rating
        }else if(judul instanceof Integer){
            List<Buku> bukuRating = new ArrayList<Buku>();
            List<String> bukuHasil = new ArrayList<String>();
            try{
                Gson gson = new Gson();
                Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"\\src\\fitur_searching\\buku.json"));
                bukuClass buku = gson.fromJson(reader,bukuClass.class);
                for (int i=0;i<buku.getBuku().size();i++){
                    if(buku.getBuku().get(i).getRating()>= ((Integer) judul).intValue()){
                        bukuRating.add(buku.getBuku().get(i));
                    }
                }
                return bukuHasil;
            }catch(Exception ex){
                System.out.println(ex.toString());
            }
        }
        return null;
        
        
    }
}
