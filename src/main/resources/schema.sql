-- user tablosu
CREATE TABLE IF NOT EXISTS usertb (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(255) NOT NULL,
                                    email VARCHAR(255) NOT NULL,
                                    password VARCHAR(255) NOT NULL
);

-- product tablosu
CREATE TABLE IF NOT EXISTS producttb (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       description TEXT,
                                       price DECIMAL(10, 2) NOT NULL
);

-- order tablosu
CREATE TABLE IF NOT EXISTS ordertb (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     user_id INT NOT NULL,
                                     product_id INT NOT NULL,
                                     quantity INT NOT NULL,
                                     order_date TIMESTAMP NOT NULL,
                                     FOREIGN KEY (user_id) REFERENCES usertb(id),
                                     FOREIGN KEY (product_id) REFERENCES producttb(id)
);

create table student
(
    NO integer not null,
    NAME varchar(255) not null
);