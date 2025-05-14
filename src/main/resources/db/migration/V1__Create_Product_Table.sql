CREATE SCHEMA IF NOT EXISTS arka;

CREATE TABLE `proyectarka`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` CHAR(36) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `sku` VARCHAR(45) NULL,
  `quantity` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
