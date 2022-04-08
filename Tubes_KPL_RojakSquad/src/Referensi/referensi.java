package Referensi;
import java.util.*;

public class referensi {
  
    private String judul;
    private String penulis;
    private String topik;
    private long tanggalUpload;
    private double rating;
    private int countR;
   


    public referensi(String judul, String penulis,String topik){
        this.judul = judul;
        this.penulis = penulis;
        this.topik = topik;
        Date today = new Date();
        this.tanggalUpload = today.getTime();
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

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }
    public String getPenulis(){
        return this.penulis;
    }


    public void setKategori(String topik){
        this.topik = topik;
    }
    public String getKategori(){
        return topik;
    }

    public long getTanggalUp(){
        return tanggalUpload;
    }


 

}
