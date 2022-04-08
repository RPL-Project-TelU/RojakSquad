package tubes01kpl;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  


public class Jurnal extends referensi {
	private int noJurnal;
	private int halaman;
    private java.util.Date inputDates;

	public Jurnal(String judul, String penulis, String topik, int noJurnal){
		super(judul);       
		this.noJurnal = noJurnal;
        java.util.Date date = new java.util.Date(); 
		this.inputDates = date;
	}
	public java.util.Date getDates(){     
        return this.inputDates; 
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
