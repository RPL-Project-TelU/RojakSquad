package fitur_referensi;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class referensi {
  
    private String judul;
    private String penulis;
    private String topik;
    private String jenis;
    private Date uploadDate;
    private double rating;

    enum Jenis{Internasional, Nasional};

    public referensi(String judul, String penulis, String topik, String jenis) throws IllegalArgumentException{
        if (judul == null || judul.isEmpty()){
            throw new IllegalArgumentException("Judul referensi kosong");
        }
        if (penulis == null || penulis.isEmpty()){
            throw new IllegalArgumentException("Penulis referensi kosong");
        }
        if (topik == null || topik.isEmpty()){
            throw new IllegalArgumentException("Topik referensi kosong");
        }
        if (jenis == null || jenis.isEmpty()){
            throw new IllegalArgumentException("Jenis referensi kosong");
        }
        this.uploadDate = new Date();
        this.judul = judul;  
        this.penulis = penulis;
        this.topik = topik;
        this.jenis = jenis; 

        
        this.rating = 0;
        
    }


    public double getRating(){
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

    public Date getDates(){     
        return this.uploadDate; 
	}


    
  

}
