package tubes_kpl_rojaksquad;

import fitur_searching.searching;
import java.util.*;

public class Tubes_KPL_RojakSquad {
    
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        
        HashMap database = new HashMap();
        database.put("Jurnal tentang machine learning", 5);
        database.put("Paper tentang web development", 4);
        database.put("Metaverse for beginners", 3);
        database.put("Programming for dummies", 2);
        database.put("What is neural networking?", 1);
        
        System.out.println("====Searching via judul====");
        
        System.out.print("Judul jurnal -> ");
        String userInput = myObj.nextLine();
        searching.searching(userInput, database);
        
        System.out.println(" ");
        
        System.out.println("====Searching via ratings====");
        
        System.out.print("Ratings jurnal -> ");
        Integer userInputInt = myObj.nextInt();
        searching.searching(userInputInt, database);
        
    }
    
}
