package com.example.MvcReference.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MvcReference.entity.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {

    @Query("SELECT b FROM Buku b WHERE b.judul LIKE CONCAT('%',:query,'%')")
    List<Buku> searchBukuByJudul(String query);

    // @Query("SELECT b FROM buku b WHERE b.judul LIKE CONCAT('%',:query,'%')" + "")
    // Optional<Buku> findBukuByJudul(String buku);

    void save(Optional<Buku> bukuOptional);

}
