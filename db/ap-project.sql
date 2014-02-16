SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ap-project` DEFAULT CHARACTER SET latin1 ;
USE `ap-project` ;

-- -----------------------------------------------------
-- Table `ap-project`.`armband_colours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`armband_colours` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL,
  `value` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap-project`.`armbands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`armbands` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `colour` INT(11) NOT NULL,
  `code` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_armbands_armband_colours1_idx` (`colour` ASC),
  CONSTRAINT `fk_armbands_armband_colours1`
    FOREIGN KEY (`colour`)
    REFERENCES `ap-project`.`armband_colours` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`drink_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`drink_types` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`drinks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`drinks` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` VARCHAR(10) NOT NULL,
  `type` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `fk_drinks_drink_types1_idx` (`type` ASC),
  CONSTRAINT `fk_drinks_drink_types1`
    FOREIGN KEY (`type`)
    REFERENCES `ap-project`.`drink_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`guests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`guests` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `code` VARCHAR(20) NOT NULL,
  `armband_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_guests_armbands1_idx` (`armband_id` ASC),
  CONSTRAINT `fk_guests_armbands1`
    FOREIGN KEY (`armband_id`)
    REFERENCES `ap-project`.`armbands` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `guest_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_guests1_idx` (`guest_id` ASC),
  CONSTRAINT `fk_orders_guests1`
    FOREIGN KEY (`guest_id`)
    REFERENCES `ap-project`.`guests` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`staff_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`staff_roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`staff` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `hours` VARCHAR(20) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_staff_roles_idx` (`role_id` ASC),
  CONSTRAINT `fk_staff_staff_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `ap-project`.`staff_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`orders_has_drinks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`orders_has_drinks` (
  `orders_id` INT(11) NOT NULL,
  `drinks_id` INT(11) NOT NULL,
  PRIMARY KEY (`orders_id`, `drinks_id`),
  INDEX `fk_orders_has_drinks_drinks1_idx` (`drinks_id` ASC),
  INDEX `fk_orders_has_drinks_orders1_idx` (`orders_id` ASC),
  CONSTRAINT `fk_orders_has_drinks_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `ap-project`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_drinks_drinks1`
    FOREIGN KEY (`drinks_id`)
    REFERENCES `ap-project`.`drinks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ap-project`.`staff_has_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap-project`.`staff_has_orders` (
  `staff_id` INT(11) NOT NULL,
  `orders_id` INT(11) NOT NULL,
  PRIMARY KEY (`staff_id`, `orders_id`),
  INDEX `fk_staff_has_orders_orders1_idx` (`orders_id` ASC),
  INDEX `fk_staff_has_orders_staff1_idx` (`staff_id` ASC),
  CONSTRAINT `fk_staff_has_orders_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `ap-project`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_has_orders_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `ap-project`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
