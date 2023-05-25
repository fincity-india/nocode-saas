use security;

CREATE TABLE IF NOT EXISTS `security_app_package` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	
    CLIENT_ID BIGINT UNSIGNED NOT NULL COMMENT 'Client ID for which this APP PACKAGE relation belongs to',
    APP_ID BIGINT UNSIGNED NOT NULL COMMENT 'App ID for which this APP belongs to',
	PACKAGE_ID BIGINT UNSIGNED NOT NULL COMMENT 'Package ID',
	
	PRIMARY KEY (ID),
	UNIQUE KEY (CLIENT_ID, APP_ID, PACKAGE_ID),
    CONSTRAINT FK1_APP_PCK_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES security_client (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK2_APP_PCK_APP_ID FOREIGN KEY (APP_ID) REFERENCES security_app (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK3_APP_PCK_PCK_ID FOREIGN KEY (PACKAGE_ID) REFERENCES security_package (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `security_app_user_role` (
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
	
    CLIENT_ID BIGINT UNSIGNED NOT NULL COMMENT 'Client ID for which this APP PACKAGE relation belongs to',
    APP_ID BIGINT UNSIGNED NOT NULL COMMENT 'App ID for which this APP belongs to',
	ROLE_ID BIGINT UNSIGNED NOT NULL COMMENT 'Role ID',
	
	PRIMARY KEY (ID),
	UNIQUE KEY (CLIENT_ID, APP_ID, ROLE_ID),
    CONSTRAINT FK1_APP_UR_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES security_client (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK2_APP_UR_APP_ID FOREIGN KEY (APP_ID) REFERENCES security_app (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK3_APP_UR_ROLE_ID FOREIGN KEY (ROLE_ID) REFERENCES security_role (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;