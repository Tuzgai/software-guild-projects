DROP DATABASE IF EXISTS herodb;
CREATE DATABASE herodb;
USE herodb;

CREATE TABLE `super` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140),
    isvillain BOOLEAN NOT NULL DEFAULT FALSE,
    powerid INT NOT NULL
);

CREATE TABLE `power` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140)
);

CREATE TABLE super_organization (
	superId INT NOT NULL,
    organizationid INT NOT NULL
);

CREATE TABLE `organization` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140),
    addressid INT NOT NULL
); 

CREATE TABLE address (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `description` VARCHAR(140),
    streetaddress VARCHAR(50),
    territory VARCHAR(30),
    country VARCHAR(30) NOT NULL,
    postalcode VARCHAR(10),
    latitude DECIMAL(8, 6),
    longitude DECIMAL(9, 6),
    city VARCHAR(30)
);

CREATE TABLE sighting (
	id INT PRIMARY KEY AUTO_INCREMENT,
    addressid INT NOT NULL,
    `date` DATE NOT NULL,
    `description` VARCHAR(140)
);

CREATE TABLE super_sighting (
	superid INT,
    sightingid INT
);

ALTER TABLE super_organization
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
        
ALTER TABLE super_sighting
	ADD CONSTRAINT fk_supersighting_super
		FOREIGN KEY (superid)
        REFERENCES `super` (id),
	ADD CONSTRAINT fk_supersighting_sighting
		FOREIGN KEY (sightingid)
		REFERENCES sighting (id);
        
ALTER TABLE `super`
	ADD CONSTRAINT fk_super_power
		FOREIGN KEY (powerid)
        REFERENCES power (id);
        
INSERT INTO `address`(`name`, country, `description`) VALUES ("Location Unknown", "Location Unknown", "Placeholder Location");
INSERT INTO `power`(`name`, `description`) VALUES ("Power Unknown", "Placeholder Power");

INSERT INTO `address`(`name`, city, country, `description`, latitude, longitude)
	VALUES ("U.A. High School", "Tokyo", "Japan", "The top superhero high school.", "35.676200", "139.650300");
    
INSERT INTO `address`(`name`, country, `description`)
	VALUES ("U.S.J", "Japan", "U.A.'s Secret Training Location");

INSERT INTO `power`(`name`, `description`) 
	VALUES 
    ('All For One', 'Being real strong'),
	('Frog', 'Pretty much anything a frog can do.'),
	('Half-Cold Half-Hot', 'Strong Fire and Ice powers'),
    ('All For One', 'Steal powers and combine them');

INSERT INTO `super`(`name`, `description`, isVillain, powerId)
	VALUES 
    ('All Might', 'The Symbol of Peace', false, 2),
    ('Shoto Todoroki', 'A student at U.A', false, 3),
    ('Froppy', 'A student at U.A', false, 4),
    ('All For One', 'The baddest dude around', true, 5);

INSERT INTO `organization`(`name`, `description`, addressId)
	VALUES
    ('U.A High School', 'The top superhero high school', 2),
    ('League of Villains', 'Some bad dudes and dudettes', 1);
    
INSERT INTO super_organization(superid, organizationid)
	VALUES (1, 1), (2, 1), (3, 1), (4, 2);
    
INSERT INTO sighting(addressId, `date`, `description`)
	VALUES
		(2, '2019-03-25', 'A big fight!'),
        (3, '2018-02-17', 'The league of villains attacked!');
        
INSERT INTO super_sighting(superid, sightingid)
	VALUES (1, 1), (2, 1), (4,1), (2,2), (3,2), (4,2);