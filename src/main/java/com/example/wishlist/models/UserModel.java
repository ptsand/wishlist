package com.example.wishlist.models;

import com.example.wishlist.validation.ValidPassword;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserModel {

    private int id;

    private List<WishlistModel> wishlists;

    public void setWishlists(List<WishlistModel> wishlists) {
        this.wishlists = wishlists;
    }

    public List<WishlistModel> getWishlists() {
        return wishlists;
    }

    //@NotNull
    @Size(min = 2, max = 100, message= "Name needs to be between 1 and 50 character")
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ValidPassword
    private String password;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}