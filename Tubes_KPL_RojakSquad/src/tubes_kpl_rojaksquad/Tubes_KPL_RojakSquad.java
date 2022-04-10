package tubes_kpl_rojaksquad;
import java.io.BufferedOutputStream;
import java.util.*;
import Referensi.*;
import java.util.Scanner;
public class Tubes_KPL_RojakSquad {

    enum State{Upload, Buku, Jurnal, Exit};
    public static void main(String[] args) {
        String judul;
        String penulis;
        String topik;
        String jenis;
        int noJurnal;
        int pilihan1;
        State state = State.Upload;
        Scanner scan = new Scanner(System.in);
   
        String screenName[] = {"Upload", "Buku", "Jurnal", "Exit"};
        
        while(state != State.Exit){
            System.out.println("Pilih referensi yang ingin di-upload : \n1. Buku\n2. Jurnal\n3. Exit Program");
            System.out.print("Masukkan pilihan: ");
            pilihan1 = scan.nextInt();
            scan.nextLine();
          
            switch(pilihan1){
                case 1:
                    state = State.Buku;
                    System.out.println("Silahkan input data untuk "+screenName[pilihan1]+":");
                    System.out.print("Masukkan judul:");
                    judul = scan.nextLine();
                    System.out.print("Masukkan penulis: ");
                    penulis = scan.nextLine();
                    System.out.print("Masukkan topik: ");
                    topik = scan.nextLine();
                    System.out.print("Masukkan Jenis : ");
                    jenis = scan.nextLine();
                    try{
                        referensi buku = new Buku(judul,penulis,topik,jenis,"Gramedia");
                        buku.uploadReferensi("Buku");
                        buku.info();
                    }catch (IllegalArgumentException e){
                        System.out.println("Data tidak valid, " + e.getMessage());
                    }
                    break;
                         
                case 2:
                    state = State.Jurnal;
                    System.out.println("Silahkan input data untuk "+screenName[pilihan1]+":");
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
                        referensi jurnal = new Jurnal(judul, penulis, topik, jenis, noJurnal);
                        jurnal.uploadReferensi("Jurnal");
                        jurnal.info();
           
                    }catch (IllegalArgumentException e){
                        System.out.println("Data tidak valid, " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Berhasil keluar dari program!");
                    state = State.Exit;
                    break;
                default:
                    System.out.println("Menu yang anda pilih tidak valid, silahkan coba lagi");
                    break;
            }
        }
        
    }
    
}
