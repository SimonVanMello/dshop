USE Dshop;

CREATE TABLE Products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE(15, 2) NOT NULL,
    quantity INT NOT NULL,
	img VARCHAR(512) NOT NULL,
    PRIMARY KEY (id)
);