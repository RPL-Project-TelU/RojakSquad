package com.example.MvcReference.entity;

public class Jurnal {
    
    private Long id;
    private String judul;
    private String penulis;
    private int no_jurnal;

    public Jurnal(Long id, String judul, String penulis, int no_jurnal){
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.no_jurnal = no_jurnal;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getNo_jurnal() {
        return this.no_jurnal;
    }

    public void setNo_jurnal(int no_jurnal) {
        this.no_jurnal = no_jurnal;
    }

}
