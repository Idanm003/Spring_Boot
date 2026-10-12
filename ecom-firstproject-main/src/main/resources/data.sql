INSERT INTO customer (first_name, last_name, email, customer_status)
VALUES ('Idan', 'Magen', 'example@example.com', 'VIP'),
       ('Dana', 'Shahar', 'example2@example.com', 'VIP'),
       ('Nadia', 'Levi', 'example3@example.com', 'VIP'),
       ('Tom', 'Cohen', 'example4@example.com', 'VIP'),
       ('Dana', 'Dahan', 'example5@example.com', 'VIP');

INSERT INTO customer_order(customer_id, item_name, price)
VALUES (1, 'Basketball', 30.00),
       (1, 'Samsung phone', 1999.99),
       (2, 'Iphone phone', 2999.99),
       (2, 'Chair', 1589.99)