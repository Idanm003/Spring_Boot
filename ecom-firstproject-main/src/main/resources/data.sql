INSERT INTO customer (first_name, last_name, email, customer_status)
VALUES ('Idan', 'Magen', 'example@example.com', 'VIP'),
       ('Dana', 'Shahar', 'example2@example.com', 'VIP'),
       ('Nadia', 'Levi', 'example3@example.com', 'VIP'),
       ('Tom', 'Cohen', 'example4@example.com', 'VIP'),
       ('Dana', 'Dahan', 'example5@example.com', 'VIP');

INSERT INTO customer_order(customer_id, item_name, price)
VALUES (1, 'Basketball', 30.00),
       (1, 'Samsung', 22.00),
       (2, 'Iphone', 35.00),
       (4, 'MacBook', 2000.00),
       (5, 'Mouse', 30.00),
       (1, 'keyboard', 30.00);

INSERT INTO person(id, first_name, last_name)
VALUES (1, 'John', 'Cena'),
       (2, 'Joe', 'Dirt'),
       (3, 'Monica', 'Geller'),
       (4, 'Hanna', 'Montana');