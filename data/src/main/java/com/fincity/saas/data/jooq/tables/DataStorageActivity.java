/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables;


import com.fincity.saas.commons.jooq.convertor.JSONMysqlMapConvertor;
import com.fincity.saas.data.jooq.Data;
import com.fincity.saas.data.jooq.Keys;
import com.fincity.saas.data.jooq.tables.records.DataStorageActivityRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
public class DataStorageActivity extends TableImpl<DataStorageActivityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>data.data_storage_activity</code>
     */
    public static final DataStorageActivity DATA_STORAGE_ACTIVITY = new DataStorageActivity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DataStorageActivityRecord> getRecordType() {
        return DataStorageActivityRecord.class;
    }

    /**
     * The column <code>data.data_storage_activity.ID</code>. Primary key
     */
    public final TableField<DataStorageActivityRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>data.data_storage_activity.STORAGE_ID</code>. Storage id
     * to which this field belong
     */
    public final TableField<DataStorageActivityRecord, ULong> STORAGE_ID = createField(DSL.name("STORAGE_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Storage id to which this field belong");

    /**
     * The column <code>data.data_storage_activity.OPERATION</code>. The
     * operation to be done on the database
     */
    public final TableField<DataStorageActivityRecord, String> OPERATION = createField(DSL.name("OPERATION"), SQLDataType.CHAR(64).nullable(false), this, "The operation to be done on the database");

    /**
     * The column <code>data.data_storage_activity.OP_DATA</code>. Operation
     * data
     */
    public final TableField<DataStorageActivityRecord, Map> OP_DATA = createField(DSL.name("OP_DATA"), SQLDataType.JSON, this, "Operation data", new JSONMysqlMapConvertor());

    /**
     * The column <code>data.data_storage_activity.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public final TableField<DataStorageActivityRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>data.data_storage_activity.CREATED_AT</code>. Time when
     * this row is created
     */
    public final TableField<DataStorageActivityRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is created");

    /**
     * The column <code>data.data_storage_activity.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public final TableField<DataStorageActivityRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>data.data_storage_activity.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public final TableField<DataStorageActivityRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is updated");

    private DataStorageActivity(Name alias, Table<DataStorageActivityRecord> aliased) {
        this(alias, aliased, null);
    }

    private DataStorageActivity(Name alias, Table<DataStorageActivityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>data.data_storage_activity</code> table reference
     */
    public DataStorageActivity(String alias) {
        this(DSL.name(alias), DATA_STORAGE_ACTIVITY);
    }

    /**
     * Create an aliased <code>data.data_storage_activity</code> table reference
     */
    public DataStorageActivity(Name alias) {
        this(alias, DATA_STORAGE_ACTIVITY);
    }

    /**
     * Create a <code>data.data_storage_activity</code> table reference
     */
    public DataStorageActivity() {
        this(DSL.name("data_storage_activity"), null);
    }

    public <O extends Record> DataStorageActivity(Table<O> child, ForeignKey<O, DataStorageActivityRecord> key) {
        super(child, key, DATA_STORAGE_ACTIVITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Data.DATA;
    }

    @Override
    public Identity<DataStorageActivityRecord, ULong> getIdentity() {
        return (Identity<DataStorageActivityRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<DataStorageActivityRecord> getPrimaryKey() {
        return Keys.KEY_DATA_STORAGE_ACTIVITY_PRIMARY;
    }

    @Override
    public List<ForeignKey<DataStorageActivityRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_STRG_ACT_STRG_ID);
    }

    private transient DataStorage _dataStorage;

    /**
     * Get the implicit join path to the <code>data.data_storage</code> table.
     */
    public DataStorage dataStorage() {
        if (_dataStorage == null)
            _dataStorage = new DataStorage(this, Keys.FK1_STRG_ACT_STRG_ID);

        return _dataStorage;
    }

    @Override
    public DataStorageActivity as(String alias) {
        return new DataStorageActivity(DSL.name(alias), this);
    }

    @Override
    public DataStorageActivity as(Name alias) {
        return new DataStorageActivity(alias, this);
    }

    @Override
    public DataStorageActivity as(Table<?> alias) {
        return new DataStorageActivity(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageActivity rename(String name) {
        return new DataStorageActivity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageActivity rename(Name name) {
        return new DataStorageActivity(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageActivity rename(Table<?> name) {
        return new DataStorageActivity(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<ULong, ULong, String, Map, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super ULong, ? super ULong, ? super String, ? super Map, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super ULong, ? super ULong, ? super String, ? super Map, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
