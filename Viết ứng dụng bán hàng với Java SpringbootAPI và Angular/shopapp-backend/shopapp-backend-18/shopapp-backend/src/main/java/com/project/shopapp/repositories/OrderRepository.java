package com.project.shopapp.repositories;

import com.project.shopapp.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Tìm các đơn hàng của 1 user nào đó
    List<Order> findByUserId(Long userId);
    @Query("SELECT o FROM Order o WHERE o.active = true AND (:keyword IS NULL OR :keyword = '' OR " +
            "o.fullName LIKE %:keyword% " +
            "OR o.address LIKE %:keyword% " +
            "OR o.note LIKE %:keyword% " +
            "OR o.email LIKE %:keyword%)")
    Page<Order> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
/*
INSERT INTO orders (user_id, fullname, email, phone_number, address, note, status, total_money)
VALUES
    (2, 'John Smith', 'john@example.com', '1234567890', '123 Main St', 'Note 1', 'pending', 500),
    (5, 'Eric Thompson', 'eric@example.com', '9876543210', '456 Elm St', 'Note 2', 'pending', 400),
    (2, 'Hans', 'hans@example.com', '5555555555', '789 Oak St', 'Note 3', 'pending', 300),
    (5, 'Alice Johnson', 'alice@example.com', '5551234567', '789 Cherry Ave', 'Note 4', 'pending', 200),
    (2, 'Robert Williams', 'robert@example.com', '5559876543', '321 Maple Rd', 'Note 5', 'pending', 100),
    (2, 'Sarah Davis', 'sarah@example.com', '5554445555', '987 Elm St', 'Note 6', 'pending', 250),
    (5, 'Michael Anderson', 'michael@example.com', '5556667777', '654 Oak Ave', 'Note 7', 'pending', 350),
    (2, 'Emma Wilson', 'emma@example.com', '5558889999', '789 Maple Ln', 'Note 8', 'pending', 450),
    (2, 'Olivia Brown', 'olivia@example.com', '5551112222', '987 Pine St', 'Note 47', 'pending', 350),
    (5, 'William Davis', 'william@example.com', '5553334444', '654 Elm Ave', 'Note 48', 'pending', 250),
    (2, 'Sophia Wilson', 'sophia@example.com', '5555556666', '789 Oak Ln', 'Note 49', 'pending', 150),
    (5, 'Alexander Anderson', 'alexander@example.com', '5557778888', '456 Maple Lane', 'Note 50', 'pending', 450),
    (2, 'Ava Thompson', 'ava@example.com', '5559990000', '987 Walnut Rd', 'Note 51', 'pending', 550),
    (5, 'Daniel Johnson', 'daniel@example.com', '5552223333', '654 Pine Ave', 'Note 52', 'pending', 650),
    (2, 'Mia Williams', 'mia@example.com', '5554445555', '789 Elm St', 'Note 53', 'pending', 750),
    (5, 'James Davis', 'james@example.com', '5556667777', '456 Oak Ave', 'Note 54', 'pending', 850),
    (5, 'Benjamin Thompson', 'benjamin@example.com', '5550001111', '654 Walnut Rd', 'Note 56', 'pending', 550),
    (2, 'Sophia Anderson', 'sophia@example.com', '5551112222', '987 Pine St', 'Note 57', 'pending', 350),
    (5, 'Elijah Davis', 'elijah@example.com', '5553334444', '654 Elm Ave', 'Note 58', 'pending', 250),
    (2, 'Ava Wilson', 'ava@example.com', '5555556666', '789 Oak Ln', 'Note 59', 'pending', 150),
    (5, 'Oliver Thompson', 'oliver@example.com', '5557778888', '456 Maple Lane', 'Note 60', 'pending', 450),
    (2, 'Mia Johnson', 'mia@example.com', '5559990000', '987 Walnut Rd', 'Note 61', 'pending', 550),
    (5, 'James Williams', 'james@example.com', '5552223333', '654 Pine Ave', 'Note 62', 'pending', 650),
    (2, 'Charlotte Davis', 'charlotte@example.com', '5554445555', '789 Elm St', 'Note 63', 'pending', 750),
    (5, 'Benjamin Wilson', 'benjamin@example.com', '5556667777', '456 Oak Ave', 'Note 64', 'pending', 850),
    (2, 'Amelia Thompson', 'amelia@example.com', '5558889999', '321 Maple Ln', 'Note 65', 'pending', 950),
    (5, 'Henry Johnson', 'henry@example.com', '5550001111', '654 Walnut Rd', 'Note 66', 'pending', 550),
    (5, 'Emily Davis', 'emily@example.com', '5552223333', '456 Walnut Lane', 'Note 46', 'pending', 150);


INSERT INTO order_details (order_id, product_id, price, number_of_products, total_money, color)
VALUES
    -- 100 records with order_id from 14 to 38
    (14, 1, 10.99, 2, 21.98, 'Red'),
    (14, 2, 5.99, 3, 17.97, 'Blue'),
    (14, 3, 8.49, 1, 8.49, 'Green'),
    (15, 1, 10.99, 2, 21.98, 'Red'),
    (15, 2, 5.99, 3, 17.97, 'Blue'),
    (15, 3, 8.49, 1, 8.49, 'Green'),
    (16, 6, 12.99, 3, 38.97, 'Purple'),
    (17, 7, 6.99, 1, 6.99, 'Pink'),
    (18, 8, 14.99, 2, 29.98, 'Gray'),
    (19, 9, 11.49, 1, 11.49, 'Brown'),
    (20, 10, 8.99, 3, 26.97, 'Black'),
    (21, 11, 13.99, 2, 27.98, 'Silver'),
    (22, 12, 10.49, 1, 10.49, 'Gold'),
    (23, 13, 7.49, 2, 14.98, 'White'),
    (38, 1, 10.99, 2, 21.98, 'Red'),
    (38, 2, 5.99, 3, 17.97, 'Blue'),
    (38, 3, 8.49, 1, 8.49, 'Green'),
    (24, 14, 9.99, 2, 19.98, 'Red'),
    (24, 15, 5.99, 3, 17.97, 'Blue'),
    (24, 16, 8.49, 1, 8.49, 'Green'),
    (25, 17, 10.99, 2, 21.98, 'Yellow'),
    (25, 18, 5.99, 3, 17.97, 'Orange'),
    (25, 19, 8.49, 1, 8.49, 'Purple'),
    (26, 20, 6.99, 2, 13.98, 'Pink'),
    (26, 21, 14.99, 1, 14.99, 'Gray'),
    (26, 22, 11.49, 3, 34.47, 'Brown'),
    (27, 23, 8.99, 2, 17.98, 'Black'),
    (27, 24, 13.99, 1, 13.99, 'Silver'),
    (27, 25, 10.49, 3, 31.47, 'Gold'),
    (28, 26, 7.49, 2, 14.98, 'White'),
    (28, 27, 9.99, 1, 9.99, 'Red'),
    (28, 28, 5.99, 3, 17.97, 'Blue'),
    (29, 29, 8.49, 1, 8.49, 'Green'),
    (29, 30, 10.99, 2, 21.98, 'Yellow'),
    (29, 31, 5.99, 3, 17.97, 'Orange'),
    (30, 32, 8.49, 1, 8.49, 'Purple'),
    (30, 33, 6.99, 2, 13.98, 'Pink'),
    (30, 34, 14.99, 1, 14.99, 'Gray'),
    (31, 35, 11.49, 3, 34.47, 'Brown'),
    (31, 36, 8.99, 2, 17.98, 'Black'),
    (31, 37, 13.99, 1, 13.99, 'Silver'),
    (32, 38, 10.49, 3, 31.47, 'Gold'),
    (32, 39, 7.49, 2, 14.98, 'White'),
    (32, 40, 9.99, 1, 9.99, 'Red'),
    (33, 41, 5.99, 3, 17.97, 'Blue'),
    (33, 42, 8.49, 1, 8.49, 'Green'),
    (33, 43, 10.99, 2, 21.98, 'Yellow'),
    (34, 44, 5.99, 3, 17.97, 'Orange'),
    (34, 45, 8.49, 1, 8.49, 'Purple'),
    (34, 46, 6.99, 2, 13.98, 'Pink'),
    (35, 47, 14.99, 1, 14.99, 'Gray'),
    (35, 48, 11.49, 3, 34.47, 'Brown'),
    (35, 49, 8.99, 2, 17.98, 'Black'),
    (36, 50, 13.99, 1, 13.99, 'Silver'),
    (36, 51, 10.49, 3, 31.47, 'Gold'),
    (36, 52, 7.49, 2, 14.98, 'White'),
    (37, 53, 9.99, 1, 9.99, 'Red'),
    (37, 54, 5.99, 3, 17.97, 'Blue');
* */
