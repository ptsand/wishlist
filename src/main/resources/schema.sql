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

