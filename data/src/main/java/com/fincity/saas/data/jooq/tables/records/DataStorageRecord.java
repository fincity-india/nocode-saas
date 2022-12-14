/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.tables.records;


import com.fincity.saas.data.jooq.enums.DataStorageStatus;
import com.fincity.saas.data.jooq.tables.DataStorage;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataStorageRecord extends UpdatableRecordImpl<DataStorageRecord> implements Record18<ULong, String, String, String, String, String, UByte, UByte, String, String, String, String, String, ULong, LocalDateTime, ULong, LocalDateTime, DataStorageStatus> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>data.data_storage.ID</code>. Primary key
     */
    public DataStorageRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>data.data_storage.CLIENT_CODE</code>. Client code
     */
    public DataStorageRecord setClientCode(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.CLIENT_CODE</code>. Client code
     */
    public String getClientCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>data.data_storage.APP_CODE</code>. Application code
     */
    public DataStorageRecord setAppCode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.APP_CODE</code>. Application code
     */
    public String getAppCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>data.data_storage.NAMESPACE</code>. Namespace
     */
    public DataStorageRecord setNamespace(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.NAMESPACE</code>. Namespace
     */
    public String getNamespace() {
        return (String) get(3);
    }

    /**
     * Setter for <code>data.data_storage.NAME</code>. Name
     */
    public DataStorageRecord setName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.NAME</code>. Name
     */
    public String getName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>data.data_storage.DB_NAME</code>. Database name where
     * the data is stored
     */
    public DataStorageRecord setDbName(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.DB_NAME</code>. Database name where
     * the data is stored
     */
    public String getDbName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>data.data_storage.IS_VERSIONED</code>. Versioned if it
     * is true
     */
    public DataStorageRecord setIsVersioned(UByte value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.IS_VERSIONED</code>. Versioned if it
     * is true
     */
    public UByte getIsVersioned() {
        return (UByte) get(6);
    }

    /**
     * Setter for <code>data.data_storage.IS_AUDITED</code>. Audited if it is
     * true
     */
    public DataStorageRecord setIsAudited(UByte value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.IS_AUDITED</code>. Audited if it is
     * true
     */
    public UByte getIsAudited() {
        return (UByte) get(7);
    }

    /**
     * Setter for <code>data.data_storage.CREATE_AUTH</code>. Authorization
     * expression for creating a row
     */
    public DataStorageRecord setCreateAuth(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.CREATE_AUTH</code>. Authorization
     * expression for creating a row
     */
    public String getCreateAuth() {
        return (String) get(8);
    }

    /**
     * Setter for <code>data.data_storage.READ_AUTH</code>. Authorization
     * expression for reading a row
     */
    public DataStorageRecord setReadAuth(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.READ_AUTH</code>. Authorization
     * expression for reading a row
     */
    public String getReadAuth() {
        return (String) get(9);
    }

    /**
     * Setter for <code>data.data_storage.UPDATE_AUTH</code>. Authorization
     * expression for updating a row
     */
    public DataStorageRecord setUpdateAuth(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.UPDATE_AUTH</code>. Authorization
     * expression for updating a row
     */
    public String getUpdateAuth() {
        return (String) get(10);
    }

    /**
     * Setter for <code>data.data_storage.DELETE_AUTH</code>. Authorization
     * expression for deleting a row
     */
    public DataStorageRecord setDeleteAuth(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.DELETE_AUTH</code>. Authorization
     * expression for deleting a row
     */
    public String getDeleteAuth() {
        return (String) get(11);
    }

    /**
     * Setter for <code>data.data_storage.INTERNAL_NAME</code>. Name with the
     * storage created.
     */
    public DataStorageRecord setInternalName(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.INTERNAL_NAME</code>. Name with the
     * storage created.
     */
    public String getInternalName() {
        return (String) get(12);
    }

    /**
     * Setter for <code>data.data_storage.CREATED_BY</code>. ID of the user who
     * created this row
     */
    public DataStorageRecord setCreatedBy(ULong value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.CREATED_BY</code>. ID of the user who
     * created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>data.data_storage.CREATED_AT</code>. Time when this row
     * is created
     */
    public DataStorageRecord setCreatedAt(LocalDateTime value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.CREATED_AT</code>. Time when this row
     * is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(14);
    }

    /**
     * Setter for <code>data.data_storage.UPDATED_BY</code>. ID of the user who
     * updated this row
     */
    public DataStorageRecord setUpdatedBy(ULong value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.UPDATED_BY</code>. ID of the user who
     * updated this row
     */
    public ULong getUpdatedBy() {
        return (ULong) get(15);
    }

    /**
     * Setter for <code>data.data_storage.UPDATED_AT</code>. Time when this row
     * is updated
     */
    public DataStorageRecord setUpdatedAt(LocalDateTime value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.UPDATED_AT</code>. Time when this row
     * is updated
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(16);
    }

    /**
     * Setter for <code>data.data_storage.STATUS</code>.
     */
    public DataStorageRecord setStatus(DataStorageStatus value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>data.data_storage.STATUS</code>.
     */
    public DataStorageStatus getStatus() {
        return (DataStorageStatus) get(17);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row18<ULong, String, String, String, String, String, UByte, UByte, String, String, String, String, String, ULong, LocalDateTime, ULong, LocalDateTime, DataStorageStatus> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    @Override
    public Row18<ULong, String, String, String, String, String, UByte, UByte, String, String, String, String, String, ULong, LocalDateTime, ULong, LocalDateTime, DataStorageStatus> valuesRow() {
        return (Row18) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return DataStorage.DATA_STORAGE.ID;
    }

    @Override
    public Field<String> field2() {
        return DataStorage.DATA_STORAGE.CLIENT_CODE;
    }

    @Override
    public Field<String> field3() {
        return DataStorage.DATA_STORAGE.APP_CODE;
    }

    @Override
    public Field<String> field4() {
        return DataStorage.DATA_STORAGE.NAMESPACE;
    }

    @Override
    public Field<String> field5() {
        return DataStorage.DATA_STORAGE.NAME;
    }

    @Override
    public Field<String> field6() {
        return DataStorage.DATA_STORAGE.DB_NAME;
    }

    @Override
    public Field<UByte> field7() {
        return DataStorage.DATA_STORAGE.IS_VERSIONED;
    }

    @Override
    public Field<UByte> field8() {
        return DataStorage.DATA_STORAGE.IS_AUDITED;
    }

    @Override
    public Field<String> field9() {
        return DataStorage.DATA_STORAGE.CREATE_AUTH;
    }

    @Override
    public Field<String> field10() {
        return DataStorage.DATA_STORAGE.READ_AUTH;
    }

    @Override
    public Field<String> field11() {
        return DataStorage.DATA_STORAGE.UPDATE_AUTH;
    }

    @Override
    public Field<String> field12() {
        return DataStorage.DATA_STORAGE.DELETE_AUTH;
    }

    @Override
    public Field<String> field13() {
        return DataStorage.DATA_STORAGE.INTERNAL_NAME;
    }

    @Override
    public Field<ULong> field14() {
        return DataStorage.DATA_STORAGE.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field15() {
        return DataStorage.DATA_STORAGE.CREATED_AT;
    }

    @Override
    public Field<ULong> field16() {
        return DataStorage.DATA_STORAGE.UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field17() {
        return DataStorage.DATA_STORAGE.UPDATED_AT;
    }

    @Override
    public Field<DataStorageStatus> field18() {
        return DataStorage.DATA_STORAGE.STATUS;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getClientCode();
    }

    @Override
    public String component3() {
        return getAppCode();
    }

    @Override
    public String component4() {
        return getNamespace();
    }

    @Override
    public String component5() {
        return getName();
    }

    @Override
    public String component6() {
        return getDbName();
    }

    @Override
    public UByte component7() {
        return getIsVersioned();
    }

    @Override
    public UByte component8() {
        return getIsAudited();
    }

    @Override
    public String component9() {
        return getCreateAuth();
    }

    @Override
    public String component10() {
        return getReadAuth();
    }

    @Override
    public String component11() {
        return getUpdateAuth();
    }

    @Override
    public String component12() {
        return getDeleteAuth();
    }

    @Override
    public String component13() {
        return getInternalName();
    }

    @Override
    public ULong component14() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component15() {
        return getCreatedAt();
    }

    @Override
    public ULong component16() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime component17() {
        return getUpdatedAt();
    }

    @Override
    public DataStorageStatus component18() {
        return getStatus();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getClientCode();
    }

    @Override
    public String value3() {
        return getAppCode();
    }

    @Override
    public String value4() {
        return getNamespace();
    }

    @Override
    public String value5() {
        return getName();
    }

    @Override
    public String value6() {
        return getDbName();
    }

    @Override
    public UByte value7() {
        return getIsVersioned();
    }

    @Override
    public UByte value8() {
        return getIsAudited();
    }

    @Override
    public String value9() {
        return getCreateAuth();
    }

    @Override
    public String value10() {
        return getReadAuth();
    }

    @Override
    public String value11() {
        return getUpdateAuth();
    }

    @Override
    public String value12() {
        return getDeleteAuth();
    }

    @Override
    public String value13() {
        return getInternalName();
    }

    @Override
    public ULong value14() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value15() {
        return getCreatedAt();
    }

    @Override
    public ULong value16() {
        return getUpdatedBy();
    }

    @Override
    public LocalDateTime value17() {
        return getUpdatedAt();
    }

    @Override
    public DataStorageStatus value18() {
        return getStatus();
    }

    @Override
    public DataStorageRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public DataStorageRecord value2(String value) {
        setClientCode(value);
        return this;
    }

    @Override
    public DataStorageRecord value3(String value) {
        setAppCode(value);
        return this;
    }

    @Override
    public DataStorageRecord value4(String value) {
        setNamespace(value);
        return this;
    }

    @Override
    public DataStorageRecord value5(String value) {
        setName(value);
        return this;
    }

    @Override
    public DataStorageRecord value6(String value) {
        setDbName(value);
        return this;
    }

    @Override
    public DataStorageRecord value7(UByte value) {
        setIsVersioned(value);
        return this;
    }

    @Override
    public DataStorageRecord value8(UByte value) {
        setIsAudited(value);
        return this;
    }

    @Override
    public DataStorageRecord value9(String value) {
        setCreateAuth(value);
        return this;
    }

    @Override
    public DataStorageRecord value10(String value) {
        setReadAuth(value);
        return this;
    }

    @Override
    public DataStorageRecord value11(String value) {
        setUpdateAuth(value);
        return this;
    }

    @Override
    public DataStorageRecord value12(String value) {
        setDeleteAuth(value);
        return this;
    }

    @Override
    public DataStorageRecord value13(String value) {
        setInternalName(value);
        return this;
    }

    @Override
    public DataStorageRecord value14(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public DataStorageRecord value15(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public DataStorageRecord value16(ULong value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public DataStorageRecord value17(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public DataStorageRecord value18(DataStorageStatus value) {
        setStatus(value);
        return this;
    }

    @Override
    public DataStorageRecord values(ULong value1, String value2, String value3, String value4, String value5, String value6, UByte value7, UByte value8, String value9, String value10, String value11, String value12, String value13, ULong value14, LocalDateTime value15, ULong value16, LocalDateTime value17, DataStorageStatus value18) {
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
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DataStorageRecord
     */
    public DataStorageRecord() {
        super(DataStorage.DATA_STORAGE);
    }

    /**
     * Create a detached, initialised DataStorageRecord
     */
    public DataStorageRecord(ULong id, String clientCode, String appCode, String namespace, String name, String dbName, UByte isVersioned, UByte isAudited, String createAuth, String readAuth, String updateAuth, String deleteAuth, String internalName, ULong createdBy, LocalDateTime createdAt, ULong updatedBy, LocalDateTime updatedAt, DataStorageStatus status) {
        super(DataStorage.DATA_STORAGE);

        setId(id);
        setClientCode(clientCode);
        setAppCode(appCode);
        setNamespace(namespace);
        setName(name);
        setDbName(dbName);
        setIsVersioned(isVersioned);
        setIsAudited(isAudited);
        setCreateAuth(createAuth);
        setReadAuth(readAuth);
        setUpdateAuth(updateAuth);
        setDeleteAuth(deleteAuth);
        setInternalName(internalName);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        setUpdatedBy(updatedBy);
        setUpdatedAt(updatedAt);
        setStatus(status);
    }
}
