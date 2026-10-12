CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name varchar (300) NOT NULL DEFAULT '',
    last_name varchar (300) NOT NULL DEFAULT '',
    email varchar (300) NOT NULL DEFAULT '',
    customer_status varchar (300) NOT NULL DEFAULT 'REGULAR'
);

CREATE TABLE customer_order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    item_name VARCHAR (300) NOT NULL DEFAULT '',
    price DECIMAL(10.2) NOT NULL DEFAULT 00.00,
    CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES customer(id)
);