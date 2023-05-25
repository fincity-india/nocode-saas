/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityPermission;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityPermissionRecord extends UpdatableRecordImpl<SecurityPermissionRecord> implements Record9<ULong, ULong, String, ULong, String, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_permission.ID</code>. Primary key
     */
    public SecurityPermissionRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_permission.CLIENT_ID</code>. Client ID
     * for which this permission belongs to
     */
    public SecurityPermissionRecord setClientId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.CLIENT_ID</code>. Client ID
     * for which this permission belongs to
     */
    public ULong getClientId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_permission.NAME</code>. Name of the
     * permission
     */
    public SecurityPermissionRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.NAME</code>. Name of the
     * permission
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>security.security_permission.APP_ID</code>.
     */
    public SecurityPermissionRecord setAppId(ULong value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.APP_ID</code>.
     */
    public ULong getAppId() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>security.security_permission.DESCRIPTION</code>.
     * Description of the permission
     */
    public SecurityPermissionRecord setDescription(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.DESCRIPTION</code>.
     * Description of the permission
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_permission.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public SecurityPermissionRecord setCreatedBy(ULong value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>security.security_permission.CREATED_AT</code>. Time
     * when this row is created
     */
    public SecurityPermissionRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.CREATED_AT</code>. Time
     * when this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>security.security_permission.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public SecurityPermissionRecord setUpdatedBy(ULong value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>security.security_permission.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public SecurityPermissionRecord setUpdatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<ULong, ULong, String, ULong, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<ULong, ULong, String, ULong, String, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityPermission.SECURITY_PERMISSION.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityPermission.SECURITY_PERMISSION.CLIENT_ID;
    }

    @Override
    public Field<String> field3() {
        return SecurityPermission.SECURITY_PERMISSION.NAME;
    }

    @Override
    public Field<ULong> field4() {
        return SecurityPermission.SECURITY_PERMISSION.APP_ID;
    }

    @Override
    public Field<String> field5() {
        return SecurityPermission.SECURITY_PERMISSION.DESCRIPTION;
    }

    @Override
    public Field<ULong> field6() {
        return SecurityPermission.SECURITY_PERMISSION.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return SecurityPermission.SECURITY_PERMISSION.CREATED_AT;
    }

    @Override
    public Field<ULong> field8() {
        return SecurityPermission.SECURITY_PERMISSION.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SecurityPermission.SECURITY_PERMISSION.UPDATED_AT;
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
    public String component3() {
        return getName();
    }

    @Override
    public ULong component4() {
        return getAppId();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public ULong component6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public ULong component8() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component9() {
        return getUpdatedAt();
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
    public String value3() {
        return getName();
    }

    @Override
    public ULong value4() {
        return getAppId();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public ULong value6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public ULong value8() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value9() {
        return getUpdatedAt();
    }

    @Override
    public SecurityPermissionRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value2(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value4(ULong value) {
        setAppId(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value6(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value8(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value9(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord values(ULong value1, ULong value2, String value3, ULong value4, String value5, ULong value6, LocalDateTime value7, ULong value8, LocalDateTime value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityPermissionRecord
     */
    public SecurityPermissionRecord() {
        super(SecurityPermission.SECURITY_PERMISSION);
    }

    /**
     * Create a detached, initialised SecurityPermissionRecord
     */
    public SecurityPermissionRecord(ULong id, ULong clientId, String name, ULong appId, String description, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityPermission.SECURITY_PERMISSION);

        setId(id);
        setClientId(clientId);
        setName(name);
        setAppId(appId);
        setDescription(description);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
