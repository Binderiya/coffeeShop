package edu.mum.coffee.service;

import edu.mum.coffee.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    
}