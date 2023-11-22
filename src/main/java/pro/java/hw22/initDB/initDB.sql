-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS SmartStorage;

-- Switch to the database
USE SmartStorage;

-- Create a table to store data
CREATE TABLE IF NOT EXISTS Storage
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    data VARCHAR(255)
);