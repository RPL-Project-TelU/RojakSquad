package com.example.MvcReference.service;

import com.example.MvcReference.entity.Users;

/**
 * Interface untuk user
 */
public interface UserService {
    public Users findUser(String query);
    
}
