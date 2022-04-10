package Referensi;
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

    public HashMap getDB(){
        return this.dataBase;
    }

    public List getList(){
        return this.listR;
    }

    public void uploadReferensi(String tipe){

        
        
        List listR = this.getList();
        listR.add(this);
        Map dataR = this.getDB();
        dataR.put(tipe,listR);

    }


    public void info(){

        for (Map.Entry<String,List> entry: this.dataBase.entrySet()) {
         
            System.out.println("Key:" +entry.getKey());

            for(int i=0;i<entry.getValue().size(); i++) {
                System.out.println("------------------");
                referensi r1 = (referensi)entry.getValue().get(i);
                System.out.println("Judul:" +r1.getJudul());
                System.out.println("Penulis:" + r1.getPenulis());
                System.out.println("Topik:" + r1.getTopik());
                System.out.println("Jenis:" + r1.getJenis());
                System.out.println("Rating:" + r1.getRating());
                System.out.println("Tanggal Upload:" + r1.getDates());
                System.out.println("------------------");
            }
        }

    }
    
  

}
