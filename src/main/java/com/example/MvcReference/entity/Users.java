package com.example.MvcReference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clas yang menyimpan user berupa mahasiswa atau author di dalam atribut status,
 * id di generate seacara automatis untuk menjadi PK didalam table database.
 */
@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String nama;
    private String username;
    private String password;
    private String status;
    
    /**
     * Constructor default
     */
    public Users() {
    }

    /**
     * Constructor dengan paramter Id
     * @param id
     * @param nama
     * @param username
     * @param password
     * @param status
     */
    public Users(Long id, String nama, String username, String password, String status) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.status = status;
        this.id = id;
    }

    /**
     * Constructor tanpa parameter Id
     * @param nama
     * @param username
     * @param password
     * @param status
     */
    public Users(String nama, String username, String password, String status) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
