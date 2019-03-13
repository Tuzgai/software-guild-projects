DROP DATABASE IF EXISTS simplechat;
CREATE DATABASE simplechat;
USE simplechat;

CREATE TABLE post (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
	`text` VARCHAR(140),
    `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    threadId INT
);

CREATE TABLE thread (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE post
    ADD CONSTRAINT fk_post_id
        FOREIGN KEY (threadId)
        REFERENCES post (id);
        
SELECT * from post;