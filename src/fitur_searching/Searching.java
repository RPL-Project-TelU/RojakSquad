/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur_searching;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
/**
 *
 * @author powny
 */
public class Searching {
    private String hasil = "";
    private String jsonString = "{\n" +
"    \"buku\" :[\n" +
"        {\n" +
"            \"judul\": \"Pengenalan Algoritma 1\",\n" +
"            \"rating\":5\n" +
"        },\n" +
"        {\n" +
"            \"judul\": \"Pengenalan Algoritma 2\",\n" +
"            \"rating\":4\n" +
"        },\n" +
"        {\n" +
"            \"judul\": \"Rekayasa Perangkat Lunak\",\n" +
"            \"rating\":5\n" +
"        },\n" +
"        {\n" +
"            \"judul\": \"Basis Data\",\n" +
"            \"rating\":3\n" +
"        },\n" +
"        {\n" +
"            \"judul\": \"Jurnal Arsitektur dan Organisasi Komputer\",\n" +
"            \"rating\":5\n" +
"        },\n" +
"        {\n" +
"            \"judul\": \"Rekayasa Industri\",\n" +
"            \"rating\":5\n" +
"        }\n" +
"    ]\n" +
"}";
        
    public <T> void cariBuku(T judul){ 
        // membuat array untuk mengecek huruf pada setiap data
        String[] splited = judul.split("\\s+");
        List<String> bukuSerupa = new ArrayList<String>();
        
        ObjectMapper mapper = new ObjectMapper();
        try{
            bukuClass buku = mapper.readValue(jsonString,bukuClass.class);
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
//            System.out.println("Buku yang dicari = "+this.hasil);
            System.out.println("Hasil Pencarian");
            for(int i = 0;i< bukuSerupa.size();i++){
                System.out.println(bukuSerupa.get(i));
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
    }
}
