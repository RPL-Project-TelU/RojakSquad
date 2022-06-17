package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table

/**
 * menyimpan id buku, judul buku, penulis buku, penerbit buku
 * id buku digenerate automatis sebagai primary key.
 */
public class Buku {
    @Id
    @SequenceGenerator(name = "buku_sequence", sequenceName = "buku_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buku_sequence")
    private Long id;
    private String judul;
    private String penulis;
    private String penerbit;


    /**
     * 
     * @param judul berisikan String bebas
     * @param penulis berisikan String bebas
     * @param penerbit berisikan String bebas
     */
    public Buku(String judul, String penulis, String penerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }
    /**
     * 
     * Constructor default
     */
    public Buku() {
    }

    /**
     * 
     * @param id berisi Long dengan angka bebas
     * @param judul berisikan String bebas
     * @param penulis berisikan String bebas
     * @param penerbit berisikan String bebas
     */
    public Buku(Long id, String judul, String penulis, String penerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    /**
     * @return Long dari values id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id berisikan primary key buku
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return string dari value judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * 
     * @param judul berisi String judul dari buku
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * 
     * @return string dari value penulis
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * 
     * @param penulis berisikan String penulis buku
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    /**
     * 
     * @return String dari values penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * 
     * @param penerbit berisikan String penerbit dari buku
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }


}
