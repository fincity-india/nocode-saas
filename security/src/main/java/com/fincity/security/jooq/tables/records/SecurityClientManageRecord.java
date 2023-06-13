/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityClientManage;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityClientManageRecord extends UpdatableRecordImpl<SecurityClientManageRecord> implements Record3<ULong, ULong, ULong> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_client_manage.ID</code>. Primary key
     */
    public SecurityClientManageRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client_manage.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_client_manage.CLIENT_ID</code>. Client
     * ID
     */
    public SecurityClientManageRecord setClientId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client_manage.CLIENT_ID</code>. Client
     * ID
     */
    public ULong getClientId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_client_manage.MANAGE_CLIENT_ID</code>.
     * Client ID that manages this client
     */
    public SecurityClientManageRecord setManageClientId(ULong value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client_manage.MANAGE_CLIENT_ID</code>.
     * Client ID that manages this client
     */
    public ULong getManageClientId() {
        return (ULong) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<ULong, ULong, ULong> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<ULong, ULong, ULong> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityClientManage.SECURITY_CLIENT_MANAGE.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityClientManage.SECURITY_CLIENT_MANAGE.CLIENT_ID;
    }

    @Override
    public Field<ULong> field3() {
        return SecurityClientManage.SECURITY_CLIENT_MANAGE.MANAGE_CLIENT_ID;
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
        return getManageClientId();
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
        return getManageClientId();
    }

    @Override
    public SecurityClientManageRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityClientManageRecord value2(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityClientManageRecord value3(ULong value) {
        setManageClientId(value);
        return this;
    }

    @Override
    public SecurityClientManageRecord values(ULong value1, ULong value2, ULong value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityClientManageRecord
     */
    public SecurityClientManageRecord() {
        super(SecurityClientManage.SECURITY_CLIENT_MANAGE);
    }

    /**
     * Create a detached, initialised SecurityClientManageRecord
     */
    public SecurityClientManageRecord(ULong id, ULong clientId, ULong manageClientId) {
        super(SecurityClientManage.SECURITY_CLIENT_MANAGE);

        setId(id);
        setClientId(clientId);
        setManageClientId(manageClientId);
        resetChangedOnNotNull();
    }
}
