package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;

public interface UserService {
    void registerUser(UserModel userModel);
    UserModel findUserByUsername(String username);
}
