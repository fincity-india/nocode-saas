/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityPastPasswordsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityPastPasswords extends TableImpl<SecurityPastPasswordsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_past_passwords</code>
     */
    public static final SecurityPastPasswords SECURITY_PAST_PASSWORDS = new SecurityPastPasswords();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityPastPasswordsRecord> getRecordType() {
        return SecurityPastPasswordsRecord.class;
    }

    /**
     * The column <code>security.security_past_passwords.ID</code>. Primary key
     */
    public final TableField<SecurityPastPasswordsRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_past_passwords.USER_ID</code>. User ID
     */
    public final TableField<SecurityPastPasswordsRecord, ULong> USER_ID = createField(DSL.name("USER_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "User ID");

    /**
     * The column <code>security.security_past_passwords.PASSWORD</code>.
     * Password message digested string
     */
    public final TableField<SecurityPastPasswordsRecord, String> PASSWORD = createField(DSL.name("PASSWORD"), SQLDataType.VARCHAR(512), this, "Password message digested string");

    /**
     * The column <code>security.security_past_passwords.PASSWORD_HASHED</code>.
     * Password stored is hashed or not
     */
    public final TableField<SecurityPastPasswordsRecord, Byte> PASSWORD_HASHED = createField(DSL.name("PASSWORD_HASHED"), SQLDataType.TINYINT.defaultValue(DSL.inline("1", SQLDataType.TINYINT)), this, "Password stored is hashed or not");

    /**
     * The column <code>security.security_past_passwords.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public final TableField<SecurityPastPasswordsRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_past_passwords.CREATED_AT</code>. Time
     * when this row is created
     */
    public final TableField<SecurityPastPasswordsRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    private SecurityPastPasswords(Name alias, Table<SecurityPastPasswordsRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityPastPasswords(Name alias, Table<SecurityPastPasswordsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_past_passwords</code> table
     * reference
     */
    public SecurityPastPasswords(String alias) {
        this(DSL.name(alias), SECURITY_PAST_PASSWORDS);
    }

    /**
     * Create an aliased <code>security.security_past_passwords</code> table
     * reference
     */
    public SecurityPastPasswords(Name alias) {
        this(alias, SECURITY_PAST_PASSWORDS);
    }

    /**
     * Create a <code>security.security_past_passwords</code> table reference
     */
    public SecurityPastPasswords() {
        this(DSL.name("security_past_passwords"), null);
    }

    public <O extends Record> SecurityPastPasswords(Table<O> child, ForeignKey<O, SecurityPastPasswordsRecord> key) {
        super(child, key, SECURITY_PAST_PASSWORDS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityPastPasswordsRecord, ULong> getIdentity() {
        return (Identity<SecurityPastPasswordsRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityPastPasswordsRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_PAST_PASSWORDS_PRIMARY;
    }

    @Override
    public List<ForeignKey<SecurityPastPasswordsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_PAST_PASSWORD_USER_ID);
    }

    private transient SecurityUser _securityUser;

    /**
     * Get the implicit join path to the <code>security.security_user</code>
     * table.
     */
    public SecurityUser securityUser() {
        if (_securityUser == null)
            _securityUser = new SecurityUser(this, Keys.FK1_PAST_PASSWORD_USER_ID);

        return _securityUser;
    }

    @Override
    public SecurityPastPasswords as(String alias) {
        return new SecurityPastPasswords(DSL.name(alias), this);
    }

    @Override
    public SecurityPastPasswords as(Name alias) {
        return new SecurityPastPasswords(alias, this);
    }

    @Override
    public SecurityPastPasswords as(Table<?> alias) {
        return new SecurityPastPasswords(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityPastPasswords rename(String name) {
        return new SecurityPastPasswords(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityPastPasswords rename(Name name) {
        return new SecurityPastPasswords(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityPastPasswords rename(Table<?> name) {
        return new SecurityPastPasswords(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<ULong, ULong, String, Byte, ULong, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super ULong, ? super ULong, ? super String, ? super Byte, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super ULong, ? super ULong, ? super String, ? super Byte, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
