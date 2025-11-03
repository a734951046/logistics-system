-- Schema for orders table
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    quantity INT
);
