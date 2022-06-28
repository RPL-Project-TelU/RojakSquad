package com.example.MvcReference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Users;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findUser(String query) {
        return userRepository.findUser(query);
    }
    
}
