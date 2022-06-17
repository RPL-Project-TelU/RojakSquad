package com.example.MvcReference.library;

public class libraryReference {
    
    public String findBuku(String table, String value){
        return "SELECT b FROM "+table+" b WHERE b."+value+" = ?1";
    }
    
    public String searchByValue(String table, String value){
        return "SELECT b FROM "+ table+" b WHERE UPPER(b."+value+") LIKE UPPER(CONCAT('%',:query,'%'))";
    }

    public String searchByValue2(String table, String value){
        return "SELECT b FROM "+table+" b WHERE UPPER(b."+value+") LIKE UPPER(CONCAT('%',:query,'%'))";
    }
}
