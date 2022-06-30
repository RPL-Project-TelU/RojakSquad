package com.example.MvcReference.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MvcReference.entity.Users;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {


    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findUser(String query);

    void save(Optional<Users> userOptional);

    Users findUserByUsername(String username); 

}