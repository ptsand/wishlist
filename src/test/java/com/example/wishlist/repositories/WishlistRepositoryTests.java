package com.example.wishlist.repositories;

import com.example.wishlist.models.WishModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import com.example.wishlist.models.WishlistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")  // Use test database url from application-test.properties
// Do not autoconfigure an in memory db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
public class WishlistRepositoryTests {

    @Autowired
    private WishlistRepository wishlistRepos;

    @Autowired
    private WishRepository wishRepos;

    @Test
    public void insertEmptyWishlist() {
        final WishlistModel model = new WishlistModel("TestWishlist");
        wishlistRepos.insertWishlist(model);

        assertFalse(model.getId() == 0); // Check for generated id
        assertEquals("TestWishlist", model.getName());
    }

    @Test
    public void addWishToWishlist() {
        final WishlistModel model = new WishlistModel("TestWishlist");
        WishModel wish = new WishModel("MySingleWish","https://bla.test");
        // model.setWishes(wishes);
        wishlistRepos.insertWishlist(model);
        wishRepos.insertWish(wish);
        WishlistModel retrieveEmptyWishlist = wishlistRepos.findById(model.getId());
        assertTrue(retrieveEmptyWishlist.getWishes().isEmpty());
        wishlistRepos.mapWishes(model.getId(), wish.getId());
        wishlistRepos.mapWishes(model.getId(), wish.getId());
        WishlistModel retrievedWishlistWithOneWish = wishlistRepos.findById(model.getId());
        assertFalse(retrievedWishlistWithOneWish.getWishes().isEmpty());
        assertTrue(retrievedWishlistWithOneWish.getWishes().size() == 1);
    }
    @Test
    public void addWishToWishlistShouldThrowException() {
        final WishlistModel model = new WishlistModel("TestWishlist");
        WishModel wish = new WishModel("MySingleWish","https://bla.test");
        wishlistRepos.insertWishlist(model);
        wishRepos.insertWish(wish);
        WishlistModel retrieveEmptyWishlist = wishlistRepos.findById(model.getId());
        assertTrue(retrieveEmptyWishlist.getWishes().isEmpty());
        wishlistRepos.mapWishes(model.getId(), wish.getId());
        Exception exception = assertThrows(DuplicateKeyException.class, () -> {
            wishlistRepos.mapWishes(model.getId(), wish.getId());
        });
        WishlistModel retrievedWishlistWithOneWish = wishlistRepos.findById(model.getId());
        assertFalse(retrievedWishlistWithOneWish.getWishes().isEmpty());
        assertTrue(retrievedWishlistWithOneWish.getWishes().size() == 1);
    }

    @Test
    public void findByIdShouldReturnWishlistModel() {
        assertTrue(wishlistRepos.findAll().isEmpty());
        final WishlistModel newModel = new WishlistModel("TestWishlist");
        wishlistRepos.insertWishlist(newModel);
        // retrieve wishlist by generated id
        WishlistModel retrievedModel = wishlistRepos.findById(newModel.getId());
        // assert
        assertTrue(newModel instanceof WishlistModel);
        assertEquals(newModel.getId(), retrievedModel.getId());
        assertEquals("TestWishlist", retrievedModel.getName());
    }

}
