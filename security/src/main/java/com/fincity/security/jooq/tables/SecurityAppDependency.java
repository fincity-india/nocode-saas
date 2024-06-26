/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.tables.records.SecurityAppDependencyRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
public class SecurityAppDependency extends TableImpl<SecurityAppDependencyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_app_dependency</code>
     */
    public static final SecurityAppDependency SECURITY_APP_DEPENDENCY = new SecurityAppDependency();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecurityAppDependencyRecord> getRecordType() {
        return SecurityAppDependencyRecord.class;
    }

    /**
     * The column <code>security.security_app_dependency.ID</code>. Primary key
     */
    public final TableField<SecurityAppDependencyRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_app_dependency.APP_ID</code>. App ID
     */
    public final TableField<SecurityAppDependencyRecord, ULong> APP_ID = createField(DSL.name("APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID");

    /**
     * The column <code>security.security_app_dependency.DEP_APP_ID</code>. App
     * ID of the dependent app
     */
    public final TableField<SecurityAppDependencyRecord, ULong> DEP_APP_ID = createField(DSL.name("DEP_APP_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "App ID of the dependent app");

    /**
     * The column <code>security.security_app_dependency.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public final TableField<SecurityAppDependencyRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_app_dependency.CREATED_AT</code>. Time
     * when this row is created
     */
    public final TableField<SecurityAppDependencyRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    /**
     * The column <code>security.security_app_dependency.UPDATED_BY</code>. ID
     * of the user who updated this row
     */
    public final TableField<SecurityAppDependencyRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>security.security_app_dependency.UPDATED_AT</code>. Time
     * when this row is updated
     */
    public final TableField<SecurityAppDependencyRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is updated");

    private SecurityAppDependency(Name alias, Table<SecurityAppDependencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecurityAppDependency(Name alias, Table<SecurityAppDependencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_app_dependency</code> table
     * reference
     */
    public SecurityAppDependency(String alias) {
        this(DSL.name(alias), SECURITY_APP_DEPENDENCY);
    }

    /**
     * Create an aliased <code>security.security_app_dependency</code> table
     * reference
     */
    public SecurityAppDependency(Name alias) {
        this(alias, SECURITY_APP_DEPENDENCY);
    }

    /**
     * Create a <code>security.security_app_dependency</code> table reference
     */
    public SecurityAppDependency() {
        this(DSL.name("security_app_dependency"), null);
    }

    public <O extends Record> SecurityAppDependency(Table<O> child, ForeignKey<O, SecurityAppDependencyRecord> key) {
        super(child, key, SECURITY_APP_DEPENDENCY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecurityAppDependencyRecord, ULong> getIdentity() {
        return (Identity<SecurityAppDependencyRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecurityAppDependencyRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_APP_DEPENDENCY_PRIMARY;
    }

    @Override
    public List<UniqueKey<SecurityAppDependencyRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SECURITY_APP_DEPENDENCY_APP_ID);
    }

    @Override
    public List<ForeignKey<SecurityAppDependencyRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_APP_DEP_APP_ID, Keys.FK2_APP_DEP_DEP_APP_ID);
    }

    private transient SecurityApp _fk1AppDepAppId;
    private transient SecurityApp _fk2AppDepDepAppId;

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table, via the <code>FK1_APP_DEP_APP_ID</code> key.
     */
    public SecurityApp fk1AppDepAppId() {
        if (_fk1AppDepAppId == null)
            _fk1AppDepAppId = new SecurityApp(this, Keys.FK1_APP_DEP_APP_ID);

        return _fk1AppDepAppId;
    }

    /**
     * Get the implicit join path to the <code>security.security_app</code>
     * table, via the <code>FK2_APP_DEP_DEP_APP_ID</code> key.
     */
    public SecurityApp fk2AppDepDepAppId() {
        if (_fk2AppDepDepAppId == null)
            _fk2AppDepDepAppId = new SecurityApp(this, Keys.FK2_APP_DEP_DEP_APP_ID);

        return _fk2AppDepDepAppId;
    }

    @Override
    public SecurityAppDependency as(String alias) {
        return new SecurityAppDependency(DSL.name(alias), this);
    }

    @Override
    public SecurityAppDependency as(Name alias) {
        return new SecurityAppDependency(alias, this);
    }

    @Override
    public SecurityAppDependency as(Table<?> alias) {
        return new SecurityAppDependency(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppDependency rename(String name) {
        return new SecurityAppDependency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppDependency rename(Name name) {
        return new SecurityAppDependency(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecurityAppDependency rename(Table<?> name) {
        return new SecurityAppDependency(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<ULong, ULong, ULong, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super ULong, ? super ULong, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
