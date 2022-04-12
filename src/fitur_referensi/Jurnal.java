package fitur_referensi;


import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  


public class Jurnal extends referensi {
	    private int noJurnal;

      public Jurnal(String judul, String penulis, String topik, String jenis, int noJurnal) throws IllegalArgumentException {
	        super(judul,penulis,topik,jenis); 
            if (noJurnal < 1000000 || noJurnal > 9999999){
                throw new IllegalArgumentException("Nomor jurnal tidak boleh lebih/kurang dari 7 digit!");
            }else if(noJurnal == 0){
                throw new IllegalArgumentException("Nomor jurnal tidak boleh kosong!");
            }
            this.noJurnal = noJurnal;      
      }
        
      public void setNoJurnal(int noJurnal){
            this.noJurnal = noJurnal;
      }

      public int getNoJurnal(){
            return this.noJurnal;

      }

      
      
          
    
        
        

}
