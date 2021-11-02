package com.example.wishlist.repositories;

import com.example.wishlist.models.WishList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WishListRepository {

    @Select("select * from wish_lists")
    public List<WishList> findAll();

}
