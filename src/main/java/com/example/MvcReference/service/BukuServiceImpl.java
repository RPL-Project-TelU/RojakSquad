package com.example.MvcReference.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;

/**
 * Implementasi dari buku service, untuk melakukan pencarian, penambahan dan penghapusan buku
 */
@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    /**
     * @return mengembalikan List berisi Buku didalam repository Buku
     */
    public List<Buku> getBuku() {
        return bukuRepository.findAll();
    }

    /**
     * menambah buku kedalam repository Buku
     * @param buku berisi tipe data buku yang ingin ditambahkan
     */
    public void addNewBuku(Buku buku) {
        Optional<Buku> bukuOptional =
        bukuRepository.searchBukuByJudulOp(buku.getJudul());

        // Cek buku sudah ada atau belum agar tidak duplikat
        if (bukuOptional.isPresent()) {
        throw new IllegalStateException("Judul Telah Tersedia");
        }
        bukuRepository.save(buku);
    }

    /**
     * Mencari buku berdasarkan judul mengembalikan list buku yang mempunyai
     * judul serupa
     * @param query berisi judul buku
     * @return List Buku dengan kesamaan judul 
     */
    public List<Buku> searchBuku(String query) {
        List<Buku> buku = bukuRepository.searchBukuByJudul(query);
        return buku;
    }

    /**
     * mencari buku spesifik berdasarkan judul, mengembalikan satu buah buku
     * @param query judul buku berupa string
     * @return sebuah buku yang dicari berdasarkan judul
     */
    public Buku findBuku(String query){
        Buku buku = bukuRepository.findBuku(query);
        return buku;
    }

    /**
     * Menghapus sebuah buku berdasarkan judul
     * @param query judul sebuah buku yang ingin dihapus
     */
    public void deleteBukuByJudul(String query){
        bukuRepository.delete(findBuku(query));
    }

}
