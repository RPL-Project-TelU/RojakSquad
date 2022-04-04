
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

        
        System.out.println("Masukan judul:");
        judul = scan.nextLine();
        System.out.println("Masukan penulis:");
        penulis = scan.nextLine();
        System.out.println("Masukan topik:");
        topik = scan.nextLine();

        
        referensi buku = new referensi(judul,penulis,topik);
        
        buku.uploadReferensi(1);
        buku.listReferensi();
        
        
      
        
      


    }
    
}
