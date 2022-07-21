package com.example.healthcare.service;

import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User validateUser(String username,String password);
    public User addUser(User user);
    public User removeUser(User user);

    public List<User> getAllUser();
}
