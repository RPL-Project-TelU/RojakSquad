package com.example.MvcReference.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.MvcReference.entity.Jurnal;

@Repository
public interface JurnalRepository extends JpaRepository<Jurnal,Long>{
    
    
    @Query("SELECT j FROM Jurnal j WHERE UPPER(j.judul) LIKE UPPER(CONCAT('%',:query,'%'))")
    List<Jurnal> searchJurnalByJudul(String query);

    @Query("SELECT j FROM Jurnal j WHERE j.judul = ?1")
    Jurnal findJurnal(String query);

    @Query("SELECT j FROM Jurnal j WHERE UPPER(j.judul) LIKE UPPER(CONCAT('%',:query,'%'))")
    Optional<Jurnal> searchJurnalByJudulOp(String query);
    

    void save(Optional<Jurnal> jurnalOptional);

}
