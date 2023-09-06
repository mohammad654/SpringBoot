--INSERT INTO products (product_name,product_price,barcode) VALUES ('product1', '99', '77');
--INSERT INTO products (product_name,product_price,barcode) VALUES ('product2', '14', '44');
--INSERT INTO products (product_name,product_price,barcode) VALUES ('product3', '22', '33');
--INSERT INTO products (product_name,product_price,barcode) VALUES ('product4', '8', '2');

CREATE TABLE IF NOT EXISTS account (
    accountId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNumber VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
  );

--INSERT INTO account (firstName, lastName, phoneNumber, email, password, role)
--VALUES ('Cor', 'Doe', '111', 'johndoe@example.com', 'password123', 'user');
--VALUES ('tes', 'ja', '32423', 'ertere@example.com', 'passworderte3', 'admin');
