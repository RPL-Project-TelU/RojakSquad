package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class UserImplement implements User{

    @Id
    @SequenceGenerator(name = "jurnal_sequence", sequenceName = "jurnal_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jurnal_sequence")
    private Long id;
    private String nama, username, pass, status;

    public UserImplement(){
        
    }
    
    public UserImplement(String nama, String username, String pass, String status) {
        this.nama = nama;
        this.username = username;
        this.pass = pass;
        this.status = status;
    }

    public UserImplement(Long id, String nama, String username, String pass, String status) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.pass = pass;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String Login(String user) {
        if (this instanceof Mahasiswa){
            return "Halo "+user+" kamu login sebagai mahasiswa";
    
        }else if(this instanceof Author){
            return "Halo "+user+" kamu login sebagai author";
        }
        
        return "kamu bukan mahasiswa ataupun author";
    }
    

}