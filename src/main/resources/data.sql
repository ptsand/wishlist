INSERT INTO wishlist(id, name) VALUES (1,'MyFavoriteWishlist1');
INSERT INTO wishlist(id, name) VALUES (2,'MyFavoriteWishlist2');

INSERT INTO wish(id, name, url) VALUES (1,'MyWish1','http');
INSERT INTO wish(id, name, url) VALUES (2,'MyWish2','MyURL');
INSERT INTO wish(id, name, url) VALUES (3,'MyWish2','MyURL');

INSERT INTO wishlist_wish(wl_id, w_id) VALUES (1,1);
INSERT INTO wishlist_wish(wl_id, w_id) VALUES (1,2);

INSERT INTO wishlist_wish(wl_id, w_id) VALUES (2,3);

