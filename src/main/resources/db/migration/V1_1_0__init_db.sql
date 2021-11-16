CREATE SCHEMA IF NOT EXISTS `car_rental`;

DROP TABLE IF EXISTS `rental_office`;

CREATE TABLE `rental_office` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(45) NOT NULL,
                                 `domain` varchar(45) NOT NULL,
                                 `owner` varchar(45) NOT NULL,
                                 `logotype` varchar(45) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
);
INSERT INTO `rental_office` (name, domain, owner, logotype) VALUES
    ('Bavis','www.bavis.com','Me, myself & I',NULL);

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `address` varchar(45) NOT NULL,
                          `id_rental_office` bigint NOT NULL,
                          PRIMARY KEY (`id`),

                          CONSTRAINT `id_rental_office` FOREIGN KEY (`id_rental_office`) REFERENCES `rental_office` (`id`)
);


INSERT INTO `branch` (address, id_rental_office) VALUES
                         ('Na vlachovce 15, 11150 Praha',1),
                         ('Sedlácká 12, 60200 Brno',1),
                         ('Nová Rožňavská 136, 83104 Bratislava',1);

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name_and_surname` varchar(45) NOT NULL,
                            `position` varchar(45) NOT NULL,
                            `id_branch` bigint NOT NULL,
                            PRIMARY KEY (`id`),

                            CONSTRAINT `id_branch` FOREIGN KEY (`id_branch`) REFERENCES `branch` (`id`)
);

INSERT INTO `employee` (name_and_surname, position, id_branch) VALUES
                           ('Daniel Goldmann','manager',1),
                           ('Jan Podřízený','employee',1),
                           ('Petr Pěšák','employee',1),
                           ('Michal Šlambera','manager',2),
                           ('Bob Klepl','employee',2),
                           ('Jan Kraus','employee',2),
                           ('Ivan Sládeček','manager',3),
                           ('Róbert Fico','employee',3),
                           ('Patrik Vrbovský','employee',3);

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `make` varchar(45) NOT NULL,
                       `model` varchar(45) NOT NULL,
                       `body_type` varchar(45) NOT NULL,
                       `year` int NOT NULL,
                       `color` varchar(45) NOT NULL,
                       `mileage` int NOT NULL,
                       `status` varchar(45) NOT NULL,
                       `amount` int DEFAULT NULL,
                       `car_branch` bigint NOT NULL,
                       PRIMARY KEY (`id`),

                       CONSTRAINT `car_branch` FOREIGN KEY (`car_branch`) REFERENCES `branch` (`id`)
);

INSERT INTO `car` (make, model, body_type, year, color, mileage, status, amount, car_branch) VALUES
                      ('Ford','Focus','hatchback',2018,'blue',78000,'available',70,1),
                      ('BMW','7ixDrive','sedan',2020,'silver',52000,'available',190,1),
                      ('Škoda','Superb','combi',2019,'black',64000,'available',120,1),
                      ('Kia','Ceed','combi',2018,'white',45000,'available',85,2),
                      ('Toyota','Yaris','hatchback',2020,'red',37000,'available',55,2),
                      ('Škoda','Octavia','sedan',2017,'grey',110000,'unavailable',90,2),
                      ('Kia','Ceed','combi',2019,'blue',48000,'available',85,3),
                      ('Toyota','Yaris','hatchback',2020,'silver',29000,'unavailable',55,3),
                      ('Škoda','Octavia','sedan',2021,'green',15000,'available',90,3);

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) NOT NULL,
                            `last_name` varchar(45) NOT NULL,
                            `email` varchar(45) NOT NULL,
                            `address` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`)
);

INSERT INTO `customer` (first_name, last_name, email, address) VALUES
                           ('Pepa','Zákazník','pepazak@seznam.cz','Jarní 67, 11150 Praha'),
                           ('Milada','Klientská','milada_kk@gmail.com','Neštovická 50, 61800 Brno'),
                           ('Boris','Kollár','boris_kollar@nrsr.sk','Strmé Vrchy 13, 81300 Bratislava');


DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking`
(
    `id`             bigint  NOT NULL AUTO_INCREMENT,
    `date`           date NOT NULL,
    `id_customer`    bigint  NOT NULL,
    `id_car`         bigint  NOT NULL,
    `booked_from`    date NOT NULL,
    `booked_to`      date NOT NULL,
    `return_branch`  int  NOT NULL,
    `booking_amount` int DEFAULT NULL,
    `rental_branch`  bigint DEFAULT NULL,
    PRIMARY KEY (`id`),

    CONSTRAINT `id_car` FOREIGN KEY (`id_car`) REFERENCES `car` (`id`),
    CONSTRAINT `id_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
    CONSTRAINT `rental_branch` FOREIGN KEY (`rental_branch`) REFERENCES `car` (`id`),
    CONSTRAINT `return_branch` FOREIGN KEY (`return_branch`) REFERENCES `car` (`id`)
);


DROP TABLE IF EXISTS `rental`;

CREATE TABLE `rental` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `id_employee` bigint NOT NULL,
                          `rental_date` date NOT NULL,
                          `id_booking` bigint NOT NULL,
                          `comments` varchar(200) DEFAULT NULL,
                          PRIMARY KEY (`id`),

                          CONSTRAINT `id_booking` FOREIGN KEY (`id_booking`) REFERENCES `booking` (`id`),
                          CONSTRAINT `id_employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
);


DROP TABLE IF EXISTS `return`;

CREATE TABLE `return`
(
    `id`                 bigint  NOT NULL AUTO_INCREMENT,
    `employee_nr`        bigint  NOT NULL,
    `return_date`        date NOT NULL,
    `booking_nr`         bigint  NOT NULL,
    `additional_payment` int          DEFAULT NULL,
    `comments`           varchar(200) DEFAULT NULL,
    PRIMARY KEY (`id`),

    CONSTRAINT `booking_nr` FOREIGN KEY (`booking_nr`) REFERENCES `booking` (`id`),
    CONSTRAINT `employee_nr` FOREIGN KEY (`employee_nr`) REFERENCES `employee` (`id`)
);