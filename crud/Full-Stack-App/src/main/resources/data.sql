-- data.sql

--CREATE DATABASE IF NOT EXISTS restaurant_app;

-- CREATE account
CREATE TABLE IF NOT EXISTS account (
    accountId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNumber VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
  );

-- INSERT account
--INSERT INTO account (first_name, last_name, phone_number, email, password, role)
--VALUES
--  ('John', 'Doe', '1234567890', 'john.doe@example.com', 'password1', 'User'),
--  ('Jane', 'Smith', '9876543210', 'jane.smith@example.com', 'password2', 'Admin'),
--  ('Michael', 'Johnson', '5551234567', 'michael.johnson@example.com', 'password3', 'User'),
--  ('Emily', 'Brown', '7890123456', 'emily.brown@example.com', 'password4', 'Admin'),
--  ('David', 'Wilson', '4567890123', 'david.wilson@example.com', 'password5', 'User'),
--  ('Emma', 'Davis', '9012345678', 'emma.davis@example.com', 'password6', 'Admin'),
--  ('Daniel', 'Miller', '2345678901', 'daniel.miller@example.com', 'password7', 'User'),
--  ('Olivia', 'Anderson', '5678901234', 'olivia.anderson@example.com', 'password8', 'Admin'),
--  ('William', 'Taylor', '0123456789', 'william.taylor@example.com', 'password9', 'User'),
--  ('Sophia', 'Thomas', '3456789012', 'sophia.thomas@example.com', 'password10', 'Admin');

--CREATE customer
CREATE TABLE IF NOT EXISTS customer (
  customerId INT PRIMARY KEY AUTO_INCREMENT,
  paymentId INT,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  phoneNumber VARCHAR(255),
  email VARCHAR(255),
  address VARCHAR(255),
  isGuest BOOLEAN
);
--INSERT customer
--INSERT INTO customer (paymentId, firstName, lastName, phoneNumber, email, address, isGuest) VALUES
--(101, 'John', 'Doe', '1234567890', 'john.doe@example.com', '123 Main St', false),
--(102, 'Jane', 'Smith', '9876543210', 'jane.smith@example.com', '456 Elm St', false),
--(103, 'Michael', 'Johnson', '5555555555', 'michael.johnson@example.com', '789 Oak Ave', false),
--(104, 'Emily', 'Davis', '9999999999', 'emily.davis@example.com', '321 Maple Dr', true),
--(105, 'David', 'Brown', '4444444444', 'david.brown@example.com', '567 Pine Rd', false);
