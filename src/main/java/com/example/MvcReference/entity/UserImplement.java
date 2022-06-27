package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Login sebuah user bisa mahasiswa ataupun author.
 * parameter Id di generate secara automatis untuk dijadikan Primary key di Database
 */
@Entity
@Table
public class UserImplement implements User{

    @Id
    @SequenceGenerator(name = "jurnal_sequence", sequenceName = "jurnal_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jurnal_sequence")
    private Long id;
    private String nama, username, pass, status;

    /**
     * Constructor default
     */
    public UserImplement(){
        
    }
    
    /**
     * Constructor tanpa parameter Id
     * @param nama user berisi String bebas
     * @param username user berisi string bebas untuk login
     * @param pass kata sandi user berisi string bebas untuk login
     * @param status bisa mahasiswa atau author dalam bentuk string
     */
    public UserImplement(String nama, String username, String pass, String status) {
        this.nama = nama;
        this.username = username;
        this.pass = pass;
        this.status = status;
    }

    /**
     * Constructor dengan parameter id
     * @param id primary key untuk user didalam database
     * @param nama user berisi string bebas bebas untul login
     * @param username user berisi string bebas bebas untul login
     * @param pass kata sandi user berisi string bebas untul login
     * @param status bisa mahasiswa atau author dalam bentuk string
     */
    public UserImplement(Long id, String nama, String username, String pass, String status) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.pass = pass;
        this.status = status;
    }

    /**
     * 
     * @return string nama user
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama user dalam bentuk String bebas
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return string username user untuk login
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username untuk login dalam bentuk string bebas
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return String password user
     */
    public String getPass() {
        return pass;
    }

    /**
     * 
     * @param pass berisi katasandi user untuk login dalam bentuk string bebas
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * 
     * @return status dari user bisa mahasiswa atau author
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status berisi string Mahasiswa atau Author
     */
    public void setStatus(String status) {
        this.status = status;
    }
    

    /**
     * login untuk user bisa mahasiswa ataupun author mengembalikan string yg berbeda
     * @param user string nama dari user
     */
    @Override
    public String Login() {
        
        if (this.getStatus() == "Author"){
            return "Author";
        }
        return "Mahasiswa";
    }
    

}