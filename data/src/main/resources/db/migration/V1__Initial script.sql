/* Creating Database */

-- DROP DATABASE IF EXISTS `data`;

CREATE DATABASE IF NOT EXISTS `data` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `data`;

CREATE TABLE IF NOT EXISTS `data`.`data_connection` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	CLIENT_CODE CHAR(8) NOT NULL COMMENT 'Client code',
	APP_CODE CHAR(64) NOT NULL COMMENT 'Application code',
	DB_NAME CHAR(64) NOT NULL COMMENT 'Name of the database',
	DB_TYPE ENUM('MYSQL', 'MONGO') NOT NULL DEFAULT ('MYSQL') COMMENT 'Data base type to store the data',
	DB_CONNECTION JSON DEFAULT NULL COMMENT 'JSON connection details',
	DEFAULT_DB TINYINT NOT NULL DEFAULT 0 COMMENT 'Default db connection for all the data',
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
	UNIQUE KEY UK1_DATA_CONN (CLIENT_CODE, APP_CODE, DB_NAME)
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `data`.`data_storage` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	CLIENT_CODE CHAR(8) NOT NULL COMMENT 'Client code',
	APP_CODE CHAR(64) NOT NULL COMMENT 'Application code',
	NAMESPACE CHAR(64) NOT NULL COMMENT 'Namespace',
	NAME CHAR(32) NOT NULL COMMENT 'Name',
	DB_NAME CHAR(64) DEFAULT NULL COMMENT 'Database name where the data is stored',
    IS_VERSIONED TINYINT NOT NULL DEFAULT 0 COMMENT 'Versioned if it is true',
    IS_AUDITED TINYINT NOT NULL DEFAULT 0 COMMENT 'Audited if it is true',
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
	UNIQUE KEY UK1_DATA_STRG (CLIENT_CODE, APP_CODE, NAMESPACE, NAME)
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `data`.`data_storage_field` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	NAME CHAR(64) NOT NULL COMMENT 'Name of the field',
	TYPE ENUM('INTEGER', 'LONG', 'FLOAT', 'DOUBLE', 'STRING', 'OBJECT', 'ARRAY', 'BOOLEAN', 'REF') NOT NULL COMMENT 'Data type of the field',
	SIZE SMALLINT UNSIGNED DEFAULT NULL,
	STORAGE_ID BIGINT UNSIGNED NOT NULL COMMENT 'Storage id to which this field belong',
    DEFAULT_VALUE TEXT DEFAULT NULL,
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
	UNIQUE KEY UK1_DATA_STRG_FLD (STORAGE_ID, NAME),
	CONSTRAINT FK1_STRG_FLD_STRG_ID FOREIGN KEY (STORAGE_ID) REFERENCES data_storage (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `data`.`data_storage_ref_field` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	STORAGE_FIELD_ID BIGINT UNSIGNED NOT NULL COMMENT 'Storage field id info',
    REF_STORAGE_ID BIGINT UNSIGNED NOT NULL COMMENT 'Storage reference',
    REF_TYPE ENUM ('CASCADE', 'RESTRICT', 'SETNULL') NOT NULL DEFAULT 'CASCADE' COMMENT 'Reference type',  
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
	UNIQUE KEY UK1_DATA_STRG_REF_FLD (STORAGE_FIELD_ID),
	CONSTRAINT FK1_STRG_REF_FLD_STRG_FLD_ID FOREIGN KEY (STORAGE_FIELD_ID) REFERENCES data_storage_field (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT FK1_STRG_REF_FLD_STRG_ID FOREIGN KEY (REF_STORAGE_ID) REFERENCES data_storage (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `data`.`data_storage_activity` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	STORAGE_ID BIGINT UNSIGNED NOT NULL COMMENT 'Storage id to which this field belong',
	OPERATION TEXT DEFAULT NULL COMMENT 'The operation to be done on the database',
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
    CONSTRAINT FK1_STRG_ACT_STRG_ID FOREIGN KEY (STORAGE_ID) REFERENCES data_storage (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `data`.`data_client_activity` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	CLIENT_CODE CHAR(8) NOT NULL COMMENT 'Client code',
	ACTIVITY_ID BIGINT UNSIGNED NOT NULL COMMENT 'Activity ID applied',
	STATUS ENUM ('ERROR','COMPLETED') NOT NULL DEFAULT 'ERROR' COMMENT 'Status of the activity',
	ERROR TEXT DEFAULT NULL COMMENT 'Error message while perfoming the activity',
	CREATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who created this row',
	CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when this row is created',
	UPDATED_BY BIGINT UNSIGNED DEFAULT NULL COMMENT 'ID of the user who updated this row',
	UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when this row is updated',
	PRIMARY KEY (ID),
    UNIQUE KEY UK1_DATA_CLNT_ACT (CLIENT_CODE, ACTIVITY_ID),
	CONSTRAINT FK1_CLNT_ACT_STRG_ACT FOREIGN KEY (ACTIVITY_ID) REFERENCES data_storage_activity (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

ALTER TABLE `data`.`data_storage` 
ADD COLUMN `CREATE_AUTH` VARCHAR(512) NULL AFTER `IS_AUDITED`,
ADD COLUMN `READ_AUTH` VARCHAR(512) NULL AFTER `CREATE_AUTH`,
ADD COLUMN `UPDATE_AUTH` VARCHAR(512) NULL AFTER `READ_AUTH`,
ADD COLUMN `DELETE_AUTH` VARCHAR(512) NULL AFTER `UPDATE_AUTH`;

ALTER TABLE `data`.`data_storage`
ADD COLUMN `INTERNAL_NAME` CHAR(64) NOT NULL AFTER `UPDATED_AT`,
CHANGE COLUMN `CREATE_AUTH` `CREATE_AUTH` VARCHAR(512) NULL DEFAULT NULL COMMENT 'Authorization expression for creating a row' ,
CHANGE COLUMN `READ_AUTH` `READ_AUTH` VARCHAR(512) NULL DEFAULT NULL COMMENT 'Authorization expression for reading a row' ,
CHANGE COLUMN `UPDATE_AUTH` `UPDATE_AUTH` VARCHAR(512) NULL DEFAULT NULL COMMENT 'Authorization expression for updating a row' ,
CHANGE COLUMN `DELETE_AUTH` `DELETE_AUTH` VARCHAR(512) NULL DEFAULT NULL COMMENT 'Authorization expression for deleting a row';

ALTER TABLE `data`.`data_storage` 
ADD COLUMN `STATUS` ENUM('ACTIVE', 'READONLY', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE' AFTER `INTERNAL_NAME`,
CHANGE COLUMN `INTERNAL_NAME` `INTERNAL_NAME` CHAR(64) NOT NULL AFTER `DELETE_AUTH`;

ALTER TABLE `data`.`data_storage_field` 
ADD COLUMN `REF_STORAGE_FIELD_ID` BIGINT UNSIGNED NULL DEFAULT NULL AFTER `DEFAULT_VALUE`,
CHANGE COLUMN `TYPE` `TYPE` ENUM('INTEGER', 'LONG', 'FLOAT', 'DOUBLE', 'STRING', 'OBJECT', 'ARRAY', 'BOOLEAN', 'REF', 'DATE', 'TIMESTAMP') NOT NULL COMMENT 'Data type of the field',

ADD CONSTRAINT `FK2_STRG_FLD_STRG_FILD`
  FOREIGN KEY (`ID`)
  REFERENCES `data`.`data_storage_field` (`STORAGE_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `data`.`data_storage_field` DROP FOREIGN KEY `FK2_STRG_FLD_STRG_FILD`;

ALTER TABLE `data`.`data_storage_field` 
ADD INDEX `FK2_STRG_FLD_STRG_FILD_idx` (`REF_STORAGE_FIELD_ID` ASC) VISIBLE;

ALTER TABLE `data`.`data_storage_field` 
ADD CONSTRAINT `FK2_STRG_FLD_STRG_FILD` FOREIGN KEY (`REF_STORAGE_FIELD_ID`) REFERENCES `data`.`data_storage_field` (`ID`);

DROP TABLE `data`.`data_storage_ref_field`;

ALTER TABLE `data`.`data_storage`
CHANGE COLUMN `STATUS` `STATUS` ENUM('ACTIVE', 'READONLY', 'INACTIVE', 'DELETED') NOT NULL DEFAULT 'ACTIVE';

ALTER TABLE `data`.`data_storage` DROP INDEX `UK1_DATA_STRG` ;

