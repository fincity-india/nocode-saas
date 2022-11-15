/* Creating Database */

-- DROP DATABASE IF EXISTS `files`;

CREATE DATABASE IF NOT EXISTS `files` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `files`;

CREATE TABLE  IF NOT EXISTS `files`.`files_access_path` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	CLIENT_CODE CHAR(8) NOT NULL COMMENT 'Client code',
	USER_ID BIGINT UNSIGNED DEFAULT NULL COMMENT 'USER ID',
    RESOURCE_TYPE ENUM('STATIC', 'SECURED') DEFAULT 'STATIC' COMMENT 'Static or Secured resource',
	ACCESS_NAME VARCHAR(256) DEFAULT NULL COMMENT 'Role or Permission Name',
	WRITE_ACCESS TINYINT DEFAULT 0 COMMENT 'Write access',
	PATH VARCHAR(1024) NOT NULL COMMENT 'Path to the resource',
	ALLOW_SUB_PATH_ACCESS TINYINT DEFAULT 1 COMMENT 'Allow sub paths with same access',
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID))
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;