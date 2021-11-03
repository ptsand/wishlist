package com.example.wishlist.services;

import com.example.wishlist.models.WishlistModel;
import com.example.wishlist.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepos;

    public List<WishlistModel> getWishlists() {
        return wishlistRepos.findAll();
    }

    public WishlistModel getWishlist(long id) {
        return wishlistRepos.findById(id);
    }
}
