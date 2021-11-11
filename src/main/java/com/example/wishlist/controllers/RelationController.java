package com.example.wishlist.controllers;

import com.example.wishlist.models.UserModel;
import com.example.wishlist.services.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/search")
    public String search(Model model, @Param("searchTerm") String searchTerm) {
        List<UserModel> userList = userService.search(searchTerm);
        model.addAttribute("userList", userList);
        model.addAttribute("searchTerm", searchTerm);

        // TODO: Display results of search on the same page, underneath the search field

        return "search";
    }
}
