package com.example.MvcReference.entity;

import java.util.ArrayList;

/**
 * implementasi metode singleton untuk menyimpan class jurnal
 */
public class JurnalSingleton {

    private ArrayList<Jurnal> dataJurnal;
    private static JurnalSingleton instance;
    
    
    /**
     * Constructor singleton
     */
    private JurnalSingleton() {
        dataJurnal = new ArrayList<Jurnal>();
    }
    
    /**
     * 
     * @return mengembalikan instance singleton
     */
    public static JurnalSingleton getDataSingleton() {
        //membuat instance yg baru ketika belum ada sama sekali
        if (instance == null){
            instance = new JurnalSingleton();
        }
        return instance;
    }

    /**
     * 
     * @return semua data jurnal yang sudah masuk
     */
    public ArrayList<Jurnal> getSemuaData(){
        return dataJurnal;
    }

    /**
     * menambah jurnal baru kedalam arraylist
     * @param id primarykey jurnal dengan tipe Long
     * @param judul judul junral dengan tipe String
     * @param penulis penulis jurnal dengan tipe String
     * @param noJurnal nomer jurnal dengan tipe integer
     */
    public void addJurnal(Long id, String judul, String penulis, int noJurnal){
        Jurnal temp = new Jurnal(id, judul, penulis, noJurnal);
        dataJurnal.add(temp);
    }

    /**
     * menghapus sebuah jurnal berdasarkan judul
     * @param judul judul jurnal dengan tipe string
     */
    public void hapusJurnal(String judul){
        for (int i = 0; i < dataJurnal.size(); i++) {
            if (judul == dataJurnal.get(i).getJudul()){
                dataJurnal.remove(i);
                break;
            }
        }
    }


}
