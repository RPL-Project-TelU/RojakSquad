package tubes_kpl_rojaksquad;
import java.io.BufferedOutputStream;
import java.util.*;
import Referensi.*;
import java.util.Scanner;
public class Tubes_KPL_RojakSquad {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        
   
        enum topik{UiUx, MachineLearning, DataScience};
        String judul;
        String penulis;
        String topik;
        String jenis;
        int noJurnal;
   
        System.out.print("Masukkan judul:");
        judul = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        penulis = scan.nextLine();
        System.out.print("Masukkan topik: ");
        topik = scan.nextLine();
        System.out.print("Masukkan Jenis : ");
        jenis = scan.nextLine();
        System.out.print("Masukkan Nomor Jurnal: ");
        noJurnal = scan.nextInt();

        
        try{
            referensi buku = new Buku(judul,penulis,topik,jenis,"Gramedia");
            referensi r1 = new Jurnal(judul, penulis, topik, jenis, noJurnal);
            
            buku.uploadReferensi("Buku");
            r1.uploadReferensi("Jurnal");
            buku.info();
            r1.info();

        }catch (IllegalArgumentException e){
            System.out.println("Data tidak valid, " + e.getMessage());
        }


        
        
      


    }
    
}
