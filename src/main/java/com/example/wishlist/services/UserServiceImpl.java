package com.example.wishlist.services;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserModel> search(String searchTerm) {
        return userRepository.searchUser("%"+searchTerm+"%");
    }

    @Override
    public void createRelation(long loggedInUserId, long friendId) {
        //TODO : tell database to insert relation;
        // insert into userrelation (user1_id, user2id) values(..
    }

    public List<UserModel> findFriends(long currentUserId){
        // select user1Id, user2Id from user_relation where user1Id=? or user2Id=?
        // we are interested in the userId that is not equal to currentUserid
        // find UserModel for those other users.

        var allFriends = new ArrayList<UserModel>();
        return allFriends;
    }
}
