package com.example.wishlist.models;

import java.util.List;

public class WishList {

    private long id;
    private String name;
    private List<Wish> wishes;

    public WishList(long id, String name, List<Wish> wishes) {
        this.id = id;
        this.name = name;
        this.wishes = wishes;
    }

    public WishList() {
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
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
