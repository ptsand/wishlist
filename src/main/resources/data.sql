INSERT INTO wishlist(id, name) VALUES (1,'My Wishlist 1');
INSERT INTO wishlist(id, name) VALUES (2,'My Favorite Wishlist');

INSERT INTO wish(id, name, url) VALUES (1,'My Wish 1','https://myFavorieURL.nowhere');
INSERT INTO wish(id, name, url) VALUES (2,'My Wish 2','https://MyURL1.test');
INSERT INTO wish(id, name, url) VALUES (3,'My Wish 3','https://MyURL2.test');

INSERT INTO wishlist_wish(wl_id, w_id) VALUES (1,1);
INSERT INTO wishlist_wish(wl_id, w_id) VALUES (1,2);

INSERT INTO wishlist_wish(wl_id, w_id) VALUES (2,1);
INSERT INTO wishlist_wish(wl_id, w_id) VALUES (2,2);
INSERT INTO wishlist_wish(wl_id, w_id) VALUES (2,3);

INSERT INTO user(id, name, email, username, password) VALUES (1,'MyName1','MyEmail1','myUsername1', 'myPassword1');
INSERT INTO user(id, name, email, username, password) VALUES (2,'MyName2','MyEmail2','myUsername2', 'myPassword2');
INSERT INTO user(id, name, email, username, password) VALUES (3,'MyName3','MyEmail3','myUsername3', 'myPassword3');


