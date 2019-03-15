DROP DATABASE IF EXISTS superheroes;
CREATE DATABASE superheroes;
USE superheroes;

CREATE TABLE `super` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140) NOT NULL,
    isvillain BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE superorganization (
	superId INT NOT NULL,
    organizationid INT NOT NULL
);

CREATE TABLE `organization` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140),
    addressid INT NOT NULL
); 

CREATE TABLE ADDRESS (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140),
    streetaddress VARCHAR(50),
    territory VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    postalcode VARCHAR(10),
    latitude DECIMAL(8, 6),
    longitude DECIMAL(9, 6)
);

CREATE TABLE sighting (
	id INT PRIMARY KEY AUTO_INCREMENT,
    addressid INT NOT NULL,
    `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE supersighting (
	superid INT,
    sightingid INT
);

ALTER TABLE superorganization
    ADD CONSTRAINT fk_superorganization_super
        FOREIGN KEY (superid)
        REFERENCES `super` (id),
	ADD CONSTRAINT fk_superorganization_organization
		FOREIGN KEY (organizationid)
		REFERENCES `organization` (id);
        
ALTER TABLE `organization`
	ADD CONSTRAINT fk_organization_address
		FOREIGN KEY (addressid)
        REFERENCES address (id);
        
ALTER TABLE sighting
	ADD CONSTRAINT fk_sighting_address
		FOREIGN KEY (addressid)
		REFERENCES address (id);
        
ALTER TABLE supersighting
	ADD CONSTRAINT fk_supersighting_super
		FOREIGN KEY (superid)
        REFERENCES `super` (id),
	ADD CONSTRAINT fk_supersighting_sighting
		FOREIGN KEY (sightingid)
		REFERENCES sighting (id);