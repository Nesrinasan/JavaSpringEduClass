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

-- -- order tablosu
-- CREATE TABLE IF NOT EXISTS orders (
--
--                                      order_number VARCHAR(255) NOT NULL,
--                                      total_amount DOUBLE NOT NULL
--
-- );

create table student
(
    NO integer not null,
    NAME varchar(255) not null
);