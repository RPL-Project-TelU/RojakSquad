package Referensi;

public class Buku extends referensi {
    private String publisher;
    public Buku(String judul, String penulis, String topik,String publisher){
	  super(judul,penulis,topik);
      this.publisher = publisher;
  }
}
