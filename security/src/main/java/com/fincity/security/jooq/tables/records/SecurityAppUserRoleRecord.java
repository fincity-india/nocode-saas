/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityAppUserRole;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityAppUserRoleRecord extends UpdatableRecordImpl<SecurityAppUserRoleRecord> implements Record4<ULong, ULong, ULong, ULong> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_app_user_role.ID</code>. Primary key
     */
    public SecurityAppUserRoleRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_user_role.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_app_user_role.CLIENT_ID</code>. Client
     * ID for which this APP PACKAGE relation belongs to
     */
    public SecurityAppUserRoleRecord setClientId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_user_role.CLIENT_ID</code>. Client
     * ID for which this APP PACKAGE relation belongs to
     */
    public ULong getClientId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_app_user_role.APP_ID</code>. App ID
     * for which this APP belongs to
     */
    public SecurityAppUserRoleRecord setAppId(ULong value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_user_role.APP_ID</code>. App ID
     * for which this APP belongs to
     */
    public ULong getAppId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>security.security_app_user_role.ROLE_ID</code>. Role ID
     */
    public SecurityAppUserRoleRecord setRoleId(ULong value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_user_role.ROLE_ID</code>. Role ID
     */
    public ULong getRoleId() {
        return (ULong) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<ULong, ULong, ULong, ULong> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<ULong, ULong, ULong, ULong> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityAppUserRole.SECURITY_APP_USER_ROLE.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityAppUserRole.SECURITY_APP_USER_ROLE.CLIENT_ID;
    }

    @Override
    public Field<ULong> field3() {
        return SecurityAppUserRole.SECURITY_APP_USER_ROLE.APP_ID;
    }

    @Override
    public Field<ULong> field4() {
        return SecurityAppUserRole.SECURITY_APP_USER_ROLE.ROLE_ID;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getClientId();
    }

    @Override
    public ULong component3() {
        return getAppId();
    }

    @Override
    public ULong component4() {
        return getRoleId();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public ULong value2() {
        return getClientId();
    }

    @Override
    public ULong value3() {
        return getAppId();
    }

    @Override
    public ULong value4() {
        return getRoleId();
    }

    @Override
    public SecurityAppUserRoleRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityAppUserRoleRecord value2(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityAppUserRoleRecord value3(ULong value) {
        setAppId(value);
        return this;
    }

    @Override
    public SecurityAppUserRoleRecord value4(ULong value) {
        setRoleId(value);
        return this;
    }

    @Override
    public SecurityAppUserRoleRecord values(ULong value1, ULong value2, ULong value3, ULong value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityAppUserRoleRecord
     */
    public SecurityAppUserRoleRecord() {
        super(SecurityAppUserRole.SECURITY_APP_USER_ROLE);
    }

    /**
     * Create a detached, initialised SecurityAppUserRoleRecord
     */
    public SecurityAppUserRoleRecord(ULong id, ULong clientId, ULong appId, ULong roleId) {
        super(SecurityAppUserRole.SECURITY_APP_USER_ROLE);

        setId(id);
        setClientId(clientId);
        setAppId(appId);
        setRoleId(roleId);
        resetChangedOnNotNull();
    }
}
