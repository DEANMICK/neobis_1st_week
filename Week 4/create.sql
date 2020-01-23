-- -----------------------------------------------------
-- Schema Cakes_Shoop
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `cake_shop` DEFAULT CHARACTER SET utf8;
USE `cake_shop`;

-- -----------------------------------------------------
-- Table `cake_shop`.`employee`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cake_shop`.`employee` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(50) NOT NULL,
	`Surname` VARCHAR(50) NOT NULL,
	`Phone` VARCHAR(50) NOT NULL,
	`Address` VARCHAR(50) NOT NULL,
	`Age` SMALLINT NOT NULL,
	`Salary` DOUBLE NOT NULL,
	`Position` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`))
	ENGINE = INNODB;


-- -----------------------------------------------------
-- Table `cake_shop`.`cake`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cake_shop`.`cake` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(50) NOT NULL,
	`Size` VARCHAR(50) NOT NULL,
	`Data` DATE NOT NULL,
	`Filling` VARCHAR(50) NOT NULL,
	`employee_id` INT NOT NULL,
	`Price` DOUBLE NOT NULL,
	PRIMARY KEY (`id`, `employee_id`),
	INDEX `fk_cake_employee_index` (`employee_id` ASC),
	CONSTRAINT `fk_cake_employee`
     	FOREIGN KEY (`employee_id`)
     	REFERENCES `cake_shop`.`employee` (`id`)
     	ON DELETE NO ACTION
	 	ON UPDATE NO ACTION)
	ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `cake_shop`.`client`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cake_shop`.`client` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(50) NOT NULL,
	`Phone` VARCHAR(50) NOT NULL,
	`Mail` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`))
	ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `cake_shop`.`order`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cake_shop`.`orders` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`client_id` INT NOT NULL,
	`cake_id` INT NOT NULL,
	`Date` DATE NOT NULL,
	`pay` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`, `client_id`, `cake_id`),
	INDEX `fk_orders_client_index` (`client_id` ASC),
	INDEX `fk_orders_cake_index` (`cake_id` ASC),
	CONSTRAINT `fk_orders_client`
    	FOREIGN KEY (`client_id`)
    	REFERENCES `cake_shop`.`client` (`id`)
    	ON DELETE NO ACTION
    	ON UPDATE NO ACTION,
	CONSTRAINT `fk_orders_cake`
    	FOREIGN KEY (`cake_id`)
 		REFERENCES `cake_shop`.`cake` (`id`)
    	ON DELETE NO ACTION
    	ON UPDATE NO ACTION)
	ENGINE = INNODB;
     
-- -----------------------------------------------------
-- Table `cake_shop`.`sales`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `cake_shop`.`sales` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`cake_id` INT NOT NULL,
	`amount` INT NOT NULL,
	`Date` Date NOT NULL,
	PRIMARY KEY (`id`, `cake_id`),
	INDEX `fk_sales_cake_index` (`cake_id` ASC),
	CONSTRAINT `fk_sales_cake`
		FOREIGN KEY (`cake_id`)
		REFERENCES `cake_shop`.`cake` (`id`)
		ON DELETE NO ACTION
    	ON UPDATE NO ACTION)
	ENGINE = INNODB;
		ON DELETE NO ACTION
    	ON UPDATE NO ACTION)
	ENGINE = INNODB;
	
