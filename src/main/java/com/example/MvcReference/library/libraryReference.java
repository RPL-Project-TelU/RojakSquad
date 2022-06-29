package com.example.MvcReference.library;

/**
 * Library query untuk repository Buku dan Jurnal, 
 */
public class libraryReference {

    /**
     * Mencari buku dengan query postreSQL
     * @param table String berupa table yang ingin dicari buku/jurnal
     * @param value String berisi jenis pencarian yang ingin digunakan judul/rating
     * @return Mengembalikan string query untuk mengembalikan buku yang terdapat pada 
     * table yang dipilih dan menggunakan pencarian jenis pencarian teretentu.
     * 
     */
    public String findBuku(String table, String value){
        return "SELECT b FROM "+table+" b WHERE b."+value+" = ?1";
    }
    
    /**
     * Sebuah query untuk mencari buku/user berdasarkan parameter table
     * dan mencari dengan value yang di inginkan
     * @param table berupa nama table di dalam database Buku/User/Jurnal/...
     * @param value berupa nama kolom yang ada didalam table tersebut
     * @return String query untuk mencari sesuai dengan value kolomnya bisa nama/judu/rating dll
     */
    public String searchByValue(String table, String value){
        return "SELECT b FROM "+ table+" b WHERE UPPER(b."+value+") LIKE UPPER(CONCAT('%',:query,'%'))";
    }

    /**
     * Sebuah query untuk mencari buku/user berdasarkan parameter table
     * dan mencari dengan value yang di inginkan
     * @param table berupa nama table di dalam database Buku/User/Jurnal/...
     * @param value berupa nama kolom yang ada didalam table tersebut
     * @return String query untuk mencari sesuai dengan value kolomnya bisa nama/judu/rating dll
     */
    public String searchByValue2(String table, String value){
        return "SELECT b FROM "+table+" b WHERE UPPER(b."+value+") LIKE UPPER(CONCAT('%',:query,'%'))";
    }
}
