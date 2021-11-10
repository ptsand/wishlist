package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserModel userModel){
        // Added password hashing
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.insertUser(userModel);
    }

    @Override
    public UserModel findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
