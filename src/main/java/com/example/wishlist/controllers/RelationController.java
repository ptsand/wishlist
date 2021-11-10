package com.example.wishlist.controllers;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/relation")
public class RelationController {

    private final UserService userService;

    public RelationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserModel userModel() {
        return new UserModel();
    }

    @GetMapping("/search")
    public @ResponseBody List<UserModel> search(@RequestParam String searchTerm) {

        return userService.search(searchTerm);
    }

}
