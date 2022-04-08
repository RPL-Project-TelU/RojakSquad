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

        
        System.out.print("Masukkan judul:");
        judul = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        penulis = scan.nextLine();
        System.out.print("Masukkan topik: ");
        topik = scan.nextLine();
        System.out.print("Masukkan Nomor Jurnal: ")

        
        referensi buku = new referensi(judul,penulis,topik);
        referensi r1 = new Jurnal(judul, penulis, topik, noJurnal);
        
        r1.info();

        buku.uploadReferensi(1);
        buku.listReferensi();

    }
    
}
