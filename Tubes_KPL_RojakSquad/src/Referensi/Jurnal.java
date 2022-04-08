package Referensi;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  


public class Jurnal extends referensi {

	  private int noJurnal;

	  public Jurnal(String judul, String penulis, String topik, String jenis, int noJurnal){
	  	super(judul,penulis,topik,jenis);       
  		this.noJurnal = noJurnal;

	  }
    

        
    public void setNoJurnal(int noJurnal){
        try {
          if (noJurnal < 1000000 || noJurnal > 9999999);
          System.out.println("Nomor jurnal tidak boleh kurang/lebih dari 7 digit!"); 
          this.noJurnal = noJurnal;
        }
        catch (Exception e) {
          System.out.println(e.getMessage());
        }
            
        }

    public int getNoJurnal(){
      return this.noJurnal;
    }

	  

}
