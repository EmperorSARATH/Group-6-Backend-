package com.example.healthcare.service;

import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.exception.UserNotFoundException;
import com.example.healthcare.entities.User;
import com.example.healthcare.dao.UserRepository;
//import com.example.healthcare.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Override
    public User validateUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            if (userRepository.exists(Example.of(user))){
                return user;
            }
            else
                throw new UserNotFoundException("User not found");
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }
    public String listUsers(){
        return String.valueOf(userRepository.findAll());
    }

    @Override
    public User removeUser(User user) {
        Optional<User> userTemp = userRepository.findById(user.getId());
        if (userTemp.isPresent()) {
            userRepository.deleteById(user.getId());
            return user;
        } else
            return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
