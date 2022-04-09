package Referensi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Buku extends referensi {
    private String publisher;
    
    public Buku(String judul, String penulis, String topik,String jenis,String publisher){
	    super(judul,penulis,topik,jenis);
        this.publisher = publisher;
    }

    public String getPublisher(){
        return this.publisher;
    }

    @Override
    public void uploadReferensi(String tipe){
        List listR = this.getList();
        listR.add(this);
        Map dataR = this.getDB();
        dataR.put(tipe,listR);

    }

}
