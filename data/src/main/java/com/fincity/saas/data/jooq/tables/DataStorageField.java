/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables;


import com.fincity.saas.data.jooq.Data;
import com.fincity.saas.data.jooq.Indexes;
import com.fincity.saas.data.jooq.Keys;
import com.fincity.saas.data.jooq.enums.DataStorageFieldType;
import com.fincity.saas.data.jooq.tables.records.DataStorageFieldRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
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
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataStorageField extends TableImpl<DataStorageFieldRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>data.data_storage_field</code>
     */
    public static final DataStorageField DATA_STORAGE_FIELD = new DataStorageField();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DataStorageFieldRecord> getRecordType() {
        return DataStorageFieldRecord.class;
    }

    /**
     * The column <code>data.data_storage_field.ID</code>. Primary key
     */
    public final TableField<DataStorageFieldRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>data.data_storage_field.NAME</code>. Name of the field
     */
    public final TableField<DataStorageFieldRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.CHAR(64).nullable(false), this, "Name of the field");

    /**
     * The column <code>data.data_storage_field.TYPE</code>. Data type of the
     * field
     */
    public final TableField<DataStorageFieldRecord, DataStorageFieldType> TYPE = createField(DSL.name("TYPE"), SQLDataType.VARCHAR(9).nullable(false).asEnumDataType(com.fincity.saas.data.jooq.enums.DataStorageFieldType.class), this, "Data type of the field");

    /**
     * The column <code>data.data_storage_field.SIZE</code>.
     */
    public final TableField<DataStorageFieldRecord, UShort> SIZE = createField(DSL.name("SIZE"), SQLDataType.SMALLINTUNSIGNED, this, "");

    /**
     * The column <code>data.data_storage_field.STORAGE_ID</code>. Storage id to
     * which this field belong
     */
    public final TableField<DataStorageFieldRecord, ULong> STORAGE_ID = createField(DSL.name("STORAGE_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Storage id to which this field belong");

    /**
     * The column <code>data.data_storage_field.DEFAULT_VALUE</code>.
     */
    public final TableField<DataStorageFieldRecord, String> DEFAULT_VALUE = createField(DSL.name("DEFAULT_VALUE"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>data.data_storage_field.REF_STORAGE_FIELD_ID</code>.
     */
    public final TableField<DataStorageFieldRecord, ULong> REF_STORAGE_FIELD_ID = createField(DSL.name("REF_STORAGE_FIELD_ID"), SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>data.data_storage_field.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public final TableField<DataStorageFieldRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>data.data_storage_field.CREATED_AT</code>. Time when
     * this row is created
     */
    public final TableField<DataStorageFieldRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is created");

    /**
     * The column <code>data.data_storage_field.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public final TableField<DataStorageFieldRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>data.data_storage_field.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public final TableField<DataStorageFieldRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is updated");

    private DataStorageField(Name alias, Table<DataStorageFieldRecord> aliased) {
        this(alias, aliased, null);
    }

    private DataStorageField(Name alias, Table<DataStorageFieldRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>data.data_storage_field</code> table reference
     */
    public DataStorageField(String alias) {
        this(DSL.name(alias), DATA_STORAGE_FIELD);
    }

    /**
     * Create an aliased <code>data.data_storage_field</code> table reference
     */
    public DataStorageField(Name alias) {
        this(alias, DATA_STORAGE_FIELD);
    }

    /**
     * Create a <code>data.data_storage_field</code> table reference
     */
    public DataStorageField() {
        this(DSL.name("data_storage_field"), null);
    }

    public <O extends Record> DataStorageField(Table<O> child, ForeignKey<O, DataStorageFieldRecord> key) {
        super(child, key, DATA_STORAGE_FIELD);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Data.DATA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.DATA_STORAGE_FIELD_FK2_STRG_FLD_STRG_FILD_IDX);
    }

    @Override
    public Identity<DataStorageFieldRecord, ULong> getIdentity() {
        return (Identity<DataStorageFieldRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<DataStorageFieldRecord> getPrimaryKey() {
        return Keys.KEY_DATA_STORAGE_FIELD_PRIMARY;
    }

    @Override
    public List<UniqueKey<DataStorageFieldRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_DATA_STORAGE_FIELD_UK1_DATA_STRG_FLD);
    }

    @Override
    public List<ForeignKey<DataStorageFieldRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_STRG_FLD_STRG_ID, Keys.FK2_STRG_FLD_STRG_FILD);
    }

    private transient DataStorage _dataStorage;
    private transient DataStorageField _dataStorageField;

    /**
     * Get the implicit join path to the <code>data.data_storage</code> table.
     */
    public DataStorage dataStorage() {
        if (_dataStorage == null)
            _dataStorage = new DataStorage(this, Keys.FK1_STRG_FLD_STRG_ID);

        return _dataStorage;
    }

    /**
     * Get the implicit join path to the <code>data.data_storage_field</code>
     * table.
     */
    public DataStorageField dataStorageField() {
        if (_dataStorageField == null)
            _dataStorageField = new DataStorageField(this, Keys.FK2_STRG_FLD_STRG_FILD);

        return _dataStorageField;
    }

    @Override
    public DataStorageField as(String alias) {
        return new DataStorageField(DSL.name(alias), this);
    }

    @Override
    public DataStorageField as(Name alias) {
        return new DataStorageField(alias, this);
    }

    @Override
    public DataStorageField as(Table<?> alias) {
        return new DataStorageField(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageField rename(String name) {
        return new DataStorageField(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageField rename(Name name) {
        return new DataStorageField(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataStorageField rename(Table<?> name) {
        return new DataStorageField(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<ULong, String, DataStorageFieldType, UShort, ULong, String, ULong, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super ULong, ? super String, ? super DataStorageFieldType, ? super UShort, ? super ULong, ? super String, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super ULong, ? super String, ? super DataStorageFieldType, ? super UShort, ? super ULong, ? super String, ? super ULong, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
