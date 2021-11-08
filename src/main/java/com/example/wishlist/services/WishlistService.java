package com.example.wishlist.services;

import com.example.wishlist.models.WishlistModel;
import com.example.wishlist.repositories.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepos;
    // Constructor injection
    // Spring calls this constructor to provide an autogenerated
    // implementation of the WishlistRepository interface
    public  WishlistService(WishlistRepository wishlistRepos) {
        this.wishlistRepos = wishlistRepos;
    }

    public List<WishlistModel> getWishlists() {
        return wishlistRepos.findAll();
    }

    public WishlistModel getWishlist(long id) {
        return wishlistRepos.findById(id);
    }

    public long addWishlist(String name) {
        WishlistModel wm = new WishlistModel(name);
        wishlistRepos.insertWishList(wm);
        return wm.getId();
    }
}
