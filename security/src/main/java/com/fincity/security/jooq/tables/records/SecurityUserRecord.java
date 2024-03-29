/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.enums.SecurityUserStatusCode;
import com.fincity.security.jooq.tables.SecurityUser;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record21;
import org.jooq.Row21;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityUserRecord extends UpdatableRecordImpl<SecurityUserRecord> implements Record21<ULong, ULong, String, String, String, String, String, String, String, String, String, Byte, Byte, Byte, Byte, Short, SecurityUserStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_user.ID</code>. Primary key
     */
    public SecurityUserRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_user.CLIENT_ID</code>. Client ID for
     * which this user belongs to
     */
    public SecurityUserRecord setClientId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.CLIENT_ID</code>. Client ID for
     * which this user belongs to
     */
    public ULong getClientId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_user.USER_NAME</code>. User Name to
     * login
     */
    public SecurityUserRecord setUserName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.USER_NAME</code>. User Name to
     * login
     */
    public String getUserName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>security.security_user.EMAIL_ID</code>. Email ID to
     * login
     */
    public SecurityUserRecord setEmailId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.EMAIL_ID</code>. Email ID to
     * login
     */
    public String getEmailId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>security.security_user.PHONE_NUMBER</code>. Phone Number
     * to login
     */
    public SecurityUserRecord setPhoneNumber(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.PHONE_NUMBER</code>. Phone Number
     * to login
     */
    public String getPhoneNumber() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_user.FIRST_NAME</code>. First name
     */
    public SecurityUserRecord setFirstName(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.FIRST_NAME</code>. First name
     */
    public String getFirstName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>security.security_user.LAST_NAME</code>. Last name
     */
    public SecurityUserRecord setLastName(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.LAST_NAME</code>. Last name
     */
    public String getLastName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>security.security_user.DESIGNATION</code>. Designation
     */
    public SecurityUserRecord setDesignation(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.DESIGNATION</code>. Designation
     */
    public String getDesignation() {
        return (String) get(7);
    }

    /**
     * Setter for <code>security.security_user.MIDDLE_NAME</code>. Middle name
     */
    public SecurityUserRecord setMiddleName(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.MIDDLE_NAME</code>. Middle name
     */
    public String getMiddleName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>security.security_user.LOCALE_CODE</code>. User's Locale
     */
    public SecurityUserRecord setLocaleCode(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.LOCALE_CODE</code>. User's Locale
     */
    public String getLocaleCode() {
        return (String) get(9);
    }

    /**
     * Setter for <code>security.security_user.PASSWORD</code>. Password message
     * digested string
     */
    public SecurityUserRecord setPassword(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.PASSWORD</code>. Password message
     * digested string
     */
    public String getPassword() {
        return (String) get(10);
    }

    /**
     * Setter for <code>security.security_user.PASSWORD_HASHED</code>. Password
     * stored is hashed or not
     */
    public SecurityUserRecord setPasswordHashed(Byte value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.PASSWORD_HASHED</code>. Password
     * stored is hashed or not
     */
    public Byte getPasswordHashed() {
        return (Byte) get(11);
    }

    /**
     * Setter for <code>security.security_user.ACCOUNT_NON_EXPIRED</code>. If
     * false, means user is expired
     */
    public SecurityUserRecord setAccountNonExpired(Byte value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.ACCOUNT_NON_EXPIRED</code>. If
     * false, means user is expired
     */
    public Byte getAccountNonExpired() {
        return (Byte) get(12);
    }

    /**
     * Setter for <code>security.security_user.ACCOUNT_NON_LOCKED</code>. If
     * false, means user is locked
     */
    public SecurityUserRecord setAccountNonLocked(Byte value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.ACCOUNT_NON_LOCKED</code>. If
     * false, means user is locked
     */
    public Byte getAccountNonLocked() {
        return (Byte) get(13);
    }

    /**
     * Setter for <code>security.security_user.CREDENTIALS_NON_EXPIRED</code>.
     * If flase, password is expired
     */
    public SecurityUserRecord setCredentialsNonExpired(Byte value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.CREDENTIALS_NON_EXPIRED</code>.
     * If flase, password is expired
     */
    public Byte getCredentialsNonExpired() {
        return (Byte) get(14);
    }

    /**
     * Setter for <code>security.security_user.NO_FAILED_ATTEMPT</code>. No of
     * failed attempts
     */
    public SecurityUserRecord setNoFailedAttempt(Short value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.NO_FAILED_ATTEMPT</code>. No of
     * failed attempts
     */
    public Short getNoFailedAttempt() {
        return (Short) get(15);
    }

    /**
     * Setter for <code>security.security_user.STATUS_CODE</code>. Status of the
     * user
     */
    public SecurityUserRecord setStatusCode(SecurityUserStatusCode value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.STATUS_CODE</code>. Status of the
     * user
     */
    public SecurityUserStatusCode getStatusCode() {
        return (SecurityUserStatusCode) get(16);
    }

    /**
     * Setter for <code>security.security_user.CREATED_BY</code>. ID of the user
     * who created this row
     */
    public SecurityUserRecord setCreatedBy(ULong value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.CREATED_BY</code>. ID of the user
     * who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(17);
    }

    /**
     * Setter for <code>security.security_user.CREATED_AT</code>. Time when this
     * row is created
     */
    public SecurityUserRecord setCreatedAt(LocalDateTime value) {
        set(18, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.CREATED_AT</code>. Time when this
     * row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(18);
    }

    /**
     * Setter for <code>security.security_user.UPDATED_BY</code>. ID of the user
     * who updated this row
     */
    public SecurityUserRecord setUpdatedBy(ULong value) {
        set(19, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.UPDATED_BY</code>. ID of the user
     * who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(19);
    }

    /**
     * Setter for <code>security.security_user.UPDATED_AT</code>. Time when this
     * row is updated
     */
    public SecurityUserRecord setUpdatedAt(LocalDateTime value) {
        set(20, value);
        return this;
    }

    /**
     * Getter for <code>security.security_user.UPDATED_AT</code>. Time when this
     * row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(20);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record21 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row21<ULong, ULong, String, String, String, String, String, String, String, String, String, Byte, Byte, Byte, Byte, Short, SecurityUserStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row21) super.fieldsRow();
    }

    @Override
    public Row21<ULong, ULong, String, String, String, String, String, String, String, String, String, Byte, Byte, Byte, Byte, Short, SecurityUserStatusCode, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row21) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityUser.SECURITY_USER.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityUser.SECURITY_USER.CLIENT_ID;
    }

    @Override
    public Field<String> field3() {
        return SecurityUser.SECURITY_USER.USER_NAME;
    }

    @Override
    public Field<String> field4() {
        return SecurityUser.SECURITY_USER.EMAIL_ID;
    }

    @Override
    public Field<String> field5() {
        return SecurityUser.SECURITY_USER.PHONE_NUMBER;
    }

    @Override
    public Field<String> field6() {
        return SecurityUser.SECURITY_USER.FIRST_NAME;
    }

    @Override
    public Field<String> field7() {
        return SecurityUser.SECURITY_USER.LAST_NAME;
    }

    @Override
    public Field<String> field8() {
        return SecurityUser.SECURITY_USER.DESIGNATION;
    }

    @Override
    public Field<String> field9() {
        return SecurityUser.SECURITY_USER.MIDDLE_NAME;
    }

    @Override
    public Field<String> field10() {
        return SecurityUser.SECURITY_USER.LOCALE_CODE;
    }

    @Override
    public Field<String> field11() {
        return SecurityUser.SECURITY_USER.PASSWORD;
    }

    @Override
    public Field<Byte> field12() {
        return SecurityUser.SECURITY_USER.PASSWORD_HASHED;
    }

    @Override
    public Field<Byte> field13() {
        return SecurityUser.SECURITY_USER.ACCOUNT_NON_EXPIRED;
    }

    @Override
    public Field<Byte> field14() {
        return SecurityUser.SECURITY_USER.ACCOUNT_NON_LOCKED;
    }

    @Override
    public Field<Byte> field15() {
        return SecurityUser.SECURITY_USER.CREDENTIALS_NON_EXPIRED;
    }

    @Override
    public Field<Short> field16() {
        return SecurityUser.SECURITY_USER.NO_FAILED_ATTEMPT;
    }

    @Override
    public Field<SecurityUserStatusCode> field17() {
        return SecurityUser.SECURITY_USER.STATUS_CODE;
    }

    @Override
    public Field<ULong> field18() {
        return SecurityUser.SECURITY_USER.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field19() {
        return SecurityUser.SECURITY_USER.CREATED_AT;
    }

    @Override
    public Field<ULong> field20() {
        return SecurityUser.SECURITY_USER.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field21() {
        return SecurityUser.SECURITY_USER.UPDATED_AT;
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
        return getUserName();
    }

    @Override
    public String component4() {
        return getEmailId();
    }

    @Override
    public String component5() {
        return getPhoneNumber();
    }

    @Override
    public String component6() {
        return getFirstName();
    }

    @Override
    public String component7() {
        return getLastName();
    }

    @Override
    public String component8() {
        return getDesignation();
    }

    @Override
    public String component9() {
        return getMiddleName();
    }

    @Override
    public String component10() {
        return getLocaleCode();
    }

    @Override
    public String component11() {
        return getPassword();
    }

    @Override
    public Byte component12() {
        return getPasswordHashed();
    }

    @Override
    public Byte component13() {
        return getAccountNonExpired();
    }

    @Override
    public Byte component14() {
        return getAccountNonLocked();
    }

    @Override
    public Byte component15() {
        return getCredentialsNonExpired();
    }

    @Override
    public Short component16() {
        return getNoFailedAttempt();
    }

    @Override
    public SecurityUserStatusCode component17() {
        return getStatusCode();
    }

    @Override
    public ULong component18() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component19() {
        return getCreatedAt();
    }

    @Override
    public ULong component20() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component21() {
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
        return getUserName();
    }

    @Override
    public String value4() {
        return getEmailId();
    }

    @Override
    public String value5() {
        return getPhoneNumber();
    }

    @Override
    public String value6() {
        return getFirstName();
    }

    @Override
    public String value7() {
        return getLastName();
    }

    @Override
    public String value8() {
        return getDesignation();
    }

    @Override
    public String value9() {
        return getMiddleName();
    }

    @Override
    public String value10() {
        return getLocaleCode();
    }

    @Override
    public String value11() {
        return getPassword();
    }

    @Override
    public Byte value12() {
        return getPasswordHashed();
    }

    @Override
    public Byte value13() {
        return getAccountNonExpired();
    }

    @Override
    public Byte value14() {
        return getAccountNonLocked();
    }

    @Override
    public Byte value15() {
        return getCredentialsNonExpired();
    }

    @Override
    public Short value16() {
        return getNoFailedAttempt();
    }

    @Override
    public SecurityUserStatusCode value17() {
        return getStatusCode();
    }

    @Override
    public ULong value18() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value19() {
        return getCreatedAt();
    }

    @Override
    public ULong value20() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value21() {
        return getUpdatedAt();
    }

    @Override
    public SecurityUserRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityUserRecord value2(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityUserRecord value3(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public SecurityUserRecord value4(String value) {
        setEmailId(value);
        return this;
    }

    @Override
    public SecurityUserRecord value5(String value) {
        setPhoneNumber(value);
        return this;
    }

    @Override
    public SecurityUserRecord value6(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public SecurityUserRecord value7(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public SecurityUserRecord value8(String value) {
        setDesignation(value);
        return this;
    }

    @Override
    public SecurityUserRecord value9(String value) {
        setMiddleName(value);
        return this;
    }

    @Override
    public SecurityUserRecord value10(String value) {
        setLocaleCode(value);
        return this;
    }

    @Override
    public SecurityUserRecord value11(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public SecurityUserRecord value12(Byte value) {
        setPasswordHashed(value);
        return this;
    }

    @Override
    public SecurityUserRecord value13(Byte value) {
        setAccountNonExpired(value);
        return this;
    }

    @Override
    public SecurityUserRecord value14(Byte value) {
        setAccountNonLocked(value);
        return this;
    }

    @Override
    public SecurityUserRecord value15(Byte value) {
        setCredentialsNonExpired(value);
        return this;
    }

    @Override
    public SecurityUserRecord value16(Short value) {
        setNoFailedAttempt(value);
        return this;
    }

    @Override
    public SecurityUserRecord value17(SecurityUserStatusCode value) {
        setStatusCode(value);
        return this;
    }

    @Override
    public SecurityUserRecord value18(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecurityUserRecord value19(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecurityUserRecord value20(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public SecurityUserRecord value21(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public SecurityUserRecord values(ULong value1, ULong value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, Byte value12, Byte value13, Byte value14, Byte value15, Short value16, SecurityUserStatusCode value17, ULong value18, LocalDateTime value19, ULong value20, LocalDateTime value21) {
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
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityUserRecord
     */
    public SecurityUserRecord() {
        super(SecurityUser.SECURITY_USER);
    }

    /**
     * Create a detached, initialised SecurityUserRecord
     */
    public SecurityUserRecord(ULong id, ULong clientId, String userName, String emailId, String phoneNumber, String firstName, String lastName, String designation, String middleName, String localeCode, String password, Byte passwordHashed, Byte accountNonExpired, Byte accountNonLocked, Byte credentialsNonExpired, Short noFailedAttempt, SecurityUserStatusCode statusCode, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(SecurityUser.SECURITY_USER);

        setId(id);
        setClientId(clientId);
        setUserName(userName);
        setEmailId(emailId);
        setPhoneNumber(phoneNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setDesignation(designation);
        setMiddleName(middleName);
        setLocaleCode(localeCode);
        setPassword(password);
        setPasswordHashed(passwordHashed);
        setAccountNonExpired(accountNonExpired);
        setAccountNonLocked(accountNonLocked);
        setCredentialsNonExpired(credentialsNonExpired);
        setNoFailedAttempt(noFailedAttempt);
        setStatusCode(statusCode);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
