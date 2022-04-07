package fitur_searching;

import java.util.*;

public class searching{
    
    public static <T> void searching(T obj, HashMap database){
        int i;
        boolean result;
        if(obj instanceof String){
          result = false;
          for(i = 0; i < database.size() ; i++){
                if(database.keySet().toArray()[i].equals(obj)){
                    result = true;
                    System.out.println("Result: " + database.keySet().toArray()[i]);
                }
          }
          if(!result){
              System.out.println("Not found");
          }
                
        }
        
        else if(obj instanceof Integer){
          result = false;
          for(i = 0; i < database.size() ; i++){
                if((Integer)database.values().toArray()[i] >= (Integer)obj){
                    result = true;
                    System.out.println("Result: " + database.keySet().toArray()[i] + " with a rating of " + database.values().toArray()[i]);
                }
          }
          if(!result){
              System.out.println("Not found");
          }
          
         }  
          
    }
    
}
