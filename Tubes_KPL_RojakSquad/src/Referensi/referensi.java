package Referensi;

public class referensi {
  
    private String judul;
    private String penulis;
    private int halaman;
    private double rating;
    private int countR;

    public referensi(String judul, String penulis, int halaman){
        this.judul = judul;
        this.penulis = penulis;
        this.halaman = halaman
        this.rating = 0;
        this.countR = 0;
    }

    public void addRating(double rate){
        this.countR += 1;
        this.rating = (this.rating + rate)/this.countR;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getJudul(){
        return this.judul;
    }

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }
    public String getPenulis(){
        return this.penulis;
    }



}
