CREATE TABLE wishlist
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(127) NOT NULL
);

CREATE TABLE wish
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(127) NOT NULL,
    url VARCHAR(255)
);

-- Many to Many
CREATE TABLE wishlist_wish
(
    wl_id INT NOT NULL,
    w_id INT NOT NULL,
    PRIMARY KEY (wl_id, w_id),
    FOREIGN KEY (wl_id) REFERENCES wishlist(id),
    FOREIGN KEY (w_id) REFERENCES wish(id)
);

CREATE TABLE user
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(127) NOT NULL,
    email VARCHAR(127) NOT NULL,
    username VARCHAR(127) NOT NULL,
    password VARCHAR(127) NOT NULL
);

CREATE TABLE user_relation
(
    user1_id INT NOT NULL,
    user2_id INT NOT NULL,
    PRIMARY KEY (user1_id, user2_id),
    FOREIGN KEY (user1_id) REFERENCES user(id),
    FOREIGN KEY (user2_id) REFERENCES user(id)
);
