package com.example.MvcReference.entity;

import java.util.ArrayList;

public class JurnalSingleton {

    private ArrayList<Jurnal> DataJurnal;
    private static JurnalSingleton _instance;
    
    
    //Constructor Singleton
    private JurnalSingleton() {
        DataJurnal = new ArrayList<Jurnal>();
    }
    
    public static JurnalSingleton GetDataSingleton() {
        if (_instance == null){
            _instance = new JurnalSingleton();
        }
        return _instance;
    }

    public ArrayList<Jurnal> GetSemuaData(){
        return DataJurnal;
    }

    public void AddJurnal(Long id, String judul, String penulis, int no_jurnal){
        Jurnal temp = new Jurnal(id, judul, penulis, no_jurnal);
        DataJurnal.add(temp);
    }

    public void HapusJurnal(String judul){
        for (int i = 0; i < DataJurnal.size(); i++) {
            if (judul == DataJurnal.get(i).getJudul()){
                DataJurnal.remove(i);
            }
        }
    }


}
