/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityClientAddressRecord;

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
public class SecurityClientAddress extends TableImpl<SecurityClientAddressRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_client_address</code>
     */
    public static final SecurityClientAddress SECURITY_CLIENT_ADDRESS = new SecurityClientAddress();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityClientAddressRecord> getRecordType() {
        return SecurityClientAddressRecord.class;
    }

    /**
     * The column <code>security.security_client_address.ID</code>. Primary key
     */
    public final TableField<SecurityClientAddressRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_client_address.CLIENT_ID</code>.
     * Client ID
     */
    public final TableField<SecurityClientAddressRecord, ULong> CLIENT_ID = createField(DSL.name("CLIENT_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Client ID");

    /**
     * The column <code>security.security_client_address.ADDRESS_ID</code>.
     * Address ID
     */
    public final TableField<SecurityClientAddressRecord, ULong> ADDRESS_ID = createField(DSL.name("ADDRESS_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Address ID");

    private SecurityClientAddress(Name alias, Table<SecurityClientAddressRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityClientAddress(Name alias, Table<SecurityClientAddressRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_client_address</code> table
     * reference
     */
    public SecurityClientAddress(String alias) {
        this(DSL.name(alias), SECURITY_CLIENT_ADDRESS);
    }

    /**
     * Create an aliased <code>security.security_client_address</code> table
     * reference
     */
    public SecurityClientAddress(Name alias) {
        this(alias, SECURITY_CLIENT_ADDRESS);
    }

    /**
     * Create a <code>security.security_client_address</code> table reference
     */
    public SecurityClientAddress() {
        this(DSL.name("security_client_address"), null);
    }

    public <O extends Record> SecurityClientAddress(Table<O> child, ForeignKey<O, SecurityClientAddressRecord> key) {
        super(child, key, SECURITY_CLIENT_ADDRESS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityClientAddressRecord, ULong> getIdentity() {
        return (Identity<SecurityClientAddressRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityClientAddressRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_CLIENT_ADDRESS_PRIMARY;
    }

    @Override
    public List<ForeignKey<SecurityClientAddressRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_CLIENT_ADDRESS_CLIENT_ID, Keys.FK2_CLIENT_ADDRESS_ADDRESS_ID);
    }

    private transient SecurityClient _securityClient;
    private transient SecurityAddress _securityAddress;

    /**
     * Get the implicit join path to the <code>security.security_client</code>
     * table.
     */
    public SecurityClient securityClient() {
        if (_securityClient == null)
            _securityClient = new SecurityClient(this, Keys.FK1_CLIENT_ADDRESS_CLIENT_ID);

        return _securityClient;
    }

    /**
     * Get the implicit join path to the <code>security.security_address</code>
     * table.
     */
    public SecurityAddress securityAddress() {
        if (_securityAddress == null)
            _securityAddress = new SecurityAddress(this, Keys.FK2_CLIENT_ADDRESS_ADDRESS_ID);

        return _securityAddress;
    }

    @Override
    public SecurityClientAddress as(String alias) {
        return new SecurityClientAddress(DSL.name(alias), this);
    }

    @Override
    public SecurityClientAddress as(Name alias) {
        return new SecurityClientAddress(alias, this);
    }

    @Override
    public SecurityClientAddress as(Table<?> alias) {
        return new SecurityClientAddress(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientAddress rename(String name) {
        return new SecurityClientAddress(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientAddress rename(Name name) {
        return new SecurityClientAddress(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityClientAddress rename(Table<?> name) {
        return new SecurityClientAddress(name.getQualifiedName(), null);
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
