package com.example.wishlist.repositories;

import com.example.wishlist.models.Wish;
import com.example.wishlist.models.WishList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WishListRepository {

    @Select("SELECT * FROM wishlist")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="wishes", javaType=List.class, column="id",
                    many=@Many(select="findWishesByWishListId"))})
    List<WishList> findAll();

    @Select("SELECT id, name, url FROM wish JOIN wishlist_wish ON (wish.id = wishlist_wish.w_id) WHERE wl_id = #{id}")
    List<Wish> findWishesByWishListId(long id);

    @Select("SELECT * FROM wishlist WHERE id = #{id}")
    WishList findById(long id);

    @Delete("DELETE FROM wishlist WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE wishlist SET name=#{name} WHERE id=#{id}")
    int update(WishList wishList);

    @Insert("INSERT INTO wishlist (id, name, user_id) VALUES (#{id}, #{name}, #{userId})")
    // Sets the object id to the id generated in database
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertWishList(WishList wishList);
}

