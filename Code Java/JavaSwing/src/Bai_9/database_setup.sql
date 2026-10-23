-- Create and setup database for Product Management System
-- Drop existing database if exists
DROP DATABASE IF EXISTS product;

-- Create new database
CREATE DATABASE product;

-- Use the database
USE product;

-- Create category table first (referenced by products)
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Create products table
CREATE TABLE products (
    id INT PRIMARY KEY,
    productName VARCHAR(100),
    unitPrice FLOAT,
    quantity INT,
    description VARCHAR(200),
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES category(id)
);

-- Insert sample categories
INSERT INTO category(name) VALUES
('Mặt hàng điện tử'),
('Mặt hàng hóa chất'),
('Mặt hàng gia dụng'),
('Mặt hàng thực phẩm');

-- Verify data
SELECT * FROM category;
SELECT * FROM products;

