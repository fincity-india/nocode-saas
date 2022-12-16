/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Index;
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

import com.fincity.security.jooq.Indexes;
import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityUserRolePermissionRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityUserRolePermission extends TableImpl<SecurityUserRolePermissionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>security.security_user_role_permission</code>
     */
    public static final SecurityUserRolePermission SECURITY_USER_ROLE_PERMISSION = new SecurityUserRolePermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityUserRolePermissionRecord> getRecordType() {
        return SecurityUserRolePermissionRecord.class;
    }

    /**
     * The column <code>security.security_user_role_permission.ID</code>.
     * Primary key
     */
    public final TableField<SecurityUserRolePermissionRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_user_role_permission.USER_ID</code>.
     * User ID
     */
    public final TableField<SecurityUserRolePermissionRecord, ULong> USER_ID = createField(DSL.name("USER_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "User ID");

    /**
     * The column <code>security.security_user_role_permission.ROLE_ID</code>.
     * Role ID
     */
    public final TableField<SecurityUserRolePermissionRecord, ULong> ROLE_ID = createField(DSL.name("ROLE_ID"), SQLDataType.BIGINTUNSIGNED, this, "Role ID");

    /**
     * The column
     * <code>security.security_user_role_permission.PERMISSION_ID</code>.
     * Permission ID
     */
    public final TableField<SecurityUserRolePermissionRecord, ULong> PERMISSION_ID = createField(DSL.name("PERMISSION_ID"), SQLDataType.BIGINTUNSIGNED, this, "Permission ID");

    private SecurityUserRolePermission(Name alias, Table<SecurityUserRolePermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityUserRolePermission(Name alias, Table<SecurityUserRolePermissionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_user_role_permission</code>
     * table reference
     */
    public SecurityUserRolePermission(String alias) {
        this(DSL.name(alias), SECURITY_USER_ROLE_PERMISSION);
    }

    /**
     * Create an aliased <code>security.security_user_role_permission</code>
     * table reference
     */
    public SecurityUserRolePermission(Name alias) {
        this(alias, SECURITY_USER_ROLE_PERMISSION);
    }

    /**
     * Create a <code>security.security_user_role_permission</code> table
     * reference
     */
    public SecurityUserRolePermission() {
        this(DSL.name("security_user_role_permission"), null);
    }

    public <O extends Record> SecurityUserRolePermission(Table<O> child, ForeignKey<O, SecurityUserRolePermissionRecord> key) {
        super(child, key, SECURITY_USER_ROLE_PERMISSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.SECURITY_USER_ROLE_PERMISSION_UK1_USER);
    }

    @Override
    public Identity<SecurityUserRolePermissionRecord, ULong> getIdentity() {
        return (Identity<SecurityUserRolePermissionRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityUserRolePermissionRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_USER_ROLE_PERMISSION_PRIMARY;
    }

    @Override
    public List<ForeignKey<SecurityUserRolePermissionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_USER_ROLE_USER_ID, Keys.FK2_USER_ROLE_ROLE_ID, Keys.FK3_USER_ROLE_PERMISSION_ID);
    }

    private transient SecurityUser _securityUser;
    private transient SecurityRole _securityRole;
    private transient SecurityPermission _securityPermission;

    /**
     * Get the implicit join path to the <code>security.security_user</code>
     * table.
     */
    public SecurityUser securityUser() {
        if (_securityUser == null)
            _securityUser = new SecurityUser(this, Keys.FK1_USER_ROLE_USER_ID);

        return _securityUser;
    }

    /**
     * Get the implicit join path to the <code>security.security_role</code>
     * table.
     */
    public SecurityRole securityRole() {
        if (_securityRole == null)
            _securityRole = new SecurityRole(this, Keys.FK2_USER_ROLE_ROLE_ID);

        return _securityRole;
    }

    /**
     * Get the implicit join path to the
     * <code>security.security_permission</code> table.
     */
    public SecurityPermission securityPermission() {
        if (_securityPermission == null)
            _securityPermission = new SecurityPermission(this, Keys.FK3_USER_ROLE_PERMISSION_ID);

        return _securityPermission;
    }

    @Override
    public SecurityUserRolePermission as(String alias) {
        return new SecurityUserRolePermission(DSL.name(alias), this);
    }

    @Override
    public SecurityUserRolePermission as(Name alias) {
        return new SecurityUserRolePermission(alias, this);
    }

    @Override
    public SecurityUserRolePermission as(Table<?> alias) {
        return new SecurityUserRolePermission(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityUserRolePermission rename(String name) {
        return new SecurityUserRolePermission(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityUserRolePermission rename(Name name) {
        return new SecurityUserRolePermission(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityUserRolePermission rename(Table<?> name) {
        return new SecurityUserRolePermission(name.getQualifiedName(), null);
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
