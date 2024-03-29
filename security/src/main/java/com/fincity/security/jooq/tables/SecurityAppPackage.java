/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityAppPackageRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
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
public class SecurityAppPackage extends TableImpl<SecurityAppPackageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_app_package</code>
     */
    public static final SecurityAppPackage SECURITY_APP_PACKAGE = new SecurityAppPackage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityAppPackageRecord> getRecordType() {
        return SecurityAppPackageRecord.class;
    }

    /**
     * The column <code>security.security_app_package.ID</code>. Primary key
     */
    public final TableField<SecurityAppPackageRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_app_package.CLIENT_ID</code>. Client
     * ID for which this APP PACKAGE relation belongs to
     */
    public final TableField<SecurityAppPackageRecord, ULong> CLIENT_ID = createField(DSL.name("CLIENT_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Client ID for which this APP PACKAGE relation belongs to");

    /**
     * The column <code>security.security_app_package.APP_ID</code>. App ID for
     * which this APP belongs to
     */
    public final TableField<SecurityAppPackageRecord, ULong> APP_ID = createField(DSL.name("APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID for which this APP belongs to");

    /**
     * The column <code>security.security_app_package.PACKAGE_ID</code>. Package
     * ID
     */
    public final TableField<SecurityAppPackageRecord, ULong> PACKAGE_ID = createField(DSL.name("PACKAGE_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Package ID");

    private SecurityAppPackage(Name alias, Table<SecurityAppPackageRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityAppPackage(Name alias, Table<SecurityAppPackageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_app_package</code> table
     * reference
     */
    public SecurityAppPackage(String alias) {
        this(DSL.name(alias), SECURITY_APP_PACKAGE);
    }

    /**
     * Create an aliased <code>security.security_app_package</code> table
     * reference
     */
    public SecurityAppPackage(Name alias) {
        this(alias, SECURITY_APP_PACKAGE);
    }

    /**
     * Create a <code>security.security_app_package</code> table reference
     */
    public SecurityAppPackage() {
        this(DSL.name("security_app_package"), null);
    }

    public <O extends Record> SecurityAppPackage(Table<O> child, ForeignKey<O, SecurityAppPackageRecord> key) {
        super(child, key, SECURITY_APP_PACKAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityAppPackageRecord, ULong> getIdentity() {
        return (Identity<SecurityAppPackageRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityAppPackageRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_APP_PACKAGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityAppPackageRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_APP_PACKAGE_CLIENT_ID);
    }

    @Override
    public List<ForeignKey<SecurityAppPackageRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_APP_PCK_CLIENT_ID, Keys.FK2_APP_PCK_APP_ID, Keys.FK3_APP_PCK_PCK_ID);
    }

    private transient SecurityClient _securityClient;
    private transient SecurityApp _securityApp;
    private transient SecurityPackage _securityPackage;

    /**
     * Get the implicit join path to the <code>security.security_client</code>
     * table.
     */
    public SecurityClient securityClient() {
        if (_securityClient == null)
            _securityClient = new SecurityClient(this, Keys.FK1_APP_PCK_CLIENT_ID);

        return _securityClient;
    }

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table.
     */
    public SecurityApp securityApp() {
        if (_securityApp == null)
            _securityApp = new SecurityApp(this, Keys.FK2_APP_PCK_APP_ID);

        return _securityApp;
    }

    /**
     * Get the implicit join path to the <code>security.security_package</code>
     * table.
     */
    public SecurityPackage securityPackage() {
        if (_securityPackage == null)
            _securityPackage = new SecurityPackage(this, Keys.FK3_APP_PCK_PCK_ID);

        return _securityPackage;
    }

    @Override
    public SecurityAppPackage as(String alias) {
        return new SecurityAppPackage(DSL.name(alias), this);
    }

    @Override
    public SecurityAppPackage as(Name alias) {
        return new SecurityAppPackage(alias, this);
    }

    @Override
    public SecurityAppPackage as(Table<?> alias) {
        return new SecurityAppPackage(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppPackage rename(String name) {
        return new SecurityAppPackage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppPackage rename(Name name) {
        return new SecurityAppPackage(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppPackage rename(Table<?> name) {
        return new SecurityAppPackage(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<ULong, ULong, ULong, ULong> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
