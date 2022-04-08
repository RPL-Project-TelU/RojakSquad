package tubes_kpl_rojaksquad;
import java.util.*;
import Referensi.*;
import java.util.Scanner;
public class Tubes_KPL_RojakSquad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        String Judul = scan.nextLine();
        String penulis = scan.nextLine();
        String topik = scan.nextLine();
        String publisher = scan.nextLine();
        
      


        enum topik{UiUx, MachineLearning, DataScience};
        String judul;
        String penulis;
        String topik;
        String jenis;
        String noJurnal;

        
        System.out.print("Masukkan judul:");
        judul = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        penulis = scan.nextLine();
        System.out.print("Masukkan topik: ");
        topik = scan.nextLine();
        System.out.print("Masukkan Jenis : ");
        jenis = scan.nextLine();
        System.out.print("Masukkan Nomor Jurnal: ")
        noJurnal = scan.nextLine();
        
        referensi buku = new referensi(judul,penulis,topik,jenis);
        referensi r1 = new Jurnal(judul, penulis, topik, jenis, noJurnal);
        
        r1.info();

        buku.uploadReferensi(1);
        buku.listReferensi();


    }
    
}
