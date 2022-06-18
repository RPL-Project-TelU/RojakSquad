package com.example.MvcReference.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;

public interface BukuService {
    public List<Buku> getBuku();
    public void addNewBuku(Buku buku);
    public List<Buku> searchBuku(String query);
    public Buku findBuku(String query);

}
