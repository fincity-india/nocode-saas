/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.enums.SecurityAppRegPackageLevel;
import com.fincity.security.jooq.tables.records.SecurityAppRegPackageRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
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
public class SecurityAppRegPackage extends TableImpl<SecurityAppRegPackageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_app_reg_package</code>
     */
    public static final SecurityAppRegPackage SECURITY_APP_REG_PACKAGE = new SecurityAppRegPackage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityAppRegPackageRecord> getRecordType() {
        return SecurityAppRegPackageRecord.class;
    }

    /**
     * The column <code>security.security_app_reg_package.ID</code>. Primary key
     */
    public final TableField<SecurityAppRegPackageRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_app_reg_package.CLIENT_ID</code>.
     * Client ID
     */
    public final TableField<SecurityAppRegPackageRecord, ULong> CLIENT_ID = createField(DSL.name("CLIENT_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Client ID");

    /**
     * The column <code>security.security_app_reg_package.CLIENT_TYPE</code>.
     * Client type
     */
    public final TableField<SecurityAppRegPackageRecord, String> CLIENT_TYPE = createField(DSL.name("CLIENT_TYPE"), SQLDataType.CHAR(4).nullable(false).defaultValue(DSL.inline("BUS", SQLDataType.CHAR)), this, "Client type");

    /**
     * The column <code>security.security_app_reg_package.APP_ID</code>. App ID
     */
    public final TableField<SecurityAppRegPackageRecord, ULong> APP_ID = createField(DSL.name("APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID");

    /**
     * The column <code>security.security_app_reg_package.PACKAGE_ID</code>.
     * Package ID
     */
    public final TableField<SecurityAppRegPackageRecord, ULong> PACKAGE_ID = createField(DSL.name("PACKAGE_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Package ID");

    /**
     * The column <code>security.security_app_reg_package.LEVEL</code>. Access
     * level
     */
    public final TableField<SecurityAppRegPackageRecord, SecurityAppRegPackageLevel> LEVEL = createField(DSL.name("LEVEL"), SQLDataType.VARCHAR(8).nullable(false).defaultValue(DSL.inline("CLIENT", SQLDataType.VARCHAR)).asEnumDataType(com.fincity.security.jooq.enums.SecurityAppRegPackageLevel.class), this, "Access level");

    /**
     * The column <code>security.security_app_reg_package.BUSINESS_TYPE</code>.
     * Business type
     */
    public final TableField<SecurityAppRegPackageRecord, String> BUSINESS_TYPE = createField(DSL.name("BUSINESS_TYPE"), SQLDataType.CHAR(10).nullable(false).defaultValue(DSL.inline("COMMON", SQLDataType.CHAR)), this, "Business type");

    /**
     * The column <code>security.security_app_reg_package.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public final TableField<SecurityAppRegPackageRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_app_reg_package.CREATED_AT</code>.
     * Time when this row is created
     */
    public final TableField<SecurityAppRegPackageRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    private SecurityAppRegPackage(Name alias, Table<SecurityAppRegPackageRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityAppRegPackage(Name alias, Table<SecurityAppRegPackageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_app_reg_package</code> table
     * reference
     */
    public SecurityAppRegPackage(String alias) {
        this(DSL.name(alias), SECURITY_APP_REG_PACKAGE);
    }

    /**
     * Create an aliased <code>security.security_app_reg_package</code> table
     * reference
     */
    public SecurityAppRegPackage(Name alias) {
        this(alias, SECURITY_APP_REG_PACKAGE);
    }

    /**
     * Create a <code>security.security_app_reg_package</code> table reference
     */
    public SecurityAppRegPackage() {
        this(DSL.name("security_app_reg_package"), null);
    }

    public <O extends Record> SecurityAppRegPackage(Table<O> child, ForeignKey<O, SecurityAppRegPackageRecord> key) {
        super(child, key, SECURITY_APP_REG_PACKAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityAppRegPackageRecord, ULong> getIdentity() {
        return (Identity<SecurityAppRegPackageRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityAppRegPackageRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_APP_REG_PACKAGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityAppRegPackageRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_APP_REG_PACKAGE_CLIENT_ID);
    }

    @Override
    public List<ForeignKey<SecurityAppRegPackageRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_APP_REG_PKG_CLNT_ID, Keys.FK4_APP_REG_PKG_CLIENT_TYPE, Keys.FK2_APP_REG_PKG_APP_ID, Keys.FK3_APP_REG_PKG_PKG_ID);
    }

    private transient SecurityClient _securityClient;
    private transient SecurityClientType _securityClientType;
    private transient SecurityApp _securityApp;
    private transient SecurityPackage _securityPackage;

    /**
     * Get the implicit join path to the <code>security.security_client</code>
     * table.
     */
    public SecurityClient securityClient() {
        if (_securityClient == null)
            _securityClient = new SecurityClient(this, Keys.FK1_APP_REG_PKG_CLNT_ID);

        return _securityClient;
    }

    /**
     * Get the implicit join path to the
     * <code>security.security_client_type</code> table.
     */
    public SecurityClientType securityClientType() {
        if (_securityClientType == null)
            _securityClientType = new SecurityClientType(this, Keys.FK4_APP_REG_PKG_CLIENT_TYPE);

        return _securityClientType;
    }

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table.
     */
    public SecurityApp securityApp() {
        if (_securityApp == null)
            _securityApp = new SecurityApp(this, Keys.FK2_APP_REG_PKG_APP_ID);

        return _securityApp;
    }

    /**
     * Get the implicit join path to the <code>security.security_package</code>
     * table.
     */
    public SecurityPackage securityPackage() {
        if (_securityPackage == null)
            _securityPackage = new SecurityPackage(this, Keys.FK3_APP_REG_PKG_PKG_ID);

        return _securityPackage;
    }

    @Override
    public SecurityAppRegPackage as(String alias) {
        return new SecurityAppRegPackage(DSL.name(alias), this);
    }

    @Override
    public SecurityAppRegPackage as(Name alias) {
        return new SecurityAppRegPackage(alias, this);
    }

    @Override
    public SecurityAppRegPackage as(Table<?> alias) {
        return new SecurityAppRegPackage(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegPackage rename(String name) {
        return new SecurityAppRegPackage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegPackage rename(Name name) {
        return new SecurityAppRegPackage(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppRegPackage rename(Table<?> name) {
        return new SecurityAppRegPackage(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<ULong, ULong, String, ULong, ULong, SecurityAppRegPackageLevel, String, ULong, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super ULong, ? super ULong, ? super String, ? super ULong, ? super ULong, ? super SecurityAppRegPackageLevel, ? super String, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super ULong, ? super ULong, ? super String, ? super ULong, ? super ULong, ? super SecurityAppRegPackageLevel, ? super String, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
