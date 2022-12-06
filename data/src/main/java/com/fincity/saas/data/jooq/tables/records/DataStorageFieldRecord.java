/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables.records;


import com.fincity.saas.data.jooq.enums.DataStorageFieldType;
import com.fincity.saas.data.jooq.tables.DataStorageField;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataStorageFieldRecord extends UpdatableRecordImpl<DataStorageFieldRecord> implements Record11<ULong, String, DataStorageFieldType, UShort, ULong, String, ULong, ULong, LocalDateTime, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>data.data_storage_field.ID</code>. Primary key
     */
    public DataStorageFieldRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>data.data_storage_field.NAME</code>. Name of the field
     */
    public DataStorageFieldRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.NAME</code>. Name of the field
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>data.data_storage_field.TYPE</code>. Data type of the
     * field
     */
    public DataStorageFieldRecord setType(DataStorageFieldType value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.TYPE</code>. Data type of the
     * field
     */
    public DataStorageFieldType getType() {
        return (DataStorageFieldType) get(2);
    }

    /**
     * Setter for <code>data.data_storage_field.SIZE</code>.
     */
    public DataStorageFieldRecord setSize(UShort value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.SIZE</code>.
     */
    public UShort getSize() {
        return (UShort) get(3);
    }

    /**
     * Setter for <code>data.data_storage_field.STORAGE_ID</code>. Storage id to
     * which this field belong
     */
    public DataStorageFieldRecord setStorageId(ULong value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.STORAGE_ID</code>. Storage id to
     * which this field belong
     */
    public ULong getStorageId() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>data.data_storage_field.DEFAULT_VALUE</code>.
     */
    public DataStorageFieldRecord setDefaultValue(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.DEFAULT_VALUE</code>.
     */
    public String getDefaultValue() {
        return (String) get(5);
    }

    /**
     * Setter for <code>data.data_storage_field.REF_STORAGE_FIELD_ID</code>.
     */
    public DataStorageFieldRecord setRefStorageFieldId(ULong value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.REF_STORAGE_FIELD_ID</code>.
     */
    public ULong getRefStorageFieldId() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>data.data_storage_field.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public DataStorageFieldRecord setCreatedBy(ULong value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>data.data_storage_field.CREATED_AT</code>. Time when
     * this row is created
     */
    public DataStorageFieldRecord setCreatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.CREATED_AT</code>. Time when
     * this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>data.data_storage_field.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public DataStorageFieldRecord setUpdatedBy(ULong value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.UPDATED_BY</code>. ID of the
     * user who updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>data.data_storage_field.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public DataStorageFieldRecord setUpdatedAt(LocalDateTime value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage_field.UPDATED_AT</code>. Time when
     * this row is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<ULong, String, DataStorageFieldType, UShort, ULong, String, ULong, ULong, LocalDateTime, ULong, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<ULong, String, DataStorageFieldType, UShort, ULong, String, ULong, ULong, LocalDateTime, ULong, LocalDateTime> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return DataStorageField.DATA_STORAGE_FIELD.ID;
    }

    @Override
    public Field<String> field2() {
        return DataStorageField.DATA_STORAGE_FIELD.NAME;
    }

    @Override
    public Field<DataStorageFieldType> field3() {
        return DataStorageField.DATA_STORAGE_FIELD.TYPE;
    }

    @Override
    public Field<UShort> field4() {
        return DataStorageField.DATA_STORAGE_FIELD.SIZE;
    }

    @Override
    public Field<ULong> field5() {
        return DataStorageField.DATA_STORAGE_FIELD.STORAGE_ID;
    }

    @Override
    public Field<String> field6() {
        return DataStorageField.DATA_STORAGE_FIELD.DEFAULT_VALUE;
    }

    @Override
    public Field<ULong> field7() {
        return DataStorageField.DATA_STORAGE_FIELD.REF_STORAGE_FIELD_ID;
    }

    @Override
    public Field<ULong> field8() {
        return DataStorageField.DATA_STORAGE_FIELD.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return DataStorageField.DATA_STORAGE_FIELD.CREATED_AT;
    }

    @Override
    public Field<ULong> field10() {
        return DataStorageField.DATA_STORAGE_FIELD.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return DataStorageField.DATA_STORAGE_FIELD.UPDATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public DataStorageFieldType component3() {
        return getType();
    }

    @Override
    public UShort component4() {
        return getSize();
    }

    @Override
    public ULong component5() {
        return getStorageId();
    }

    @Override
    public String component6() {
        return getDefaultValue();
    }

    @Override
    public ULong component7() {
        return getRefStorageFieldId();
    }

    @Override
    public ULong component8() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component9() {
        return getCreatedAt();
    }

    @Override
    public ULong component10() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component11() {
        return getUpdatedAt();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public DataStorageFieldType value3() {
        return getType();
    }

    @Override
    public UShort value4() {
        return getSize();
    }

    @Override
    public ULong value5() {
        return getStorageId();
    }

    @Override
    public String value6() {
        return getDefaultValue();
    }

    @Override
    public ULong value7() {
        return getRefStorageFieldId();
    }

    @Override
    public ULong value8() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value9() {
        return getCreatedAt();
    }

    @Override
    public ULong value10() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value11() {
        return getUpdatedAt();
    }

    @Override
    public DataStorageFieldRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value3(DataStorageFieldType value) {
        setType(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value4(UShort value) {
        setSize(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value5(ULong value) {
        setStorageId(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value6(String value) {
        setDefaultValue(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value7(ULong value) {
        setRefStorageFieldId(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value8(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value9(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value10(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord value11(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public DataStorageFieldRecord values(ULong value1, String value2, DataStorageFieldType value3, UShort value4, ULong value5, String value6, ULong value7, ULong value8, LocalDateTime value9, ULong value10, LocalDateTime value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DataStorageFieldRecord
     */
    public DataStorageFieldRecord() {
        super(DataStorageField.DATA_STORAGE_FIELD);
    }

    /**
     * Create a detached, initialised DataStorageFieldRecord
     */
    public DataStorageFieldRecord(ULong id, String name, DataStorageFieldType type, UShort size, ULong storageId, String defaultValue, ULong refStorageFieldId, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt) {
        super(DataStorageField.DATA_STORAGE_FIELD);

        setId(id);
        setName(name);
        setType(type);
        setSize(size);
        setStorageId(storageId);
        setDefaultValue(defaultValue);
        setRefStorageFieldId(refStorageFieldId);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
    }
}
