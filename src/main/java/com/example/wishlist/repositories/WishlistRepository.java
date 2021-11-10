package com.example.wishlist.repositories;

import com.example.wishlist.models.WishModel;
import com.example.wishlist.models.WishlistModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

// This interface defines the ORM (Object relational mapping) of wishlists.
// MyBatis (https://mybatis.org/mybatis-3/index.html) provides the implementation
// of this interface.

@Mapper
public interface WishlistRepository {

    @Select("SELECT * FROM wishlist")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="wishes", javaType=List.class, column="id",
                    many=@Many(select="findWishesByWishlistId"))})
    List<WishlistModel> findAll();

    @Select("SELECT * FROM wishlist WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="wishes", javaType=List.class, column="id",
                    many=@Many(select="findWishesByWishlistId"))})
    WishlistModel findById(long id);

    @Select("SELECT id, name, url FROM wish JOIN wishlist_wish ON (wish.id = wishlist_wish.w_id) WHERE wl_id = #{id}")
    List<WishModel> findWishesByWishlistId(long id);

    @Delete("DELETE FROM wishlist WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE wishlist SET name=#{name} WHERE id=#{id}")
    int update(WishlistModel wishlistModel);

    @Insert("INSERT INTO wishlist (id, name) VALUES (#{id}, #{name})")
    // Sets the object id to the id generated in database
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertWishlist(WishlistModel wishlistModel);

    //
    @Insert("INSERT INTO wishlist_wish (wl_id, w_id) VALUES (#{wishlist_id}, #{wish_id})")
    void mapWishes(long wishlist_id, long wish_id);
}

