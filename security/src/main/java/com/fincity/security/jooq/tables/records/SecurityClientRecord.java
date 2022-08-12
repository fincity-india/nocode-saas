/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.enums.SecurityClientStatusCode;
import com.fincity.security.jooq.tables.SecurityClient;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityClientRecord extends UpdatableRecordImpl<SecurityClientRecord> implements Record11<ULong, String, String, String, UInteger, String, SecurityClientStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_client.ID</code>. Primary key
     */
    public SecurityClientRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_client.CODE</code>. Client code
     */
    public SecurityClientRecord setCode(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.CODE</code>. Client code
     */
    public String getCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>security.security_client.NAME</code>. Name of the client
     */
    public SecurityClientRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.NAME</code>. Name of the client
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>security.security_client.TYPE_CODE</code>. Type of
     * client
     */
    public SecurityClientRecord setTypeCode(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.TYPE_CODE</code>. Type of
     * client
     */
    public String getTypeCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>security.security_client.TOKEN_VALIDITY_MINUTES</code>.
     * Token validity in minutes
     */
    public SecurityClientRecord setTokenValidityMinutes(UInteger value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.TOKEN_VALIDITY_MINUTES</code>.
     * Token validity in minutes
     */
    public UInteger getTokenValidityMinutes() {
        return (UInteger) get(4);
    }

    /**
     * Setter for <code>security.security_client.LOCALE_CODE</code>. Client
     * default locale
     */
    public SecurityClientRecord setLocaleCode(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.LOCALE_CODE</code>. Client
     * default locale
     */
    public String getLocaleCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>security.security_client.STATUS_CODE</code>. Status of
     * the client
     */
    public SecurityClientRecord setStatusCode(SecurityClientStatusCode value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.STATUS_CODE</code>. Status of
     * the client
     */
    public SecurityClientStatusCode getStatusCode() {
        return (SecurityClientStatusCode) get(6);
    }

    /**
     * Setter for <code>security.security_client.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public SecurityClientRecord setCreatedBy(ULong value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>security.security_client.CREATED_AT</code>. Time when
     * this row is created
     */
    public SecurityClientRecord setCreatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.CREATED_AT</code>. Time when
     * this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>security.security_client.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public SecurityClientRecord setUpdatedBy(ULong value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>security.security_client.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public SecurityClientRecord setUpdatedAt(LocalDateTime value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>security.security_client.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<ULong, String, String, String, UInteger, String, SecurityClientStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<ULong, String, String, String, UInteger, String, SecurityClientStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityClient.SECURITY_CLIENT.ID;
    }

    @Override
    public Field<String> field2() {
        return SecurityClient.SECURITY_CLIENT.CODE;
    }

    @Override
    public Field<String> field3() {
        return SecurityClient.SECURITY_CLIENT.NAME;
    }

    @Override
    public Field<String> field4() {
        return SecurityClient.SECURITY_CLIENT.TYPE_CODE;
    }

    @Override
    public Field<UInteger> field5() {
        return SecurityClient.SECURITY_CLIENT.TOKEN_VALIDITY_MINUTES;
    }

    @Override
    public Field<String> field6() {
        return SecurityClient.SECURITY_CLIENT.LOCALE_CODE;
    }

    @Override
    public Field<SecurityClientStatusCode> field7() {
        return SecurityClient.SECURITY_CLIENT.STATUS_CODE;
    }

    @Override
    public Field<ULong> field8() {
        return SecurityClient.SECURITY_CLIENT.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SecurityClient.SECURITY_CLIENT.CREATED_AT;
    }

    @Override
    public Field<ULong> field10() {
        return SecurityClient.SECURITY_CLIENT.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return SecurityClient.SECURITY_CLIENT.UPDATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getCode();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getTypeCode();
    }

    @Override
    public UInteger component5() {
        return getTokenValidityMinutes();
    }

    @Override
    public String component6() {
        return getLocaleCode();
    }

    @Override
    public SecurityClientStatusCode component7() {
        return getStatusCode();
    }

    @Override
    public ULong component8() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component9() {
        return getCreatedAt();
    }

    @Override
    public ULong component10() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component11() {
        return getUpdatedAt();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getCode();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getTypeCode();
    }

    @Override
    public UInteger value5() {
        return getTokenValidityMinutes();
    }

    @Override
    public String value6() {
        return getLocaleCode();
    }

    @Override
    public SecurityClientStatusCode value7() {
        return getStatusCode();
    }

    @Override
    public ULong value8() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value9() {
        return getCreatedAt();
    }

    @Override
    public ULong value10() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value11() {
        return getUpdatedAt();
    }

    @Override
    public SecurityClientRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityClientRecord value2(String value) {
        setCode(value);
        return this;
    }

    @Override
    public SecurityClientRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public SecurityClientRecord value4(String value) {
        setTypeCode(value);
        return this;
    }

    @Override
    public SecurityClientRecord value5(UInteger value) {
        setTokenValidityMinutes(value);
        return this;
    }

    @Override
    public SecurityClientRecord value6(String value) {
        setLocaleCode(value);
        return this;
    }

    @Override
    public SecurityClientRecord value7(SecurityClientStatusCode value) {
        setStatusCode(value);
        return this;
    }

    @Override
    public SecurityClientRecord value8(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityClientRecord value9(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityClientRecord value10(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityClientRecord value11(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityClientRecord values(ULong value1, String value2, String value3, String value4, UInteger value5, String value6, SecurityClientStatusCode value7, ULong value8, LocalDateTime value9, ULong value10, LocalDateTime value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityClientRecord
     */
    public SecurityClientRecord() {
        super(SecurityClient.SECURITY_CLIENT);
    }

    /**
     * Create a detached, initialised SecurityClientRecord
     */
    public SecurityClientRecord(ULong id, String code, String name, String typeCode, UInteger tokenValidityMinutes, String localeCode, SecurityClientStatusCode statusCode, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityClient.SECURITY_CLIENT);

        setId(id);
        setCode(code);
        setName(name);
        setTypeCode(typeCode);
        setTokenValidityMinutes(tokenValidityMinutes);
        setLocaleCode(localeCode);
        setStatusCode(statusCode);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
    }
}
