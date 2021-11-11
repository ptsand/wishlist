package com.example.wishlist.controllers;

import com.example.wishlist.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    // Constructor injection
    // Spring calls this constructor to provide an instance of wishlistService
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/show-all")
    public String showAllWishlists(Model model){ // TODO: show only the logged in users wishlists
        model.addAttribute("wishlists", wishlistService.getWishlists());
        return "wishlists";
    }

    @GetMapping("/show")
    public String showWishlist(Model model, @RequestParam Long id) {
            model.addAttribute("wishlist", wishlistService.getWishlist(id));
            return "wishlist";
    }

    @GetMapping("/create")
    public String createWishlistForm() {
        return "add-wishlist";
    }

    @PostMapping("/create")
    public String createWishlist(@RequestParam String name, RedirectAttributes attributes) {
        long newId = wishlistService.addWishlist(name);
        attributes.addAttribute("id", newId);
        return "redirect:/wishlist/show";
    }
}
