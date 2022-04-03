package Referensi;


public class referensi {
  
    protected String judul;
    protected String penulis;
    protected String kategori;
    protected int halaman;
    protected String tanggal;
    protected double rating;
    protected int countR;

    public referensi(String judul, String penulis, String kategori, int halaman, String tanggal) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.halaman = halaman
        this.tanggal = tanggal;
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

    public void setKategori(String kategori){
        this.penulis = penulis;
    }
    public String getKategori(){
        return this.kategori;
    }

    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public String getTanggal(){
        return this.tanggal;
    }


}
