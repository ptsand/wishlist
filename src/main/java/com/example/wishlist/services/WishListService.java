package com.example.wishlist.services;

import com.example.wishlist.models.WishList;
import com.example.wishlist.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepos;

    public List<WishList> getWishLists() {
        return wishListRepos.findAll();
    }
}
