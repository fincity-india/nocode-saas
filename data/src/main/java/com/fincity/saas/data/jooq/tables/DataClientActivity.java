/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables;


import com.fincity.saas.data.jooq.Data;
import com.fincity.saas.data.jooq.Keys;
import com.fincity.saas.data.jooq.enums.DataClientActivityStatus;
import com.fincity.saas.data.jooq.tables.records.DataClientActivityRecord;

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
public class DataClientActivity extends TableImpl<DataClientActivityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>data.data_client_activity</code>
     */
    public static final DataClientActivity DATA_CLIENT_ACTIVITY = new DataClientActivity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DataClientActivityRecord> getRecordType() {
        return DataClientActivityRecord.class;
    }

    /**
     * The column <code>data.data_client_activity.ID</code>. Primary key
     */
    public final TableField<DataClientActivityRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>data.data_client_activity.CLIENT_CODE</code>. Client
     * code
     */
    public final TableField<DataClientActivityRecord, String> CLIENT_CODE = createField(DSL.name("CLIENT_CODE"), SQLDataType.CHAR(8).nullable(false), this, "Client code");

    /**
     * The column <code>data.data_client_activity.ACTIVITY_ID</code>. Activity
     * ID applied
     */
    public final TableField<DataClientActivityRecord, ULong> ACTIVITY_ID = createField(DSL.name("ACTIVITY_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Activity ID applied");

    /**
     * The column <code>data.data_client_activity.STATUS</code>. Status of the
     * activity
     */
    public final TableField<DataClientActivityRecord, DataClientActivityStatus> STATUS = createField(DSL.name("STATUS"), SQLDataType.VARCHAR(9).nullable(false).defaultValue(DSL.inline("ERROR", SQLDataType.VARCHAR)).asEnumDataType(com.fincity.saas.data.jooq.enums.DataClientActivityStatus.class), this, "Status of the activity");

    /**
     * The column <code>data.data_client_activity.ERROR</code>. Error message
     * while perfoming the activity
     */
    public final TableField<DataClientActivityRecord, String> ERROR = createField(DSL.name("ERROR"), SQLDataType.CLOB, this, "Error message while perfoming the activity");

    /**
     * The column <code>data.data_client_activity.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public final TableField<DataClientActivityRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>data.data_client_activity.CREATED_AT</code>. Time when
     * this row is created
     */
    public final TableField<DataClientActivityRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is created");

    /**
     * The column <code>data.data_client_activity.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public final TableField<DataClientActivityRecord, ULong> UPDATED_BY = createField(DSL.name("UPDATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who updated this row");

    /**
     * The column <code>data.data_client_activity.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public final TableField<DataClientActivityRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "Time when this row is updated");

    private DataClientActivity(Name alias, Table<DataClientActivityRecord> aliased) {
        this(alias, aliased, null);
    }

    private DataClientActivity(Name alias, Table<DataClientActivityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>data.data_client_activity</code> table reference
     */
    public DataClientActivity(String alias) {
        this(DSL.name(alias), DATA_CLIENT_ACTIVITY);
    }

    /**
     * Create an aliased <code>data.data_client_activity</code> table reference
     */
    public DataClientActivity(Name alias) {
        this(alias, DATA_CLIENT_ACTIVITY);
    }

    /**
     * Create a <code>data.data_client_activity</code> table reference
     */
    public DataClientActivity() {
        this(DSL.name("data_client_activity"), null);
    }

    public <O extends Record> DataClientActivity(Table<O> child, ForeignKey<O, DataClientActivityRecord> key) {
        super(child, key, DATA_CLIENT_ACTIVITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Data.DATA;
    }

    @Override
    public Identity<DataClientActivityRecord, ULong> getIdentity() {
        return (Identity<DataClientActivityRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<DataClientActivityRecord> getPrimaryKey() {
        return Keys.KEY_DATA_CLIENT_ACTIVITY_PRIMARY;
    }

    @Override
    public List<UniqueKey<DataClientActivityRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_DATA_CLIENT_ACTIVITY_UK1_DATA_CLNT_ACT);
    }

    @Override
    public List<ForeignKey<DataClientActivityRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_CLNT_ACT_STRG_ACT);
    }

    private transient DataStorageActivity _dataStorageActivity;

    /**
     * Get the implicit join path to the <code>data.data_storage_activity</code>
     * table.
     */
    public DataStorageActivity dataStorageActivity() {
        if (_dataStorageActivity == null)
            _dataStorageActivity = new DataStorageActivity(this, Keys.FK1_CLNT_ACT_STRG_ACT);

        return _dataStorageActivity;
    }

    @Override
    public DataClientActivity as(String alias) {
        return new DataClientActivity(DSL.name(alias), this);
    }

    @Override
    public DataClientActivity as(Name alias) {
        return new DataClientActivity(alias, this);
    }

    @Override
    public DataClientActivity as(Table<?> alias) {
        return new DataClientActivity(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public DataClientActivity rename(String name) {
        return new DataClientActivity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataClientActivity rename(Name name) {
        return new DataClientActivity(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public DataClientActivity rename(Table<?> name) {
        return new DataClientActivity(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<ULong, String, ULong, DataClientActivityStatus, String, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super ULong, ? super String, ? super ULong, ? super DataClientActivityStatus, ? super String, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super ULong, ? super String, ? super ULong, ? super DataClientActivityStatus, ? super String, ? super ULong, ? super LocalDateTime, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
