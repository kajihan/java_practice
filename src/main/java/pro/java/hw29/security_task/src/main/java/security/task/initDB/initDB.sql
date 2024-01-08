CREATE DATABASE IF NOT EXISTS mydatabase;

USE mydatabase;

CREATE TABLE IF NOT EXISTS user
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(20)  NOT NULL
);

INSERT INTO user (username, password, role)
VALUES ('user', '$2a$10$apK.HJy8dmLoCn3F5AdpbOJaHqA2m.G7JZCPotn.Cj1sY/n/b0E1y', 'USER'),
       ('admin', '$2a$10$eZrFmIwtoTqWpWjbeObmCe2w3S3qCqBHTdRvlfJZuvWhd6A0.WufC', 'ADMIN');

CREATE TABLE IF NOT EXISTS product
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cost DOUBLE       NOT NULL
);

INSERT INTO product (name, cost)
VALUES ('Item1', 19.99),
       ('Item2', 29.99);