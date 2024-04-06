-- versioned migrations
ALTER TABLE categories MODIFY name VARCHAR(50) UNIQUE;
-- Chuyển trường price thành decimal
ALTER TABLE products MODIFY price DECIMAL(10,2);

-- Sửa trường thumbnail thành độ dài 255
ALTER TABLE products MODIFY thumbnail VARCHAR(255);

ALTER TABLE `users` MODIFY COLUMN `phone_number` VARCHAR(15);
ALTER TABLE `users` MODIFY COLUMN `password` CHAR(60) NOT NULL;
ALTER TABLE `users` ALTER COLUMN `role_id` SET DEFAULT 1;

ALTER TABLE `order_details` MODIFY COLUMN `price` DECIMAL(10, 2),
    MODIFY COLUMN `number_of_products` INT DEFAULT 1,
    MODIFY COLUMN `total_money` DECIMAL(10, 2) DEFAULT 0;
