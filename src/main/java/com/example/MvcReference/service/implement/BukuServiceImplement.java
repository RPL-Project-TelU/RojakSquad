package com.example.MvcReference.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.service.BukuService;

@Service
public class BukuServiceImplement implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getBuku() {
        return bukuRepository.findAll();
    }

    public void addNewBuku(Buku buku) {
        Optional<Buku> bukuOptional =
        bukuRepository.searchBukuByJudulOp(buku.getJudul());
        if (bukuOptional.isPresent()) {
        throw new IllegalStateException("Judul Telah Tersedia");
        }
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