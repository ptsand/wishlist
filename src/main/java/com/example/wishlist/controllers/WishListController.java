package com.example.wishlist.controllers;

import com.example.wishlist.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("wishlists", wishListService.getWishLists());
        return "index";
    }

}
