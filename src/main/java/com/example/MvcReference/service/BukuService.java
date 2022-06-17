package com.example.MvcReference.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;

    @Autowired
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public List<Buku> getBuku() {
        return bukuRepository.findAll();
    }

    public void addNewBuku(Buku buku) {
<<<<<<< HEAD
        Optional<Buku> bukuOptional =
<<<<<<< HEAD
        bukuRepository.searchBukuByJudulOpt(buku.getJudul());
=======
        bukuRepository.searchBukuByJudulOp(buku.getJudul());
>>>>>>> main
        if (bukuOptional.isPresent()) {
        throw new IllegalStateException("Judul Telah Tersedia");
        }
=======
        // Optional<Buku> bukuOptional =
        // bukuRepository.findBukuByJudul(buku.getJudul());
        // if (bukuOptional.isPresent()) {
        // throw new IllegalStateException("Judul Telah Tersedia");
        // }
>>>>>>> parent of a522f5d (edit readme)
        bukuRepository.save(buku);
    }

    public List<Buku> searchBuku(String query) {
        List<Buku> buku = bukuRepository.searchBukuByJudul(query);
        return buku;
    }
    public Buku findBuku(String query){
        Buku buku = bukuRepository.findBuku(query);
        return buku;
    }

}
