package com.example.MvcReference.entity;



public class Mahasiswa extends UserImplement {

    public Mahasiswa(String nama, String username, String pass, String status) {
        super(nama, username, pass, status);
    }

    public Mahasiswa(Long id,String nama, String username, String pass, String status) {
        super(id,nama, username, pass, status);
    }
    public Mahasiswa() {
        super();
    }

}
