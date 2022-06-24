package com.example.MvcReference.service;

import java.util.List;

import com.example.MvcReference.entity.Buku;

public interface BukuService {
    public List<Buku> getBuku();
    public void addNewBuku(Buku buku);
    public List<Buku> searchBuku(String query);
    public Buku findBuku(String query);
    public void deleteBukuByJudul(String query);

}