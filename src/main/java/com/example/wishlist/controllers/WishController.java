package com.example.wishlist.controllers;

import com.example.wishlist.models.WishModel;
import com.example.wishlist.services.WishService;
import com.example.wishlist.services.WishlistService;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Size;

@Controller
@RequestMapping("/wish")
public class WishController {

    private final WishlistService wishlistService;
    private final WishService wishService;
    // Constructor injection
    // Spring calls this constructor to provide an instance of wishlistService
    public WishController(WishlistService wishlistService, WishService wishService) {
        this.wishlistService = wishlistService;
        this.wishService = wishService;
    }

    @GetMapping("/show-all")
    public String showAllWishes(Model model){
        model.addAttribute("wishes", wishService.getWishes());
        return "wishes";
    }

    @GetMapping("/show")
    public String showWish(Model model, @RequestParam Long id) {
            model.addAttribute("wish", wishService.getWish(id));
            return "wish";
    }

    @GetMapping("/create")
    public String createWishForm(Model model) {
        model.addAttribute("wishlists", wishlistService.getWishlists());
        return "add-wish";
    }

    @PostMapping("/create")
    public String createWish(@RequestParam String name, @RequestParam @URL @Size(max=125) String url, @RequestParam Long wishlistId, RedirectAttributes attributes) {
        long newId = wishService.addWish(name, url, wishlistId);
        attributes.addAttribute("id", wishlistId);
        return "redirect:/wishlist/show";
    }
}
