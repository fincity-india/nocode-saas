/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables.records;


import com.fincity.saas.data.jooq.tables.DataStorageActivity;

import java.time.LocalDateTime;
import java.util.Map;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataStorageActivityRecord extends UpdatableRecordImpl<DataStorageActivityRecord> implements Record8<ULong, ULong, String, Map, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>data.data_storage_activity.ID</code>. Primary key
     */
    public DataStorageActivityRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>data.data_storage_activity.STORAGE_ID</code>. Storage id
     * to which this field belong
     */
    public DataStorageActivityRecord setStorageId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.STORAGE_ID</code>. Storage id
     * to which this field belong
     */
    public ULong getStorageId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>data.data_storage_activity.OPERATION</code>. The
     * operation to be done on the database
     */
    public DataStorageActivityRecord setOperation(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.OPERATION</code>. The
     * operation to be done on the database
     */
    public String getOperation() {
        return (String) get(2);
    }

    /**
     * Setter for <code>data.data_storage_activity.OP_DATA</code>. Operation
     * data
     */
    public DataStorageActivityRecord setOpData(Map value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.OP_DATA</code>. Operation
     * data
     */
    public Map getOpData() {
        return (Map) get(3);
    }

    /**
     * Setter for <code>data.data_storage_activity.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public DataStorageActivityRecord setCreatedBy(ULong value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>data.data_storage_activity.CREATED_AT</code>. Time when
     * this row is created
     */
    public DataStorageActivityRecord setCreatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.CREATED_AT</code>. Time when
     * this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>data.data_storage_activity.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public DataStorageActivityRecord setUpdatedBy(ULong value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>data.data_storage_activity.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public DataStorageActivityRecord setUpdatedAt(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_activity.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<ULong, ULong, String, Map, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<ULong, ULong, String, Map, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.ID;
    }

    @Override
    public Field<ULong> field2() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.STORAGE_ID;
    }

    @Override
    public Field<String> field3() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.OPERATION;
    }

    @Override
    public Field<Map> field4() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.OP_DATA;
    }

    @Override
    public Field<ULong> field5() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.CREATED_AT;
    }

    @Override
    public Field<ULong> field7() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return DataStorageActivity.DATA_STORAGE_ACTIVITY.UPDATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getStorageId();
    }

    @Override
    public String component3() {
        return getOperation();
    }

    @Override
    public Map component4() {
        return getOpData();
    }

    @Override
    public ULong component5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public ULong component7() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component8() {
        return getUpdatedAt();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public ULong value2() {
        return getStorageId();
    }

    @Override
    public String value3() {
        return getOperation();
    }

    @Override
    public Map value4() {
        return getOpData();
    }

    @Override
    public ULong value5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public ULong value7() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value8() {
        return getUpdatedAt();
    }

    @Override
    public DataStorageActivityRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value2(ULong value) {
        setStorageId(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value3(String value) {
        setOperation(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value4(Map value) {
        setOpData(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value5(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value7(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord value8(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public DataStorageActivityRecord values(ULong value1, ULong value2, String value3, Map value4, ULong value5, LocalDateTime value6, ULong value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DataStorageActivityRecord
     */
    public DataStorageActivityRecord() {
        super(DataStorageActivity.DATA_STORAGE_ACTIVITY);
    }

    /**
     * Create a detached, initialised DataStorageActivityRecord
     */
    public DataStorageActivityRecord(ULong id, ULong storageId, String operation, Map opData, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(DataStorageActivity.DATA_STORAGE_ACTIVITY);

        setId(id);
        setStorageId(storageId);
        setOperation(operation);
        setOpData(opData);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
    }
}
