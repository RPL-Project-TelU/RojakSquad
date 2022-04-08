package Referensi;
import java.util.*;

public class referensi {
  
    private String judul;
    private String penulis;
    private String topik;
    private String jenis;
    private double rating;
    private int countR;
    enum Topik{UiUx, MachineLearning, DataScience};
    enum Jenis{Internasional, Nasional};
    Dictionary dict = new Hashtable();


    public referensi(String judul, String penulis, String topik, String jenis){
        this.judul = judul;
        this.penulis = penulis;
        this.topik = topik;
        this.jenis = jenis;
        this.rating = 0;
        this.countR = 0;
    }

    public void addRating(double rate){
        this.countR += 1;
        this.rating = (this.rating + rate)/this.countR;
    }

    public double getRaring(){
        return rating;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getJudul(){
        return this.judul;
    }

    public void setTopik(String topik){
        this.topik = topik;
    }
    public String getTopik(){
        return topik;
    }

    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    public String getJenis(){
        return this.jenis;
    }

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }
    public String getPenulis(){
        return this.penulis;
    }

    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public String getTanggal(){
        return this.tanggal;
    }

    public void uploadReferensi(int topik){
        dict.put(topik, this);
    }
    
    public void listReferensi(){
        Enumeration enu = dict.elements();
        while(enu.hasMoreElements()){
            System.out.println(enu.nextElement());
        }
        
    }


}
