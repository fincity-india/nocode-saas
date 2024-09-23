/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.enums.SecurityAppRegIntegrationPlatform;
import com.fincity.security.jooq.tables.SecurityAppRegIntegration;

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
public class SecurityAppRegIntegrationRecord extends UpdatableRecordImpl<SecurityAppRegIntegrationRecord> implements Record9<ULong, ULong, ULong, SecurityAppRegIntegrationPlatform, String, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_app_reg_integration.ID</code>. Primary
     * key
     */
    public SecurityAppRegIntegrationRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.ID</code>. Primary
     * key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.APP_ID</code>. App
     * ID
     */
    public SecurityAppRegIntegrationRecord setAppId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.APP_ID</code>. App
     * ID
     */
    public ULong getAppId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.CLIENT_ID</code>.
     * Client ID
     */
    public SecurityAppRegIntegrationRecord setClientId(ULong value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.CLIENT_ID</code>.
     * Client ID
     */
    public ULong getClientId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.PLATFORM</code>.
     * Platform
     */
    public SecurityAppRegIntegrationRecord setPlatform(SecurityAppRegIntegrationPlatform value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.PLATFORM</code>.
     * Platform
     */
    public SecurityAppRegIntegrationPlatform getPlatform() {
        return (SecurityAppRegIntegrationPlatform) get(3);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.SCOPES</code>.
     * Scopes
     */
    public SecurityAppRegIntegrationRecord setScopes(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.SCOPES</code>.
     * Scopes
     */
    public String getScopes() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.CREATED_BY</code>.
     * ID of the user who created this row
     */
    public SecurityAppRegIntegrationRecord setCreatedBy(ULong value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.CREATED_BY</code>.
     * ID of the user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.CREATED_AT</code>.
     * Time when this row is created
     */
    public SecurityAppRegIntegrationRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.CREATED_AT</code>.
     * Time when this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.UPDATED_BY</code>.
     * ID of the user who updated this row
     */
    public SecurityAppRegIntegrationRecord setUpdatedBy(ULong value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.UPDATED_BY</code>.
     * ID of the user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>security.security_app_reg_integration.UPDATED_AT</code>.
     * Time when this row is updated
     */
    public SecurityAppRegIntegrationRecord setUpdatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_app_reg_integration.UPDATED_AT</code>.
     * Time when this row is updated
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
    public Row9<ULong, ULong, ULong, SecurityAppRegIntegrationPlatform, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<ULong, ULong, ULong, SecurityAppRegIntegrationPlatform, String, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.APP_ID;
    }

    @Override
    public Field<ULong> field3() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.CLIENT_ID;
    }

    @Override
    public Field<SecurityAppRegIntegrationPlatform> field4() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.PLATFORM;
    }

    @Override
    public Field<String> field5() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.SCOPES;
    }

    @Override
    public Field<ULong> field6() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.CREATED_AT;
    }

    @Override
    public Field<ULong> field8() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION.UPDATED_AT;
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
    public SecurityAppRegIntegrationPlatform component4() {
        return getPlatform();
    }

    @Override
    public String component5() {
        return getScopes();
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
    public SecurityAppRegIntegrationPlatform value4() {
        return getPlatform();
    }

    @Override
    public String value5() {
        return getScopes();
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
    public SecurityAppRegIntegrationRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value2(ULong value) {
        setAppId(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value3(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value4(SecurityAppRegIntegrationPlatform value) {
        setPlatform(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value5(String value) {
        setScopes(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value6(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value8(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord value9(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityAppRegIntegrationRecord values(ULong value1, ULong value2, ULong value3, SecurityAppRegIntegrationPlatform value4, String value5, ULong value6, LocalDateTime value7, ULong value8, LocalDateTime value9) {
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
     * Create a detached SecurityAppRegIntegrationRecord
     */
    public SecurityAppRegIntegrationRecord() {
        super(SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION);
    }

    /**
     * Create a detached, initialised SecurityAppRegIntegrationRecord
     */
    public SecurityAppRegIntegrationRecord(ULong id, ULong appId, ULong clientId, SecurityAppRegIntegrationPlatform platform, String scopes, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityAppRegIntegration.SECURITY_APP_REG_INTEGRATION);

        setId(id);
        setAppId(appId);
        setClientId(clientId);
        setPlatform(platform);
        setScopes(scopes);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
