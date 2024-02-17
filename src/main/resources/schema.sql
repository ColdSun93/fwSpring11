CREATE TABLE IF NOT EXISTS note (
    id INT AUTO_INCREMENT PRIMARY KEY,
    heading varchar(50) NOT NULL,
    content varchar(100) NOT NULL,
    creationDate TIMESTAMP
);