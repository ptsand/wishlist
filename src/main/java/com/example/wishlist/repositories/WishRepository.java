package com.example.wishlist.repositories;

import com.example.wishlist.models.WishModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

// This interface defines the ORM (Object relational mapping) of wishes.
// MyBatis (https://mybatis.org/mybatis-3/index.html) provides the implementation
// of this interface.

@Mapper
public interface WishRepository {

    @Select("SELECT * FROM wish")
    List<WishModel> findAll();

    @Select("SELECT * FROM wish WHERE id = #{id}")
    WishModel findById(long id);

    @Delete("DELETE FROM wish WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE wish SET name=#{name} WHERE id=#{id}")
    int update(WishModel wishModel);

    @Insert("INSERT INTO wish (id, name, url) VALUES (#{id}, #{name}, #{url})")
    // Sets the object id to the id generated in database
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertWish(WishModel wishModel);
}