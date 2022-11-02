/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq;


import com.fincity.security.jooq.tables.SecurityApp;
import com.fincity.security.jooq.tables.SecurityClient;
import com.fincity.security.jooq.tables.SecurityClientManage;
import com.fincity.security.jooq.tables.SecurityClientPackage;
import com.fincity.security.jooq.tables.SecurityClientPasswordPolicy;
import com.fincity.security.jooq.tables.SecurityClientType;
import com.fincity.security.jooq.tables.SecurityClientUrl;
import com.fincity.security.jooq.tables.SecurityOrgStructure;
import com.fincity.security.jooq.tables.SecurityPackage;
import com.fincity.security.jooq.tables.SecurityPackageRole;
import com.fincity.security.jooq.tables.SecurityPastPasswords;
import com.fincity.security.jooq.tables.SecurityPermission;
import com.fincity.security.jooq.tables.SecurityRole;
import com.fincity.security.jooq.tables.SecurityRolePermission;
import com.fincity.security.jooq.tables.SecuritySoxLog;
import com.fincity.security.jooq.tables.SecurityUser;
import com.fincity.security.jooq.tables.SecurityUserRolePermission;
import com.fincity.security.jooq.tables.SecurityUserToken;
import com.fincity.security.jooq.tables.records.SecurityAppRecord;
import com.fincity.security.jooq.tables.records.SecurityClientManageRecord;
import com.fincity.security.jooq.tables.records.SecurityClientPackageRecord;
import com.fincity.security.jooq.tables.records.SecurityClientPasswordPolicyRecord;
import com.fincity.security.jooq.tables.records.SecurityClientRecord;
import com.fincity.security.jooq.tables.records.SecurityClientTypeRecord;
import com.fincity.security.jooq.tables.records.SecurityClientUrlRecord;
import com.fincity.security.jooq.tables.records.SecurityOrgStructureRecord;
import com.fincity.security.jooq.tables.records.SecurityPackageRecord;
import com.fincity.security.jooq.tables.records.SecurityPackageRoleRecord;
import com.fincity.security.jooq.tables.records.SecurityPastPasswordsRecord;
import com.fincity.security.jooq.tables.records.SecurityPermissionRecord;
import com.fincity.security.jooq.tables.records.SecurityRolePermissionRecord;
import com.fincity.security.jooq.tables.records.SecurityRoleRecord;
import com.fincity.security.jooq.tables.records.SecuritySoxLogRecord;
import com.fincity.security.jooq.tables.records.SecurityUserRecord;
import com.fincity.security.jooq.tables.records.SecurityUserRolePermissionRecord;
import com.fincity.security.jooq.tables.records.SecurityUserTokenRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * security.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SecurityAppRecord> KEY_SECURITY_APP_PRIMARY = Internal.createUniqueKey(SecurityApp.SECURITY_APP, DSL.name("KEY_security_app_PRIMARY"), new TableField[] { SecurityApp.SECURITY_APP.ID }, true);
    public static final UniqueKey<SecurityAppRecord> KEY_SECURITY_APP_UK1_APPCODE = Internal.createUniqueKey(SecurityApp.SECURITY_APP, DSL.name("KEY_security_app_UK1_APPCODE"), new TableField[] { SecurityApp.SECURITY_APP.APP_CODE }, true);
    public static final UniqueKey<SecurityClientRecord> KEY_SECURITY_CLIENT_PRIMARY = Internal.createUniqueKey(SecurityClient.SECURITY_CLIENT, DSL.name("KEY_security_client_PRIMARY"), new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final UniqueKey<SecurityClientRecord> KEY_SECURITY_CLIENT_UK1_CLIENT_CODE = Internal.createUniqueKey(SecurityClient.SECURITY_CLIENT, DSL.name("KEY_security_client_UK1_CLIENT_CODE"), new TableField[] { SecurityClient.SECURITY_CLIENT.CODE }, true);
    public static final UniqueKey<SecurityClientRecord> KEY_SECURITY_CLIENT_UK2_CLIENT_NAME = Internal.createUniqueKey(SecurityClient.SECURITY_CLIENT, DSL.name("KEY_security_client_UK2_CLIENT_NAME"), new TableField[] { SecurityClient.SECURITY_CLIENT.NAME }, true);
    public static final UniqueKey<SecurityClientManageRecord> KEY_SECURITY_CLIENT_MANAGE_PRIMARY = Internal.createUniqueKey(SecurityClientManage.SECURITY_CLIENT_MANAGE, DSL.name("KEY_security_client_manage_PRIMARY"), new TableField[] { SecurityClientManage.SECURITY_CLIENT_MANAGE.ID }, true);
    public static final UniqueKey<SecurityClientPackageRecord> KEY_SECURITY_CLIENT_PACKAGE_PRIMARY = Internal.createUniqueKey(SecurityClientPackage.SECURITY_CLIENT_PACKAGE, DSL.name("KEY_security_client_package_PRIMARY"), new TableField[] { SecurityClientPackage.SECURITY_CLIENT_PACKAGE.ID }, true);
    public static final UniqueKey<SecurityClientPackageRecord> KEY_SECURITY_CLIENT_PACKAGE_UK1_CLIENT_PACKAGE = Internal.createUniqueKey(SecurityClientPackage.SECURITY_CLIENT_PACKAGE, DSL.name("KEY_security_client_package_UK1_CLIENT_PACKAGE"), new TableField[] { SecurityClientPackage.SECURITY_CLIENT_PACKAGE.CLIENT_ID, SecurityClientPackage.SECURITY_CLIENT_PACKAGE.PACKAGE_ID }, true);
    public static final UniqueKey<SecurityClientPasswordPolicyRecord> KEY_SECURITY_CLIENT_PASSWORD_POLICY_PRIMARY = Internal.createUniqueKey(SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY, DSL.name("KEY_security_client_password_policy_PRIMARY"), new TableField[] { SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY.ID }, true);
    public static final UniqueKey<SecurityClientPasswordPolicyRecord> KEY_SECURITY_CLIENT_PASSWORD_POLICY_UK1_CLIENT_PWD_POL_ID = Internal.createUniqueKey(SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY, DSL.name("KEY_security_client_password_policy_UK1_CLIENT_PWD_POL_ID"), new TableField[] { SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY.CLIENT_ID }, true);
    public static final UniqueKey<SecurityClientTypeRecord> KEY_SECURITY_CLIENT_TYPE_PRIMARY = Internal.createUniqueKey(SecurityClientType.SECURITY_CLIENT_TYPE, DSL.name("KEY_security_client_type_PRIMARY"), new TableField[] { SecurityClientType.SECURITY_CLIENT_TYPE.ID }, true);
    public static final UniqueKey<SecurityClientTypeRecord> KEY_SECURITY_CLIENT_TYPE_UK1_CLIENT_TYPE_CODE = Internal.createUniqueKey(SecurityClientType.SECURITY_CLIENT_TYPE, DSL.name("KEY_security_client_type_UK1_CLIENT_TYPE_CODE"), new TableField[] { SecurityClientType.SECURITY_CLIENT_TYPE.CODE }, true);
    public static final UniqueKey<SecurityClientUrlRecord> KEY_SECURITY_CLIENT_URL_PRIMARY = Internal.createUniqueKey(SecurityClientUrl.SECURITY_CLIENT_URL, DSL.name("KEY_security_client_url_PRIMARY"), new TableField[] { SecurityClientUrl.SECURITY_CLIENT_URL.ID }, true);
    public static final UniqueKey<SecurityClientUrlRecord> KEY_SECURITY_CLIENT_URL_UK1_URL_PATTERN = Internal.createUniqueKey(SecurityClientUrl.SECURITY_CLIENT_URL, DSL.name("KEY_security_client_url_UK1_URL_PATTERN"), new TableField[] { SecurityClientUrl.SECURITY_CLIENT_URL.URL_PATTERN }, true);
    public static final UniqueKey<SecurityOrgStructureRecord> KEY_SECURITY_ORG_STRUCTURE_PRIMARY = Internal.createUniqueKey(SecurityOrgStructure.SECURITY_ORG_STRUCTURE, DSL.name("KEY_security_org_structure_PRIMARY"), new TableField[] { SecurityOrgStructure.SECURITY_ORG_STRUCTURE.ID }, true);
    public static final UniqueKey<SecurityOrgStructureRecord> KEY_SECURITY_ORG_STRUCTURE_UK1_ORG_STRUCTURE = Internal.createUniqueKey(SecurityOrgStructure.SECURITY_ORG_STRUCTURE, DSL.name("KEY_security_org_structure_UK1_ORG_STRUCTURE"), new TableField[] { SecurityOrgStructure.SECURITY_ORG_STRUCTURE.USER_ID, SecurityOrgStructure.SECURITY_ORG_STRUCTURE.MANAGER_ID }, true);
    public static final UniqueKey<SecurityPackageRecord> KEY_SECURITY_PACKAGE_PRIMARY = Internal.createUniqueKey(SecurityPackage.SECURITY_PACKAGE, DSL.name("KEY_security_package_PRIMARY"), new TableField[] { SecurityPackage.SECURITY_PACKAGE.ID }, true);
    public static final UniqueKey<SecurityPackageRecord> KEY_SECURITY_PACKAGE_UK1_PACKAGE_CODE = Internal.createUniqueKey(SecurityPackage.SECURITY_PACKAGE, DSL.name("KEY_security_package_UK1_PACKAGE_CODE"), new TableField[] { SecurityPackage.SECURITY_PACKAGE.CODE }, true);
    public static final UniqueKey<SecurityPackageRecord> KEY_SECURITY_PACKAGE_UK2_PACKAGE_NAME = Internal.createUniqueKey(SecurityPackage.SECURITY_PACKAGE, DSL.name("KEY_security_package_UK2_PACKAGE_NAME"), new TableField[] { SecurityPackage.SECURITY_PACKAGE.NAME }, true);
    public static final UniqueKey<SecurityPackageRoleRecord> KEY_SECURITY_PACKAGE_ROLE_PRIMARY = Internal.createUniqueKey(SecurityPackageRole.SECURITY_PACKAGE_ROLE, DSL.name("KEY_security_package_role_PRIMARY"), new TableField[] { SecurityPackageRole.SECURITY_PACKAGE_ROLE.ID }, true);
    public static final UniqueKey<SecurityPackageRoleRecord> KEY_SECURITY_PACKAGE_ROLE_UK1_PACKAGE_ROLE = Internal.createUniqueKey(SecurityPackageRole.SECURITY_PACKAGE_ROLE, DSL.name("KEY_security_package_role_UK1_PACKAGE_ROLE"), new TableField[] { SecurityPackageRole.SECURITY_PACKAGE_ROLE.ROLE_ID, SecurityPackageRole.SECURITY_PACKAGE_ROLE.PACKAGE_ID }, true);
    public static final UniqueKey<SecurityPastPasswordsRecord> KEY_SECURITY_PAST_PASSWORDS_PRIMARY = Internal.createUniqueKey(SecurityPastPasswords.SECURITY_PAST_PASSWORDS, DSL.name("KEY_security_past_passwords_PRIMARY"), new TableField[] { SecurityPastPasswords.SECURITY_PAST_PASSWORDS.ID }, true);
    public static final UniqueKey<SecurityPermissionRecord> KEY_SECURITY_PERMISSION_PRIMARY = Internal.createUniqueKey(SecurityPermission.SECURITY_PERMISSION, DSL.name("KEY_security_permission_PRIMARY"), new TableField[] { SecurityPermission.SECURITY_PERMISSION.ID }, true);
    public static final UniqueKey<SecurityPermissionRecord> KEY_SECURITY_PERMISSION_UK1_PERMISSION_NAME = Internal.createUniqueKey(SecurityPermission.SECURITY_PERMISSION, DSL.name("KEY_security_permission_UK1_PERMISSION_NAME"), new TableField[] { SecurityPermission.SECURITY_PERMISSION.NAME }, true);
    public static final UniqueKey<SecurityRoleRecord> KEY_SECURITY_ROLE_PRIMARY = Internal.createUniqueKey(SecurityRole.SECURITY_ROLE, DSL.name("KEY_security_role_PRIMARY"), new TableField[] { SecurityRole.SECURITY_ROLE.ID }, true);
    public static final UniqueKey<SecurityRoleRecord> KEY_SECURITY_ROLE_UK1_ROLE_NAME = Internal.createUniqueKey(SecurityRole.SECURITY_ROLE, DSL.name("KEY_security_role_UK1_ROLE_NAME"), new TableField[] { SecurityRole.SECURITY_ROLE.NAME }, true);
    public static final UniqueKey<SecurityRolePermissionRecord> KEY_SECURITY_ROLE_PERMISSION_PRIMARY = Internal.createUniqueKey(SecurityRolePermission.SECURITY_ROLE_PERMISSION, DSL.name("KEY_security_role_permission_PRIMARY"), new TableField[] { SecurityRolePermission.SECURITY_ROLE_PERMISSION.ID }, true);
    public static final UniqueKey<SecurityRolePermissionRecord> KEY_SECURITY_ROLE_PERMISSION_UK1_ROLE_PERMISSION = Internal.createUniqueKey(SecurityRolePermission.SECURITY_ROLE_PERMISSION, DSL.name("KEY_security_role_permission_UK1_ROLE_PERMISSION"), new TableField[] { SecurityRolePermission.SECURITY_ROLE_PERMISSION.ROLE_ID, SecurityRolePermission.SECURITY_ROLE_PERMISSION.PERMISSION_ID }, true);
    public static final UniqueKey<SecuritySoxLogRecord> KEY_SECURITY_SOX_LOG_PRIMARY = Internal.createUniqueKey(SecuritySoxLog.SECURITY_SOX_LOG, DSL.name("KEY_security_sox_log_PRIMARY"), new TableField[] { SecuritySoxLog.SECURITY_SOX_LOG.ID }, true);
    public static final UniqueKey<SecurityUserRecord> KEY_SECURITY_USER_PRIMARY = Internal.createUniqueKey(SecurityUser.SECURITY_USER, DSL.name("KEY_security_user_PRIMARY"), new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
    public static final UniqueKey<SecurityUserRecord> KEY_SECURITY_USER_UK1_USER_NAME = Internal.createUniqueKey(SecurityUser.SECURITY_USER, DSL.name("KEY_security_user_UK1_USER_NAME"), new TableField[] { SecurityUser.SECURITY_USER.CLIENT_ID, SecurityUser.SECURITY_USER.USER_NAME, SecurityUser.SECURITY_USER.EMAIL_ID, SecurityUser.SECURITY_USER.PHONE_NUMBER }, true);
    public static final UniqueKey<SecurityUserRolePermissionRecord> KEY_SECURITY_USER_ROLE_PERMISSION_PRIMARY = Internal.createUniqueKey(SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION, DSL.name("KEY_security_user_role_permission_PRIMARY"), new TableField[] { SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION.ID }, true);
    public static final UniqueKey<SecurityUserTokenRecord> KEY_SECURITY_USER_TOKEN_PRIMARY = Internal.createUniqueKey(SecurityUserToken.SECURITY_USER_TOKEN, DSL.name("KEY_security_user_token_PRIMARY"), new TableField[] { SecurityUserToken.SECURITY_USER_TOKEN.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<SecurityAppRecord, SecurityClientRecord> FK1_APP_CLIENT_ID = Internal.createForeignKey(SecurityApp.SECURITY_APP, DSL.name("FK1_APP_CLIENT_ID"), new TableField[] { SecurityApp.SECURITY_APP.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityClientRecord, SecurityClientTypeRecord> FK1_CLIENT_CLIENT_TYPE_CODE = Internal.createForeignKey(SecurityClient.SECURITY_CLIENT, DSL.name("FK1_CLIENT_CLIENT_TYPE_CODE"), new TableField[] { SecurityClient.SECURITY_CLIENT.TYPE_CODE }, Keys.KEY_SECURITY_CLIENT_TYPE_UK1_CLIENT_TYPE_CODE, new TableField[] { SecurityClientType.SECURITY_CLIENT_TYPE.CODE }, true);
    public static final ForeignKey<SecurityClientManageRecord, SecurityClientRecord> FK1_CLIENT_MANAGE_CLIENT_ID = Internal.createForeignKey(SecurityClientManage.SECURITY_CLIENT_MANAGE, DSL.name("FK1_CLIENT_MANAGE_CLIENT_ID"), new TableField[] { SecurityClientManage.SECURITY_CLIENT_MANAGE.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityClientManageRecord, SecurityClientRecord> FK1_CLIENT_MANAGE_MNG_CLIENT_ID = Internal.createForeignKey(SecurityClientManage.SECURITY_CLIENT_MANAGE, DSL.name("FK1_CLIENT_MANAGE_MNG_CLIENT_ID"), new TableField[] { SecurityClientManage.SECURITY_CLIENT_MANAGE.MANAGE_CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityClientPackageRecord, SecurityClientRecord> FK1_CLIENT_PACKAGE_CLIENT_ID = Internal.createForeignKey(SecurityClientPackage.SECURITY_CLIENT_PACKAGE, DSL.name("FK1_CLIENT_PACKAGE_CLIENT_ID"), new TableField[] { SecurityClientPackage.SECURITY_CLIENT_PACKAGE.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityClientPackageRecord, SecurityPackageRecord> FK2_CLIENT_PACKAGE_PACKAGE_ID = Internal.createForeignKey(SecurityClientPackage.SECURITY_CLIENT_PACKAGE, DSL.name("FK2_CLIENT_PACKAGE_PACKAGE_ID"), new TableField[] { SecurityClientPackage.SECURITY_CLIENT_PACKAGE.PACKAGE_ID }, Keys.KEY_SECURITY_PACKAGE_PRIMARY, new TableField[] { SecurityPackage.SECURITY_PACKAGE.ID }, true);
    public static final ForeignKey<SecurityClientPasswordPolicyRecord, SecurityClientRecord> FK1_CLIENT_PWD_POL_CLIENT_ID = Internal.createForeignKey(SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY, DSL.name("FK1_CLIENT_PWD_POL_CLIENT_ID"), new TableField[] { SecurityClientPasswordPolicy.SECURITY_CLIENT_PASSWORD_POLICY.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityClientUrlRecord, SecurityAppRecord> FK1_CLIENT_URL_APP_CODE = Internal.createForeignKey(SecurityClientUrl.SECURITY_CLIENT_URL, DSL.name("FK1_CLIENT_URL_APP_CODE"), new TableField[] { SecurityClientUrl.SECURITY_CLIENT_URL.APP_CODE }, Keys.KEY_SECURITY_APP_UK1_APPCODE, new TableField[] { SecurityApp.SECURITY_APP.APP_CODE }, true);
    public static final ForeignKey<SecurityClientUrlRecord, SecurityClientRecord> FK1_CLIENT_URL_CLIENT_ID = Internal.createForeignKey(SecurityClientUrl.SECURITY_CLIENT_URL, DSL.name("FK1_CLIENT_URL_CLIENT_ID"), new TableField[] { SecurityClientUrl.SECURITY_CLIENT_URL.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityOrgStructureRecord, SecurityClientRecord> FK1_ORG_STRUCTURE_CLIENT_ID = Internal.createForeignKey(SecurityOrgStructure.SECURITY_ORG_STRUCTURE, DSL.name("FK1_ORG_STRUCTURE_CLIENT_ID"), new TableField[] { SecurityOrgStructure.SECURITY_ORG_STRUCTURE.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityOrgStructureRecord, SecurityUserRecord> FK2_ORG_STRUCTURE_USER_ID = Internal.createForeignKey(SecurityOrgStructure.SECURITY_ORG_STRUCTURE, DSL.name("FK2_ORG_STRUCTURE_USER_ID"), new TableField[] { SecurityOrgStructure.SECURITY_ORG_STRUCTURE.USER_ID }, Keys.KEY_SECURITY_USER_PRIMARY, new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
    public static final ForeignKey<SecurityOrgStructureRecord, SecurityUserRecord> FK3_ORG_STRUCTURE_MANAGER_ID = Internal.createForeignKey(SecurityOrgStructure.SECURITY_ORG_STRUCTURE, DSL.name("FK3_ORG_STRUCTURE_MANAGER_ID"), new TableField[] { SecurityOrgStructure.SECURITY_ORG_STRUCTURE.MANAGER_ID }, Keys.KEY_SECURITY_USER_PRIMARY, new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
    public static final ForeignKey<SecurityPackageRecord, SecurityClientRecord> FK1_PACKAGE_CLIENT_ID = Internal.createForeignKey(SecurityPackage.SECURITY_PACKAGE, DSL.name("FK1_PACKAGE_CLIENT_ID"), new TableField[] { SecurityPackage.SECURITY_PACKAGE.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityPackageRoleRecord, SecurityRoleRecord> FK1_PACKAGE_ROLE_ROLE_ID = Internal.createForeignKey(SecurityPackageRole.SECURITY_PACKAGE_ROLE, DSL.name("FK1_PACKAGE_ROLE_ROLE_ID"), new TableField[] { SecurityPackageRole.SECURITY_PACKAGE_ROLE.ROLE_ID }, Keys.KEY_SECURITY_ROLE_PRIMARY, new TableField[] { SecurityRole.SECURITY_ROLE.ID }, true);
    public static final ForeignKey<SecurityPackageRoleRecord, SecurityPackageRecord> FK2_PACKAGE_ROLE_PACKAGE_ID = Internal.createForeignKey(SecurityPackageRole.SECURITY_PACKAGE_ROLE, DSL.name("FK2_PACKAGE_ROLE_PACKAGE_ID"), new TableField[] { SecurityPackageRole.SECURITY_PACKAGE_ROLE.PACKAGE_ID }, Keys.KEY_SECURITY_PACKAGE_PRIMARY, new TableField[] { SecurityPackage.SECURITY_PACKAGE.ID }, true);
    public static final ForeignKey<SecurityPastPasswordsRecord, SecurityUserRecord> FK1_PAST_PASSWORD_USER_ID = Internal.createForeignKey(SecurityPastPasswords.SECURITY_PAST_PASSWORDS, DSL.name("FK1_PAST_PASSWORD_USER_ID"), new TableField[] { SecurityPastPasswords.SECURITY_PAST_PASSWORDS.USER_ID }, Keys.KEY_SECURITY_USER_PRIMARY, new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
    public static final ForeignKey<SecurityPermissionRecord, SecurityClientRecord> FK1_PERMISSION_CLIENT_ID = Internal.createForeignKey(SecurityPermission.SECURITY_PERMISSION, DSL.name("FK1_PERMISSION_CLIENT_ID"), new TableField[] { SecurityPermission.SECURITY_PERMISSION.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityPermissionRecord, SecurityAppRecord> FK2_PERMISSION_APP_ID = Internal.createForeignKey(SecurityPermission.SECURITY_PERMISSION, DSL.name("FK2_PERMISSION_APP_ID"), new TableField[] { SecurityPermission.SECURITY_PERMISSION.APP_ID }, Keys.KEY_SECURITY_APP_PRIMARY, new TableField[] { SecurityApp.SECURITY_APP.ID }, true);
    public static final ForeignKey<SecurityRoleRecord, SecurityClientRecord> FK1_ROLE_CLIENT_ID = Internal.createForeignKey(SecurityRole.SECURITY_ROLE, DSL.name("FK1_ROLE_CLIENT_ID"), new TableField[] { SecurityRole.SECURITY_ROLE.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityRoleRecord, SecurityAppRecord> FK2_ROLE_APP_ID = Internal.createForeignKey(SecurityRole.SECURITY_ROLE, DSL.name("FK2_ROLE_APP_ID"), new TableField[] { SecurityRole.SECURITY_ROLE.APP_ID }, Keys.KEY_SECURITY_APP_PRIMARY, new TableField[] { SecurityApp.SECURITY_APP.ID }, true);
    public static final ForeignKey<SecurityRolePermissionRecord, SecurityRoleRecord> FK1_ROLE_PERM_ROLE_ID = Internal.createForeignKey(SecurityRolePermission.SECURITY_ROLE_PERMISSION, DSL.name("FK1_ROLE_PERM_ROLE_ID"), new TableField[] { SecurityRolePermission.SECURITY_ROLE_PERMISSION.ROLE_ID }, Keys.KEY_SECURITY_ROLE_PRIMARY, new TableField[] { SecurityRole.SECURITY_ROLE.ID }, true);
    public static final ForeignKey<SecurityRolePermissionRecord, SecurityPermissionRecord> FK2_ROLE_PERM_PERMISSION_ID = Internal.createForeignKey(SecurityRolePermission.SECURITY_ROLE_PERMISSION, DSL.name("FK2_ROLE_PERM_PERMISSION_ID"), new TableField[] { SecurityRolePermission.SECURITY_ROLE_PERMISSION.PERMISSION_ID }, Keys.KEY_SECURITY_PERMISSION_PRIMARY, new TableField[] { SecurityPermission.SECURITY_PERMISSION.ID }, true);
    public static final ForeignKey<SecurityUserRecord, SecurityClientRecord> FK1_USER_CLIENT_ID = Internal.createForeignKey(SecurityUser.SECURITY_USER, DSL.name("FK1_USER_CLIENT_ID"), new TableField[] { SecurityUser.SECURITY_USER.CLIENT_ID }, Keys.KEY_SECURITY_CLIENT_PRIMARY, new TableField[] { SecurityClient.SECURITY_CLIENT.ID }, true);
    public static final ForeignKey<SecurityUserRolePermissionRecord, SecurityUserRecord> FK1_USER_ROLE_USER_ID = Internal.createForeignKey(SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION, DSL.name("FK1_USER_ROLE_USER_ID"), new TableField[] { SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION.USER_ID }, Keys.KEY_SECURITY_USER_PRIMARY, new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
    public static final ForeignKey<SecurityUserRolePermissionRecord, SecurityRoleRecord> FK2_USER_ROLE_ROLE_ID = Internal.createForeignKey(SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION, DSL.name("FK2_USER_ROLE_ROLE_ID"), new TableField[] { SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION.ROLE_ID }, Keys.KEY_SECURITY_ROLE_PRIMARY, new TableField[] { SecurityRole.SECURITY_ROLE.ID }, true);
    public static final ForeignKey<SecurityUserRolePermissionRecord, SecurityPermissionRecord> FK3_USER_ROLE_PERMISSION_ID = Internal.createForeignKey(SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION, DSL.name("FK3_USER_ROLE_PERMISSION_ID"), new TableField[] { SecurityUserRolePermission.SECURITY_USER_ROLE_PERMISSION.PERMISSION_ID }, Keys.KEY_SECURITY_PERMISSION_PRIMARY, new TableField[] { SecurityPermission.SECURITY_PERMISSION.ID }, true);
    public static final ForeignKey<SecurityUserTokenRecord, SecurityUserRecord> FK1_USER_TOKEN_USER_ID = Internal.createForeignKey(SecurityUserToken.SECURITY_USER_TOKEN, DSL.name("FK1_USER_TOKEN_USER_ID"), new TableField[] { SecurityUserToken.SECURITY_USER_TOKEN.USER_ID }, Keys.KEY_SECURITY_USER_PRIMARY, new TableField[] { SecurityUser.SECURITY_USER.ID }, true);
}
