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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author powny
 */
public class Searching {
    private String hasil = "";
        
    public <T> List<String> cariBuku(T judul){ 
        
        if(judul instanceof String){    
            // membuat array untuk mengecek huruf pada setiap data
            String[] splited = judul.toString().split("\\s");
            List<String> bukuSerupa = new ArrayList<String>();
            
            Gson gson = new Gson();
            try {
                Reader reader = Files.newBufferedReader(Paths.get("C:\\College\\Programming\\Konstruksi Perangkat Lunak\\Tugas Besar\\RojakSquad\\src\\fitur_searching\\buku.json"));
                bukuClass buku = gson.fromJson(reader,bukuClass.class);
                    try{
                        for(int i=0; i<buku.getBuku().size();i++){
                        //memasukan buku serupa kedalam array
                            for(int j = 0; j<splited.length;j++){
                                if(buku.getBuku().get(i).getJudul().contains(splited[j])&&judul!= buku.getBuku().get(i).getJudul()){
                                    bukuSerupa.add(buku.getBuku().get(i).getJudul());
                                    break;  
                        }
                    }
                }
                    // print buku ke layar
                    System.out.println("Hasil Pencarian");
                    for(int i = 0;i< bukuSerupa.size();i++){
                        System.out.println(bukuSerupa.get(i));
                    }
                    return bukuSerupa;
                }catch(Exception ex){
                    System.out.println(ex.toString());
                }
            } catch (IOException ex) {
                Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
        }else if(judul instanceof Integer){
            List<String> bukuRating = new ArrayList<String>();
            ObjectMapper mapper = new ObjectMapper();
            try{
                Gson gson = new Gson();
                Reader reader = Files.newBufferedReader(Paths.get("C:\\College\\Programming\\Konstruksi Perangkat Lunak\\Tugas Besar\\RojakSquad\\src\\fitur_searching\\buku.json"));
                bukuClass buku = gson.fromJson(reader,bukuClass.class);
                for (int i=0;i<buku.getBuku().size();i++){
                    if(buku.getBuku().get(i).getRating()>= Integer.valueOf(judul.toString())){
                        bukuRating.add(buku.getBuku().get(i).getJudul());
                    }
                }
                 System.out.println("Hasil Pencarian");
                for(int i = 0;i< bukuRating.size();i++){
                    System.out.println(bukuRating.get(i));
                }
                return bukuRating;
            }catch(Exception ex){
                System.out.println(ex.toString());
            }
        }
        return null;
        
        
    }
}
