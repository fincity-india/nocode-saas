/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityAppProperty;

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
public class SecurityAppPropertyRecord extends UpdatableRecordImpl<SecurityAppPropertyRecord> implements Record9<ULong, ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_app_property.ID</code>. Primary key
     */
    public SecurityAppPropertyRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_app_property.APP_ID</code>. App ID for
     * which this property belongs to
     */
    public SecurityAppPropertyRecord setAppId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.APP_ID</code>. App ID for
     * which this property belongs to
     */
    public ULong getAppId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_app_property.CLIENT_ID</code>. Client
     * ID for which this property belongs to
     */
    public SecurityAppPropertyRecord setClientId(ULong value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.CLIENT_ID</code>. Client
     * ID for which this property belongs to
     */
    public ULong getClientId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>security.security_app_property.NAME</code>. Name of the
     * property
     */
    public SecurityAppPropertyRecord setName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.NAME</code>. Name of the
     * property
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>security.security_app_property.VALUE</code>. Value of
     * the property
     */
    public SecurityAppPropertyRecord setValue(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.VALUE</code>. Value of
     * the property
     */
    public String getValue() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_app_property.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public SecurityAppPropertyRecord setCreatedBy(ULong value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>security.security_app_property.CREATED_AT</code>. Time
     * when this row is created
     */
    public SecurityAppPropertyRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.CREATED_AT</code>. Time
     * when this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>security.security_app_property.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public SecurityAppPropertyRecord setUpdatedBy(ULong value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.UPDATED_BY</code>. ID of
     * the user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>security.security_app_property.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public SecurityAppPropertyRecord setUpdatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_property.UPDATED_AT</code>. Time
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
    public Row9<ULong, ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<ULong, ULong, ULong, String, String, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.APP_ID;
    }

    @Override
    public Field<ULong> field3() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.CLIENT_ID;
    }

    @Override
    public Field<String> field4() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.NAME;
    }

    @Override
    public Field<String> field5() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.VALUE;
    }

    @Override
    public Field<ULong> field6() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.CREATED_AT;
    }

    @Override
    public Field<ULong> field8() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SecurityAppProperty.SECURITY_APP_PROPERTY.UPDATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getAppId();
    }

    @Override
    public ULong component3() {
        return getClientId();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String component5() {
        return getValue();
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
        return getAppId();
    }

    @Override
    public ULong value3() {
        return getClientId();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public String value5() {
        return getValue();
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
    public SecurityAppPropertyRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value2(ULong value) {
        setAppId(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value3(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value5(String value) {
        setValue(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value6(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value8(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord value9(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityAppPropertyRecord values(ULong value1, ULong value2, ULong value3, String value4, String value5, ULong value6, LocalDateTime value7, ULong value8, LocalDateTime value9) {
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
     * Create a detached SecurityAppPropertyRecord
     */
    public SecurityAppPropertyRecord() {
        super(SecurityAppProperty.SECURITY_APP_PROPERTY);
    }

    /**
     * Create a detached, initialised SecurityAppPropertyRecord
     */
    public SecurityAppPropertyRecord(ULong id, ULong appId, ULong clientId, String name, String value, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityAppProperty.SECURITY_APP_PROPERTY);

        setId(id);
        setAppId(appId);
        setClientId(clientId);
        setName(name);
        setValue(value);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
