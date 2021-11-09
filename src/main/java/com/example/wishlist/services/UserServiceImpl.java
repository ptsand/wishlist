package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserModel userModel){
        userRepository.insertUser(userModel);
    }
}
