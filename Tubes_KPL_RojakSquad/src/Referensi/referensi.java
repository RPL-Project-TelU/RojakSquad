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

    enum Jenis{Internasional, Nasional};

    private HashMap<String,List> dataBase = new HashMap<String,List>();
    private List<referensi> listR = new ArrayList<referensi>();

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

    public HashMap getDB(){
        return this.dataBase;
    }

    public List getList(){
        return this.listR;
    }

    public void uploadReferensi(String jenis){
        
    }

    public void info(){

        for (Map.Entry<String,List> entry: this.dataBase.entrySet()) {
         
            System.out.println("Key:" +entry.getKey());
            System.out.println("Value:" +entry.getValue());
            for(int i=0;i<entry.getValue().size(); i++) {
                System.out.println("------------------");
                System.out.println("Array:"+i);
                referensi r1 = (referensi)entry.getValue().get(i);
                System.out.println("Name:" +r1.getJudul());
                System.out.println("Age:" + r1.getPenulis());
                System.out.println("Emp no:" + r1.getTopik());
                System.out.println("------------------");
            }
        }

    }
    
  

}
