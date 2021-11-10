package com.example.wishlist.controllers;

import com.example.wishlist.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;
    // Constructor injection
    // Spring calls this constructor to provide an instance of wishlistService
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/wishlists")
    public String wishlists(Model model){
        model.addAttribute("wishlists", wishlistService.getWishlists());
        return "wishlists";
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model, @RequestParam String action,
                           @RequestParam(required = false) Long id,
                           @RequestParam(required = false) String name,
                           RedirectAttributes attributes
                           ) {
        if (action.equals("show")) {
            model.addAttribute("wishlist", wishlistService.getWishlist(id));
            return "wishlist";
        }
        else if (action.equals("delete")) {
            // TODO: code to delete a wishlist
        }
        else if (action.equals("create")) {
            if (name == null) return "add-wishlist";
            long newId = wishlistService.addWishlist(name);
            attributes.addAttribute("action","show");
            attributes.addAttribute("id", newId);
            return "redirect:/wishlist";
        }
        else if (action.equals("update")) {

        }
        else {

        }
        return "";
    }

}
