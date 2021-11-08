package com.example.wishlist.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import com.example.wishlist.models.WishlistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
public class WishlistRepositoryTests {

    @Autowired
    private WishlistRepository wishlistRepos;

    @Test
    public void insertEmptyWishlistModel() {
        final WishlistModel model = new WishlistModel("TestWishlist");
        wishlistRepos.insertWishList(model);
        assertFalse(model.getId() == 0); // Check for generated id
        assertEquals("TestWishlist", model.getName());
    }

    @Test
    public void findByIdShouldReturnWishlistModel() {
        final WishlistModel newModel = new WishlistModel("TestWishlist");
        wishlistRepos.insertWishList(newModel);
        // retrieve wishlist
        WishlistModel actual = wishlistRepos.findById(newModel.getId());
        // assert for equality
        assertTrue(newModel instanceof WishlistModel);
        assertEquals(newModel.getId(), actual.getId());
        assertEquals("TestWishlist", actual.getName());
    }

}
