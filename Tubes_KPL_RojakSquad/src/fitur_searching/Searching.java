/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur_searching;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author powny
 */
public class Searching {
    String data[] = {"Pengenalan Algoritma 1","Pembelajaran Algoritma 2", "Rekayasa Perangkat Lunak",
    "Basis Data","Jurnal Arsitektur dan Organisasi Komputer","Jaringan Komputer"};
    
    private String hasil = "";
        
    public void cariBuku(String judul){ 
        
        String[] splited = judul.split("\\s+");
        List<String> bukuSerupa = new ArrayList<String>();
        
        for(int i=0; i<data.length;i++){
            for(int j = 0; j<splited.length;j++){
                if(data[i].contains(splited[j])&&judul!= data[i]){
                    bukuSerupa.add(data[i]);
                    break;
                }
            }
        }
        
        for(int i=0;i<data.length;i++){
            if(judul == data[i]){
                this.hasil = data[i];   
            }
        }
       
        System.out.println("Buku yang dicari = "+this.hasil);
        System.out.println("Buku yang mungkin serupa = ");
        for(int i = 0;i< bukuSerupa.size();i++){
            System.out.println(bukuSerupa.get(i));
        }
        
    }
}
