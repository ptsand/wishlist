package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;

import java.util.List;

public interface UserService {

    void registerUser(UserModel userModel);

    UserModel findUserByUsername(String username);

    List<UserModel> search(String searchTerm);

    void createRelation(long loggedInUserId, long friendId);
}
