package fitur_referensi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UploadReferensi {
    String judul;
    String penulis;
    String topik;
    String jenis;
    String penerbit;
    int noJurnal;
    int pilihan1;
    ArrayList<referensi> Lbuku = new ArrayList<referensi>();
    ArrayList<referensi> Ljurnal = new ArrayList<referensi>();
    private HashMap<String,ArrayList<referensi>> dataBase = new HashMap<>();

    enum State{Upload, Buku, Jurnal, Exit};

    public HashMap getDatabase(){
        return dataBase;
    }
    
    public void upload(){


        State state = State.Upload;
        Scanner scan = new Scanner(System.in);
   
        String screenName[] = {"Upload", "Buku", "Jurnal", "Exit"};
        
        while(state != State.Exit){
            System.out.println("Pilih referensi yang ingin di-upload : \n1. Buku\n2. Jurnal\n3. List Referensi\n4. Exit Program");
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
                    System.out.print("Masukan Penerbit: ");
                    penerbit = scan.nextLine();
                    jenis = "buku";
                    try{
                        referensi buku = new Buku(judul,penulis,topik,jenis,penerbit);
                  
                        Lbuku.add(buku);
                        dataBase.put("Buku", Lbuku);
                   
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
                    jenis = "jurnal";
                    System.out.print("Masukkan Nomor Jurnal: ");
                    noJurnal = scan.nextInt();
                    try{
                        referensi jurnal = new Jurnal(judul, penulis, topik, jenis, noJurnal);
                       

                        Ljurnal.add(jurnal);
                        dataBase.put("Jurnal", Ljurnal);

                        
                        
                    }catch (IllegalArgumentException e){
                        System.out.println("Data tidak valid, " + e.getMessage());
                    }
                    break;
                case 3:
                    state = State.Upload;
                    for (Map.Entry<String,ArrayList<referensi>> entry: dataBase.entrySet()) {
            
                        System.out.println("=====KUMPULAN REFERENSI "+entry.getKey()+"======");
                        
            
                        for(int i=0;i<entry.getValue().size(); i++) {
                            System.out.println("------------------");
                            referensi r1 = entry.getValue().get(i);
                            System.out.println("Judul:" +r1.getJudul());
                            System.out.println("Penulis:" + r1.getPenulis());
                            System.out.println("Topik:" + r1.getTopik());
                            if(r1 instanceof Buku){
                                Buku temp = (Buku)r1;
                                System.out.println("Penerbit: "+ temp.getPublisher());
                            }
                            if(r1 instanceof Jurnal){
                                Jurnal temp = (Jurnal)r1;
                                System.out.println("nomer jurnal: "+ temp.getNoJurnal());
                            }
                            System.out.println("Rating:" + r1.getRating());
                            System.out.println("Tanggal Upload:" + r1.getDates());
                            
                        }
                        System.out.println("------------------");
                    }
                    break;

                case 4:
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
