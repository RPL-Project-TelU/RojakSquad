package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Buku {
    @Id
    @SequenceGenerator(name = "buku_sequence", sequenceName = "buku_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buku_sequence")
    private Long id;
    private String judul;
    private String penulis;
    private String penerbit;

    public Buku(String judul, String penulis, String penerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public Buku() {
    }

    public Buku(Long id, String judul, String penulis, String penerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Override
    public String toString() {
        return "Buku [id=" + id + ",\n\n judul=" + judul + ",\n\n penerbit=" + penerbit + ",\n\n penulis=" + penulis
                + "]";
    }
}
