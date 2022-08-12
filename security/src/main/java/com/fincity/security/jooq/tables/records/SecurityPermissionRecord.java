/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityPermission;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityPermissionRecord extends UpdatableRecordImpl<SecurityPermissionRecord> implements Record8<ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> {

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
     * Setter for <code>security.security_permission.DESCRIPTION</code>.
     * Description of the permission
     */
    public SecurityPermissionRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.DESCRIPTION</code>.
     * Description of the permission
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>security.security_permission.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public SecurityPermissionRecord setCreatedBy(ULong value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>security.security_permission.CREATED_AT</code>. Time
     * when this row is created
     */
    public SecurityPermissionRecord setCreatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.CREATED_AT</code>. Time
     * when this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>security.security_permission.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public SecurityPermissionRecord setUpdatedBy(ULong value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>security.security_permission.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public SecurityPermissionRecord setUpdatedAt(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_permission.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
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
    public Field<String> field4() {
        return SecurityPermission.SECURITY_PERMISSION.DESCRIPTION;
    }

    @Override
    public Field<ULong> field5() {
        return SecurityPermission.SECURITY_PERMISSION.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return SecurityPermission.SECURITY_PERMISSION.CREATED_AT;
    }

    @Override
    public Field<ULong> field7() {
        return SecurityPermission.SECURITY_PERMISSION.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field8() {
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
    public String component4() {
        return getDescription();
    }

    @Override
    public ULong component5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public ULong component7() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component8() {
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
    public String value4() {
        return getDescription();
    }

    @Override
    public ULong value5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public ULong value7() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value8() {
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
    public SecurityPermissionRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value5(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value7(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord value8(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityPermissionRecord values(ULong value1, ULong value2, String value3, String value4, ULong value5, LocalDateTime value6, ULong value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
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
    public SecurityPermissionRecord(ULong id, ULong clientId, String name, String description, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityPermission.SECURITY_PERMISSION);

        setId(id);
        setClientId(clientId);
        setName(name);
        setDescription(description);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
    }
}
