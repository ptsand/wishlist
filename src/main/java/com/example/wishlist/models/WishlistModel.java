package com.example.wishlist.models;

import java.util.List;

public class WishlistModel {

    private long id;
    private String name;
    private List<WishModel> wishes;

    public WishlistModel(long id, String name, List<WishModel> wishes) {
        this.id = id;
        this.name = name;
        this.wishes = wishes;
    }

    public WishlistModel(String name) {
        this.name = name;
    }

    public WishlistModel() {
    }

    public List<WishModel> getWishes() {
        return wishes;
    }

    public void setWishes(List<WishModel> wishes) {
        this.wishes = wishes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
