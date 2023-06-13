/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityClientPackageRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class SecurityClientPackage extends TableImpl<SecurityClientPackageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_client_package</code>
     */
    public static final SecurityClientPackage SECURITY_CLIENT_PACKAGE = new SecurityClientPackage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityClientPackageRecord> getRecordType() {
        return SecurityClientPackageRecord.class;
    }

    /**
     * The column <code>security.security_client_package.ID</code>. Primary key
     */
    public final TableField<SecurityClientPackageRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_client_package.CLIENT_ID</code>.
     * Client ID
     */
    public final TableField<SecurityClientPackageRecord, ULong> CLIENT_ID = createField(DSL.name("CLIENT_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Client ID");

    /**
     * The column <code>security.security_client_package.PACKAGE_ID</code>.
     * Package ID
     */
    public final TableField<SecurityClientPackageRecord, ULong> PACKAGE_ID = createField(DSL.name("PACKAGE_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Package ID");

    private SecurityClientPackage(Name alias, Table<SecurityClientPackageRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityClientPackage(Name alias, Table<SecurityClientPackageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_client_package</code> table
     * reference
     */
    public SecurityClientPackage(String alias) {
        this(DSL.name(alias), SECURITY_CLIENT_PACKAGE);
    }

    /**
     * Create an aliased <code>security.security_client_package</code> table
     * reference
     */
    public SecurityClientPackage(Name alias) {
        this(alias, SECURITY_CLIENT_PACKAGE);
    }

    /**
     * Create a <code>security.security_client_package</code> table reference
     */
    public SecurityClientPackage() {
        this(DSL.name("security_client_package"), null);
    }

    public <O extends Record> SecurityClientPackage(Table<O> child, ForeignKey<O, SecurityClientPackageRecord> key) {
        super(child, key, SECURITY_CLIENT_PACKAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityClientPackageRecord, ULong> getIdentity() {
        return (Identity<SecurityClientPackageRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityClientPackageRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_CLIENT_PACKAGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityClientPackageRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_CLIENT_PACKAGE_UK1_CLIENT_PACKAGE);
    }

    @Override
    public List<ForeignKey<SecurityClientPackageRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_CLIENT_PACKAGE_CLIENT_ID, Keys.FK2_CLIENT_PACKAGE_PACKAGE_ID);
    }

    private transient SecurityClient _securityClient;
    private transient SecurityPackage _securityPackage;

    /**
     * Get the implicit join path to the <code>security.security_client</code>
     * table.
     */
    public SecurityClient securityClient() {
        if (_securityClient == null)
            _securityClient = new SecurityClient(this, Keys.FK1_CLIENT_PACKAGE_CLIENT_ID);

        return _securityClient;
    }

    /**
     * Get the implicit join path to the <code>security.security_package</code>
     * table.
     */
    public SecurityPackage securityPackage() {
        if (_securityPackage == null)
            _securityPackage = new SecurityPackage(this, Keys.FK2_CLIENT_PACKAGE_PACKAGE_ID);

        return _securityPackage;
    }

    @Override
    public SecurityClientPackage as(String alias) {
        return new SecurityClientPackage(DSL.name(alias), this);
    }

    @Override
    public SecurityClientPackage as(Name alias) {
        return new SecurityClientPackage(alias, this);
    }

    @Override
    public SecurityClientPackage as(Table<?> alias) {
        return new SecurityClientPackage(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientPackage rename(String name) {
        return new SecurityClientPackage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientPackage rename(Name name) {
        return new SecurityClientPackage(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientPackage rename(Table<?> name) {
        return new SecurityClientPackage(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<ULong, ULong, ULong> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super ULong, ? super ULong, ? super ULong, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super ULong, ? super ULong, ? super ULong, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
