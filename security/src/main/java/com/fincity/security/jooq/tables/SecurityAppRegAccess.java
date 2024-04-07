/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityAppRegAccessRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
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
public class SecurityAppRegAccess extends TableImpl<SecurityAppRegAccessRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_app_reg_access</code>
     */
    public static final SecurityAppRegAccess SECURITY_APP_REG_ACCESS = new SecurityAppRegAccess();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityAppRegAccessRecord> getRecordType() {
        return SecurityAppRegAccessRecord.class;
    }

    /**
     * The column <code>security.security_app_reg_access.ID</code>. Primary key
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_app_reg_access.CLIENT_ID</code>.
     * Client ID
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> CLIENT_ID = createField(DSL.name("CLIENT_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Client ID");

    /**
     * The column <code>security.security_app_reg_access.APP_ID</code>. App ID
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> APP_ID = createField(DSL.name("APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID");

    /**
     * The column <code>security.security_app_reg_access.DEP_APP_ID</code>. App
     * ID of the dependent app
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> DEP_APP_ID = createField(DSL.name("DEP_APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID of the dependent app");

    /**
     * The column <code>security.security_app_reg_access.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_app_reg_access.CREATED_AT</code>. Time
     * when this row is created
     */
    public final TableField<SecurityAppRegAccessRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    /**
     * The column <code>security.security_app_reg_access.UPDATED_BY</code>. ID
     * of the user who updated this row
     */
    public final TableField<SecurityAppRegAccessRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>security.security_app_reg_access.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public final TableField<SecurityAppRegAccessRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is updated");

    private SecurityAppRegAccess(Name alias, Table<SecurityAppRegAccessRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityAppRegAccess(Name alias, Table<SecurityAppRegAccessRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_app_reg_access</code> table
     * reference
     */
    public SecurityAppRegAccess(String alias) {
        this(DSL.name(alias), SECURITY_APP_REG_ACCESS);
    }

    /**
     * Create an aliased <code>security.security_app_reg_access</code> table
     * reference
     */
    public SecurityAppRegAccess(Name alias) {
        this(alias, SECURITY_APP_REG_ACCESS);
    }

    /**
     * Create a <code>security.security_app_reg_access</code> table reference
     */
    public SecurityAppRegAccess() {
        this(DSL.name("security_app_reg_access"), null);
    }

    public <O extends Record> SecurityAppRegAccess(Table<O> child, ForeignKey<O, SecurityAppRegAccessRecord> key) {
        super(child, key, SECURITY_APP_REG_ACCESS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityAppRegAccessRecord, ULong> getIdentity() {
        return (Identity<SecurityAppRegAccessRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityAppRegAccessRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_APP_REG_ACCESS_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityAppRegAccessRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_APP_REG_ACCESS_CLIENT_ID);
    }

    @Override
    public List<ForeignKey<SecurityAppRegAccessRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_APP_REG_ACC_CLNT_ID, Keys.FK2_APP_REG_ACC_APP_ID, Keys.FK3_APP_REG_ACC_DEP_APP_ID);
    }

    private transient SecurityClient _securityClient;
    private transient SecurityApp _fk2AppRegAccAppId;
    private transient SecurityApp _fk3AppRegAccDepAppId;

    /**
     * Get the implicit join path to the <code>security.security_client</code>
     * table.
     */
    public SecurityClient securityClient() {
        if (_securityClient == null)
            _securityClient = new SecurityClient(this, Keys.FK1_APP_REG_ACC_CLNT_ID);

        return _securityClient;
    }

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table, via the <code>FK2_APP_REG_ACC_APP_ID</code> key.
     */
    public SecurityApp fk2AppRegAccAppId() {
        if (_fk2AppRegAccAppId == null)
            _fk2AppRegAccAppId = new SecurityApp(this, Keys.FK2_APP_REG_ACC_APP_ID);

        return _fk2AppRegAccAppId;
    }

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table, via the <code>FK3_APP_REG_ACC_DEP_APP_ID</code> key.
     */
    public SecurityApp fk3AppRegAccDepAppId() {
        if (_fk3AppRegAccDepAppId == null)
            _fk3AppRegAccDepAppId = new SecurityApp(this, Keys.FK3_APP_REG_ACC_DEP_APP_ID);

        return _fk3AppRegAccDepAppId;
    }

    @Override
    public SecurityAppRegAccess as(String alias) {
        return new SecurityAppRegAccess(DSL.name(alias), this);
    }

    @Override
    public SecurityAppRegAccess as(Name alias) {
        return new SecurityAppRegAccess(alias, this);
    }

    @Override
    public SecurityAppRegAccess as(Table<?> alias) {
        return new SecurityAppRegAccess(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegAccess rename(String name) {
        return new SecurityAppRegAccess(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegAccess rename(Name name) {
        return new SecurityAppRegAccess(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegAccess rename(Table<?> name) {
        return new SecurityAppRegAccess(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<ULong, ULong, ULong, ULong, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
