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

    @GetMapping("/search")
    public String search(Model model, @Param("searchTerm") String searchTerm) {
        List<UserModel> userList = userService.search(searchTerm);
        model.addAttribute("userList", userList);
        model.addAttribute("searchTerm", searchTerm);
        return "search";
    }

    @PostMapping("/create")
    public String create(@Param("friendId") long friendId){
        var loggedInUserId = getCurrentUserId();
        userService.createRelation(loggedInUserId, friendId);

        //go to a page that shows current friend list
        return "index";
    }

    private long getCurrentUserId() {
        //TODO: return id for currently logged in user
        return 1;
    }
}
