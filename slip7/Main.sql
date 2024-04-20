CREATE TABLE Product(Pid INT PRIMARY KEY, Pname VARCHAR(100), Price DECIMAL(10,
2));
INSERT INTO Product VALUES(1, 'Product 1', 10.99);
INSERT INTO Product VALUES(2, 'Product 2', 20.99);
INSERT INTO Product VALUES(3, 'Product 3', 30.99);
INSERT INTO Product VALUES(4, 'Product 4', 40.99);
INSERT INTO Product VALUES(5, 'Product 5', 50.99);
SELECT * FROM Product;
