package tubes_kpl_rojaksquad;
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
            referensi buku = new referensi(judul,penulis,topik,jenis);
            referensi r1 = new Jurnal(judul, penulis, topik, jenis, noJurnal);
           
        }catch (IllegalArgumentException e){
            System.out.println("Data tidak valid, " + e.getMessage());
        }
        
        // buku.uploadReferensi(1);
        // buku.listReferensi();


    }
    
}
