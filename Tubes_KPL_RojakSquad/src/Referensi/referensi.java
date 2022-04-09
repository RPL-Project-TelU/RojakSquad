package Referensi;
import java.util.*;

public class referensi {
  
    private String judul;
    private String penulis;
    private String topik;

    private java.util.Date inputDates;
    private double rating;
    private int countR;
    private String jenis;
    enum Jenis{Internasional, Nasional};

    private HashMap dataBase;


    public referensi(String judul, String penulis, String topik, String jenis){
        this.judul = judul;
        this.penulis = penulis;
        this.topik = topik;

        java.util.Date date = new java.util.Date(); 
        this.inputDates = date;

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

    public void setKategori(String topik){
        this.topik = topik;
    }
    public String getKategori(){
        return topik;
    }

    public java.util.Date getDates(){     
        return this.inputDates; 
	}

    public void uploadReferensi(String jenis){
        
    }
    
  


}
