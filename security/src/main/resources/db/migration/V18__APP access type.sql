use security;


ALTER TABLE `security`.`security_app` 
DROP COLUMN `IS_TEMPLATE`,
ADD COLUMN `APP_ACCESS_TYPE` ENUM('OWN', 'ANY', 'EXPLICIT') NOT NULL DEFAULT 'OWN' AFTER `APP_TYPE`;


