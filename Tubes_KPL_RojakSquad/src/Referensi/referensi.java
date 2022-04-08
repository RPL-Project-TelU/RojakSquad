package Referensi;
import java.util.*;

public class referensi {
  
    private String judul;
    private String penulis;
    private String topik;
    private String jenis;
    private java.util.Date inputDates;
    private double rating;
    private int countR;
    

    enum Topik{UiUx, MachineLearning, DataScience};
    enum Jenis{Internasional, Nasional};
    Dictionary dict = new Hashtable();


    public referensi(String judul, String penulis, String topik, String jenis) throws IllegalArgumentException{
        if (judul == null || judul.trim().isEmpty()){
            throw new IllegalArgumentException("Judul referensi kosong");
        }
        if (penulis == null || penulis.trim().isEmpty()){
            throw new IllegalArgumentException("Penulis referensi kosong");
        }
        if (topik == null || topik.trim().isEmpty()){
            throw new IllegalArgumentException("Topik referensi kosong");
        }
        if (jenis == null || jenis.trim().isEmpty()){
            throw new IllegalArgumentException("Jenis referensi kosong");
        }
        this.judul = judul;  
        this.penulis = penulis;
        this.topik = topik;
        this.jenis = jenis;
        
        java.util.Date date = new java.util.Date(); 
        this.inputDates = date;       
        this.rating = 0;
        this.countR = 0;
    }

    public void addRating(double rate){
        this.countR += 1;
        this.rating = (this.rating + rate)/this.countR;
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

    public java.util.Date getDates(){     
        return this.inputDates; 
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
