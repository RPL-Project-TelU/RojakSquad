package Referensi;

public class Buku extends referensi {
    private String publisher;
    
    public Buku(String judul, String penulis, String topik,String jenis,String publisher){
	    super(judul,penulis,topik,jenis);
        this.publisher = publisher;
    }

    public String getPublisher(){
        return this.publisher;
    }

}
