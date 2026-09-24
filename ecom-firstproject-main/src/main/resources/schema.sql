CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name varchar (300) NOT NULL DEFAULT '',
    last_name varchar (300) NOT NULL DEFAULT '',
    email varchar (300) NOT NULL DEFAULT ''
);

CREATE TABLE customer_order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    item_name varchar (300) NOT NULL DEFAULT '',
    price INT NOT NULL DEFAULT 0,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);