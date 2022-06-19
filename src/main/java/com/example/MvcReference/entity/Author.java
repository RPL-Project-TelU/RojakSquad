package com.example.MvcReference.entity;

public class Author extends UserImplement implements User {
    public Author(String nama, String username, String pass, String status) {
        super(nama, username, pass, status);
    }

    public Author(Long id,String nama, String username, String pass, String status) {
        super(id,nama, username, pass, status);
    }
    public Author() {
        super();
    }
}
