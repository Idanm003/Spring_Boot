INSERT INTO customer (first_name, last_name, email)
VALUES ('Idan', 'Magen', 'example@example.com'),
       ('Dana', 'Shahar', 'example2@example.com'),
       ('Nadia', 'Levi', 'example3@example.com'),
       ('Tom', 'Cohen', 'example4@example.com'),
       ('Dana', 'Dahan', 'example5@example.com');

INSERT INTO customer_order(item_name, customer_id, price)
VALUES ('Chair', 1, 100);