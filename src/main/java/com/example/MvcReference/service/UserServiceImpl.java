package com.example.MvcReference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Users;

/**
 * Implementasi dari User Service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Mencaru yser yang ada didalam repository atau databse
     * @param query nama user yang terdaftar dalam bentuk String
     * @return sebuah user yang mempunyai nama sesuai parameter masukan
     */
    @Override
    public Users findUser(String query) {
        return userRepository.findUser(query);
    } 
    
}
