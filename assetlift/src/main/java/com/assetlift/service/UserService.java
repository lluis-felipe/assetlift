package com.assetlift.service;

import com.assetlift.model.User;
import com.assetlift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userIn) {
        User userOut = userRepository.findById(id).orElse(null);

        if (userOut == null) {
            return null;
        }

        userIn.setId(id);
        return userRepository.save(userIn);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
