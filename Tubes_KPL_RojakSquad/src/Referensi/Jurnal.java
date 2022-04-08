package Referensi;

public class Jurnal extends referensi {
    private String instansi;

    public Jurnal(String judul, String penulis, String topik, String instansi){
        super(judul,penulis,topik);
        this.instansi = instansi;
    }
}
