/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur_searching;
import fitur_referensi.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author powny
 */
public class searching_cadangan {
        
//    public <T> void cariBuku(T judul){ 
//        
//        if(judul instanceof String){    
//            // membuat array untuk mengecek huruf pada setiap data
//            String[] splited = judul.toString().split("\\s");
//            List<String> bukuSerupa = new ArrayList<String>();
//       
//            try{
//                for(int i=0; i<;i++){
//                    //memasukan buku serupa kedalam array
//                    for(int j = 0; j<splited.length;j++){
//                        if(buku.getBuku().get(i).getJudul().contains(splited[j])&&judul!= buku.getBuku().get(i).getJudul()){
//                            bukuSerupa.add(buku.getBuku().get(i).getJudul());
//                            break;  
//                        }
//                    }
//                }
//                // print buku ke layar
//                System.out.println("Hasil Pencarian");
//                for(int i = 0;i< bukuSerupa.size();i++){
//                    System.out.println(bukuSerupa.get(i));
//                }
//            }catch(Exception ex){
//                System.out.println(ex.toString());
//            }
//        }else if(judul instanceof Integer){
//            List<String> bukuRating = new ArrayList<String>();
//            ObjectMapper mapper = new ObjectMapper();
//            try{
//                bukuClass buku = mapper.readValue(jsonString,bukuClass.class);
//                for (int i=0;i<buku.getBuku().size();i++){
//                    if(buku.getBuku().get(i).getRating()>= Integer.valueOf(judul.toString())){
//                        bukuRating.add(buku.getBuku().get(i).getJudul());
//                    }
//                }
//                 System.out.println("Hasil Pencarian");
//                for(int i = 0;i< bukuRating.size();i++){
//                    System.out.println(bukuRating.get(i));
//                }
//            }catch(Exception ex){
//                System.out.println(ex.toString());
//            }
//        }
//        
//    }
}
