package fitur_referensi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buku extends referensi {
    private String publisher;
    
    public Buku(String judul, String penulis, String topik,String jenis,String publisher){
	    super(judul,penulis,topik,jenis);
        if(publisher == null || publisher.trim().isEmpty()){
            throw new IllegalArgumentException("Nama Publisher tidak boleh kosong");
        }
        this.publisher = publisher;
    }

    public String getPublisher(){
        return this.publisher;
    }


  



}
