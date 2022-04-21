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
//    int metode;
//    String inputStr;
//    int inputInt;
    
//    public Searching(){
//        Scanner myObj = new Scanner(System.in);
//        System.out.print("Pilih metode pencarian: " + "\n1. Judul buku/jurnal" + "\n2. Rating buku/jurnal" + "\nMetode: ");
//        metode = myObj.nextInt();
//        if(metode == 1){
//            System.out.print("Masukkan judul buku/jurnal: ");
//            inputStr = myObj.next();
//            cariBuku(inputStr);
//        }
//        else if(metode == 2){
//            System.out.print("Masukkan rating buku/jurnal: ");
//            inputInt = myObj.nextInt();
//            cariBuku(inputInt);
//        }
//        
//    } 
    public <T> List<String> cariBuku(T judul){ 
        
        if(judul instanceof String){    
            // membuat array untuk mengecek huruf pada setiap data
            String[] splited = judul.toString().split("\\s");
            List<String> bukuSerupa = new ArrayList<String>();
            
            Gson gson = new Gson();
            try {
                //DIRECTORY FILE JSON SILAHKAN DIUBAH SESUAI DENGAN DIRECTORY MASING-MASING
                Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+"\\src\\fitur_searching\\buku.json"));                //DIRECTORY FILE JSON SILAHKAN DIUBAH SESUAI DENGAN DIRECTORY MASING-MASING
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
                // print buku ke layar
                System.out.println("\nHasil Pencarian");
                for(int i = 0;i< bukuSerupa.size();i++){
                    System.out.println(bukuSerupa.get(i));
                }
                return bukuSerupa;  
                }
            catch(Exception ex){
                        System.out.println(ex.toString());
            }

            
            
        }else if(judul instanceof Integer){
            List<Buku> bukuRating = new ArrayList<Buku>();
            List<String> bukuHasil = new ArrayList<String>();
            try{
                Gson gson = new Gson();
                //DIRECTORY FILE JSON SILAHKAN DIUBAH SESUAI DENGAN DIRECTORY MASING-MASING
                Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Zacharia Bachtiar\\Desktop\\BangJek\\Coding\\Java\\Tubes KPL\\RojakSquad\\src\\fitur_searching\\buku.json"));
                bukuClass buku = gson.fromJson(reader,bukuClass.class);
                for (int i=0;i<buku.getBuku().size();i++){
                    if(buku.getBuku().get(i).getRating()>= ((Integer) judul).intValue()){
                        bukuRating.add(buku.getBuku().get(i));
                    }
                }
                 System.out.println("\nHasil Pencarian");
                for(int i = 0;i< bukuRating.size();i++){
                    System.out.println(bukuRating.get(i).getJudul() + " dengan rating " + bukuRating.get(i).getRating());
                    bukuHasil.add(bukuRating.get(i).getJudul());
                }
                return bukuHasil;
            }catch(Exception ex){
                System.out.println(ex.toString());
            }
        }
        return null;
        
        
    }
}
