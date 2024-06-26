/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.enums.SecurityClientStatusCode;
import com.fincity.security.jooq.tables.records.SecurityClientRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function12;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row12;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityClient extends TableImpl<SecurityClientRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_client</code>
     */
    public static final SecurityClient SECURITY_CLIENT = new SecurityClient();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityClientRecord> getRecordType() {
        return SecurityClientRecord.class;
    }

    /**
     * The column <code>security.security_client.ID</code>. Primary key
     */
    public final TableField<SecurityClientRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_client.CODE</code>. Client code
     */
    public final TableField<SecurityClientRecord, String> CODE = createField(DSL.name("CODE"), SQLDataType.CHAR(8).nullable(false), this, "Client code");

    /**
     * The column <code>security.security_client.NAME</code>. Name of the client
     */
    public final TableField<SecurityClientRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(256).nullable(false), this, "Name of the client");

    /**
     * The column <code>security.security_client.TYPE_CODE</code>. Type of
     * client
     */
    public final TableField<SecurityClientRecord, String> TYPE_CODE = createField(DSL.name("TYPE_CODE"), SQLDataType.CHAR(4).nullable(false), this, "Type of client");

    /**
     * The column <code>security.security_client.TOKEN_VALIDITY_MINUTES</code>.
     * Token validity in minutes
     */
    public final TableField<SecurityClientRecord, UInteger> TOKEN_VALIDITY_MINUTES = createField(DSL.name("TOKEN_VALIDITY_MINUTES"), SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(DSL.inline("30", SQLDataType.INTEGERUNSIGNED)), this, "Token validity in minutes");

    /**
     * The column <code>security.security_client.LOCALE_CODE</code>. Client
     * default locale
     */
    public final TableField<SecurityClientRecord, String> LOCALE_CODE = createField(DSL.name("LOCALE_CODE"), SQLDataType.VARCHAR(10).defaultValue(DSL.inline("en-US", SQLDataType.VARCHAR)), this, "Client default locale");

    /**
     * The column <code>security.security_client.STATUS_CODE</code>. Status of
     * the client
     */
    public final TableField<SecurityClientRecord, SecurityClientStatusCode> STATUS_CODE = createField(DSL.name("STATUS_CODE"), SQLDataType.VARCHAR(8).defaultValue(DSL.inline("ACTIVE", SQLDataType.VARCHAR)).asEnumDataType(com.fincity.security.jooq.enums.SecurityClientStatusCode.class), this, "Status of the client");

    /**
     * The column <code>security.security_client.BUSINESS_TYPE</code>. At each
     * llevel of business client, customer and consumer there can be different
     * business types.
     */
    public final TableField<SecurityClientRecord, String> BUSINESS_TYPE = createField(DSL.name("BUSINESS_TYPE"), SQLDataType.CHAR(10).nullable(false).defaultValue(DSL.inline("COMMON", SQLDataType.CHAR)), this, "At each llevel of business client, customer and consumer there can be different business types.");

    /**
     * The column <code>security.security_client.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public final TableField<SecurityClientRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_client.CREATED_AT</code>. Time when
     * this row is created
     */
    public final TableField<SecurityClientRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    /**
     * The column <code>security.security_client.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public final TableField<SecurityClientRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>security.security_client.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public final TableField<SecurityClientRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is updated");

    private SecurityClient(Name alias, Table<SecurityClientRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityClient(Name alias, Table<SecurityClientRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_client</code> table reference
     */
    public SecurityClient(String alias) {
        this(DSL.name(alias), SECURITY_CLIENT);
    }

    /**
     * Create an aliased <code>security.security_client</code> table reference
     */
    public SecurityClient(Name alias) {
        this(alias, SECURITY_CLIENT);
    }

    /**
     * Create a <code>security.security_client</code> table reference
     */
    public SecurityClient() {
        this(DSL.name("security_client"), null);
    }

    public <O extends Record> SecurityClient(Table<O> child, ForeignKey<O, SecurityClientRecord> key) {
        super(child, key, SECURITY_CLIENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityClientRecord, ULong> getIdentity() {
        return (Identity<SecurityClientRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityClientRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_CLIENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityClientRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_CLIENT_UK1_CLIENT_CODE);
    }

    @Override
    public List<ForeignKey<SecurityClientRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_CLIENT_CLIENT_TYPE_CODE);
    }

    private transient SecurityClientType _securityClientType;

    /**
     * Get the implicit join path to the
     * <code>security.security_client_type</code> table.
     */
    public SecurityClientType securityClientType() {
        if (_securityClientType == null)
            _securityClientType = new SecurityClientType(this, Keys.FK1_CLIENT_CLIENT_TYPE_CODE);

        return _securityClientType;
    }

    @Override
    public SecurityClient as(String alias) {
        return new SecurityClient(DSL.name(alias), this);
    }

    @Override
    public SecurityClient as(Name alias) {
        return new SecurityClient(alias, this);
    }

    @Override
    public SecurityClient as(Table<?> alias) {
        return new SecurityClient(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClient rename(String name) {
        return new SecurityClient(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClient rename(Name name) {
        return new SecurityClient(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClient rename(Table<?> name) {
        return new SecurityClient(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<ULong, String, String, String, UInteger, String, SecurityClientStatusCode, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function12<? super ULong, ? super String, ? super String, ? super String, ? super UInteger, ? super String, ? super SecurityClientStatusCode, ? super String, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function12<? super ULong, ? super String, ? super String, ? super String, ? super UInteger, ? super String, ? super SecurityClientStatusCode, ? super String, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
