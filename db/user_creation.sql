

-- -----------------------------------------------------
-- Schema basic_people
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `basic_people` ;

-- -----------------------------------------------------
-- Schema basic_people
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basic_people` DEFAULT CHARACTER SET utf8 ;
USE `basic_people` ;


-- -----------------------------------------------------
-- User
-- -----------------------------------------------------
CREATE USER 'speople'@'localhost' IDENTIFIED BY 'all4one';

GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
    ON basic_people.*
    TO 'speople'@'localhost';