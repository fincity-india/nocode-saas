/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.enums.SecuritySoxLogActionName;
import com.fincity.security.jooq.enums.SecuritySoxLogObjectName;
import com.fincity.security.jooq.tables.SecuritySoxLog;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecuritySoxLogRecord extends UpdatableRecordImpl<SecuritySoxLogRecord> implements Record7<ULong, ULong, SecuritySoxLogObjectName, SecuritySoxLogActionName, String, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_sox_log.ID</code>. Primary key
     */
    public SecuritySoxLogRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_sox_log.OBJECT_ID</code>. ID of the
     * object where the change is happening
     */
    public SecuritySoxLogRecord setObjectId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.OBJECT_ID</code>. ID of the
     * object where the change is happening
     */
    public ULong getObjectId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_sox_log.OBJECT_NAME</code>. Operation
     * on the object
     */
    public SecuritySoxLogRecord setObjectName(SecuritySoxLogObjectName value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.OBJECT_NAME</code>. Operation
     * on the object
     */
    public SecuritySoxLogObjectName getObjectName() {
        return (SecuritySoxLogObjectName) get(2);
    }

    /**
     * Setter for <code>security.security_sox_log.ACTION_NAME</code>. Log action
     * name
     */
    public SecuritySoxLogRecord setActionName(SecuritySoxLogActionName value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.ACTION_NAME</code>. Log action
     * name
     */
    public SecuritySoxLogActionName getActionName() {
        return (SecuritySoxLogActionName) get(3);
    }

    /**
     * Setter for <code>security.security_sox_log.DESCRIPTION</code>. Log
     * description
     */
    public SecuritySoxLogRecord setDescription(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.DESCRIPTION</code>. Log
     * description
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_sox_log.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public SecuritySoxLogRecord setCreatedBy(ULong value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.CREATED_BY</code>. ID of the
     * user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>security.security_sox_log.CREATED_AT</code>. Time when
     * this row is created
     */
    public SecuritySoxLogRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_sox_log.CREATED_AT</code>. Time when
     * this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<ULong, ULong, SecuritySoxLogObjectName, SecuritySoxLogActionName, String, ULong, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<ULong, ULong, SecuritySoxLogObjectName, SecuritySoxLogActionName, String, ULong, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecuritySoxLog.SECURITY_SOX_LOG.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecuritySoxLog.SECURITY_SOX_LOG.OBJECT_ID;
    }

    @Override
    public Field<SecuritySoxLogObjectName> field3() {
        return SecuritySoxLog.SECURITY_SOX_LOG.OBJECT_NAME;
    }

    @Override
    public Field<SecuritySoxLogActionName> field4() {
        return SecuritySoxLog.SECURITY_SOX_LOG.ACTION_NAME;
    }

    @Override
    public Field<String> field5() {
        return SecuritySoxLog.SECURITY_SOX_LOG.DESCRIPTION;
    }

    @Override
    public Field<ULong> field6() {
        return SecuritySoxLog.SECURITY_SOX_LOG.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return SecuritySoxLog.SECURITY_SOX_LOG.CREATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getObjectId();
    }

    @Override
    public SecuritySoxLogObjectName component3() {
        return getObjectName();
    }

    @Override
    public SecuritySoxLogActionName component4() {
        return getActionName();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public ULong component6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public ULong value2() {
        return getObjectId();
    }

    @Override
    public SecuritySoxLogObjectName value3() {
        return getObjectName();
    }

    @Override
    public SecuritySoxLogActionName value4() {
        return getActionName();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public ULong value6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public SecuritySoxLogRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value2(ULong value) {
        setObjectId(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value3(SecuritySoxLogObjectName value) {
        setObjectName(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value4(SecuritySoxLogActionName value) {
        setActionName(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value6(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecuritySoxLogRecord values(ULong value1, ULong value2, SecuritySoxLogObjectName value3, SecuritySoxLogActionName value4, String value5, ULong value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecuritySoxLogRecord
     */
    public SecuritySoxLogRecord() {
        super(SecuritySoxLog.SECURITY_SOX_LOG);
    }

    /**
     * Create a detached, initialised SecuritySoxLogRecord
     */
    public SecuritySoxLogRecord(ULong id, ULong objectId, SecuritySoxLogObjectName objectName, SecuritySoxLogActionName actionName, String description, ULong createdBy, LocalDateTime createdAt) {
        super(SecuritySoxLog.SECURITY_SOX_LOG);

        setId(id);
        setObjectId(objectId);
        setObjectName(objectName);
        setActionName(actionName);
        setDescription(description);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        resetChangedOnNotNull();
    }
}
