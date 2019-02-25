DROP DATABASE IF EXISTS Hotel;
CREATE DATABASE Hotel;
USE Hotel;

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    PHONE CHAR(10),
    EMAIL VARCHAR(45)
);

CREATE TABLE Guest (
    GuestID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    BirthDate DATE NOT NULL,
    ReservationID INT NOT NULL
);

CREATE TABLE CustomerReservation (
    CustomerID INT NOT NULL,
    ReservationID INT NOT NULL
);

CREATE TABLE Reservation (
    ReservationID INT PRIMARY KEY AUTO_INCREMENT,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    PromoCodeID INT
);

CREATE TABLE PromoCode (
    PromoCodeID INT PRIMARY KEY AUTO_INCREMENT,
    StartDate DATE,
    EndDate DATE,
    DiscountPercent DECIMAL(2,2),
    DiscountFlat DECIMAL(10,4)
);

CREATE TABLE Bill (
    ReservationID INT PRIMARY KEY AUTO_INCREMENT,
    TaxRate DECIMAL(7,4) NOT NULL DEFAULT 0.0,
    Total DECIMAL(10,4) NOT NULL,
    NumberGuests INT NOT NULL,
    NumberRooms INT NOT NULL
);

CREATE TABLE BillLineItem (
    BillLineItemID INT PRIMARY KEY AUTO_INCREMENT,
    BillID INT NOT NULL,
    ItemName VARCHAR(40),
    ItemPrice DECIMAL(10,4)
);

CREATE TABLE RoomReservation (
    RoomID INT NOT NULL,
    ReservationID INT NOT NULL
);

CREATE TABLE RoomAddOn (
    RoomID INT NOT NULL,
    AddOnID INT NOT NULL
);

CREATE TABLE AddOn (
    AddOnID INT PRIMARY KEY AUTO_INCREMENT,
    StartDate Date NOT NULL,
    EndDate Date NOT NULL,
    `Name` VARCHAR(45) NOT NULL,
    Price DECIMAL(10,4) NOT NULL
);

CREATE TABLE RoomAmenity (
    AmenityID INT NOT NULL,
    RoomID INT NOT NULL
);

CREATE TABLE Room (
    RoomID INT PRIMARY KEY AUTO_INCREMENT,
    RoomNumber INT NOT NULL,
    `Floor` INT NOT NULL,
    Occupancy INT NOT NULL
);

CREATE TABLE RoomType (
    RoomID INT NOT NULL,
    TypeID INT NOT NULL
);

CREATE TABLE Amenity (
    AmenityID INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(45) NOT NULL
);

CREATE TABLE RateType (
    RateID INT NOT NULL,
    TypeID INT NOT NULL,
    Price DECIMAL(10,4) NOT NULL
);

CREATE TABLE `Type` (
    TypeID INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(45) NOT NULL
);

CREATE TABLE Rate (
    RateID INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(45) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE
);

ALTER TABLE Guest
    ADD CONSTRAINT fk_Guest_Reservation
        FOREIGN KEY (ReservationID)
        REFERENCES Reservation (ReservationID);

ALTER TABLE CustomerReservation
    ADD CONSTRAINT fk_CustomerReservation_Reservation
        FOREIGN KEY (ReservationID)
        REFERENCES Reservation (ReservationID),
    ADD CONSTRAINT fk_CustomerReservation_Customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customer (CustomerID);

ALTER TABLE Reservation
    ADD CONSTRAINT fk_Reservation_PromoCode
        FOREIGN KEY (PromoCodeID)
        REFERENCES PromoCode (PromoCodeID);

ALTER TABLE BillLineItem
    ADD CONSTRAINT fk_BillLineItem_Bill
        FOREIGN KEY (BillID)
        REFERENCES Bill (ReservationID);

ALTER TABLE RoomReservation
    ADD CONSTRAINT fk_RoomReservation_Room
        FOREIGN KEY (RoomID)
        REFERENCES Room (RoomID),
    ADD CONSTRAINT fk_RoomReservation_Reservation
        FOREIGN KEY (ReservationID)
        REFERENCES Reservation (ReservationID);

ALTER TABLE RoomAddOn
    ADD CONSTRAINT fk_RoomAddOn_Room
        FOREIGN KEY (RoomID)
        REFERENCES Room (RoomID),
    ADD CONSTRAINT fk_RoomAddon_AddOn
        FOREIGN KEY (AddOnID)
        REFERENCES AddOn (AddOnID);

ALTER TABLE RoomAmenity 
    ADD CONSTRAINT fk_RoomAmenity_Amenity
        FOREIGN KEY (AmenityID)
        REFERENCES Amenity (AmenityID),
    ADD CONSTRAINT fk_RoomAmenity_Room
        FOREIGN KEY (RoomID)
        REFERENCES Room (RoomID);

ALTER TABLE RoomType
    ADD CONSTRAINT fk_RoomType_Room
        FOREIGN KEY (RoomID)
        REFERENCES Room (RoomID),
    ADD CONSTRAINT fk_RoomType_Type
        FOREIGN KEY (TypeID)
        REFERENCES `Type` (TypeID);

ALTER TABLE RateType
    ADD CONSTRAINT fk_RateType_Type
        FOREIGN KEY (TypeID)
        REFERENCES `Type` (TypeID),
    ADD CONSTRAINT fk_RateType_Rate
        FOREIGN KEY (RateID)
        REFERENCES Rate (RateID);