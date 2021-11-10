package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<UserModel> search(String searchTerm) {
        return userRepository.searchUser("%"+searchTerm+"%");
    }
}
