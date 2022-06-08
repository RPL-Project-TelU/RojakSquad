package com.example.MvcReference.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MvcReference.entity.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {

    // @Query("SELECT s FROM buku s WHERE s.judul =?1")
    Optional<Buku> findBukuByJudul(String buku);

    void save(Optional<Buku> bukuOptional);

}
