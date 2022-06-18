package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class jurnal, berisi id, judul, penulis, dan nomer jurnal
 */
@Entity
@Table
public class Jurnal {
    @Id
    @SequenceGenerator(name = "jurnal_sequence", sequenceName = "jurnal_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jurnal_sequence")
    private Long id;
    private String judul;
    private String penulis;
    private int noJurnal;

    /**
     * membuat objek jurnal dengan isi id,judul,penulis dan nomer jurnal
     * @param id berisi angka untuk primary key jurnal di Db
     * @param judul berisi string judul jurnal
     * @param penulis berisi string judul penulis
     * @param noJurnal berisi angka nomer jurnal
     */
    public Jurnal(Long id, String judul, String penulis, int noJurnal){
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.noJurnal = noJurnal;
    }

    /**
     * 
     * @return primary key jurnal dalam bentuk Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * menetapkan id primarykey jurnal
     * @param id Long berisi primary key
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return string judul jurnal
     */
    public String getJudul() {
        return this.judul;
    }

    /**
     * membuat judul jurnal
     * @param judul
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * 
     * @return string penulis jurnal
     */
    public String getPenulis() {
        return this.penulis;
    }

    /**
     * 
     * @param penulis berisi string bebas nama penulis jurnal
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    /**
     * 
     * @return nomer jurnal
     */
    public int getNoJurnal() {
        return this.noJurnal;
    }

    /**
     * 
     * @param noJurnal berisi angka sebagai nomer jurnal
     */
    public void setNoJurnal(int noJurnal) {
        this.noJurnal = noJurnal;
    }

}
