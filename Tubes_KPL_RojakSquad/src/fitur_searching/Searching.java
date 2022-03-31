/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur_searching;

/**
 *
 * @author powny
 */
public class Searching {
    String data[] = {"Buku Algoritma 1","Buku Algoritma 2", "Buku Rekayasa Perangkat Lunak",
    "Buku Basis Data"};
        
    public String cariBuku(String judul){   
       for(int i=0;i<data.length;i++){
            if(judul == data[i]){
                return "Buku Ditemukan : "+ data[i];
            }
        }
        return "";
    }
}
