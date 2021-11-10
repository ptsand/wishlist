package com.example.wishlist.repositories;

import com.example.wishlist.models.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM user")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="email", column="email"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    List<UserModel> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="email", column="email"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    UserModel findById(long id);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE user SET name=#{name} WHERE id=#{id}")
    int updateName(UserModel userModel);

    @Update("UPDATE user SET email=#{email} WHERE id=#{id}")
    int updateEmail(UserModel userModel);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePassword(UserModel userModel);

    @Insert("INSERT INTO user (id, name, email, username, password) VALUES (#{id}, #{name}, #{email}, #{username}, #{password})" )
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(UserModel userModel);

    @Select("SELECT * FROM user WHERE name LIKE #{searchTerm}") //LIKE '%#{searchTerm}%' OR username LIKE '%#{searchTerm}%' OR email LIKE '%#{searchTerm}%'")

    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="email", column="email"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
   //@org.apache.ibatis.annotations.
    List<UserModel> searchUser(String searchTerm);
}