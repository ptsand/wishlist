package com.example.wishlist.controllers;

import com.example.wishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("wishlists", wishlistService.getWishlists());
        return "index";
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model, @RequestParam int id){
        model.addAttribute("wishlist", wishlistService.getWishlist(id));
        return "wishlist";
    }

}
