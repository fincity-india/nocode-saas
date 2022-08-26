/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecurityOrgStructure;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecurityOrgStructureRecord extends UpdatableRecordImpl<SecurityOrgStructureRecord> implements Record5<ULong, ULong, ULong, Byte, ULong> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_org_structure.ID</code>. Primary key
     */
    public SecurityOrgStructureRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_org_structure.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_org_structure.CLIENT_ID</code>. Client
     * ID
     */
    public SecurityOrgStructureRecord setClientId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_org_structure.CLIENT_ID</code>. Client
     * ID
     */
    public ULong getClientId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_org_structure.USER_ID</code>. User ID
     */
    public SecurityOrgStructureRecord setUserId(ULong value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_org_structure.USER_ID</code>. User ID
     */
    public ULong getUserId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>security.security_org_structure.DEFAULT_MANAGER</code>.
     * Default manager, 0 if he is reporting to multiple managers
     */
    public SecurityOrgStructureRecord setDefaultManager(Byte value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_org_structure.DEFAULT_MANAGER</code>.
     * Default manager, 0 if he is reporting to multiple managers
     */
    public Byte getDefaultManager() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>security.security_org_structure.MANAGER_ID</code>.
     * Manager ID
     */
    public SecurityOrgStructureRecord setManagerId(ULong value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_org_structure.MANAGER_ID</code>.
     * Manager ID
     */
    public ULong getManagerId() {
        return (ULong) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<ULong, ULong, ULong, Byte, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<ULong, ULong, ULong, Byte, ULong> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecurityOrgStructure.SECURITY_ORG_STRUCTURE.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecurityOrgStructure.SECURITY_ORG_STRUCTURE.CLIENT_ID;
    }

    @Override
    public Field<ULong> field3() {
        return SecurityOrgStructure.SECURITY_ORG_STRUCTURE.USER_ID;
    }

    @Override
    public Field<Byte> field4() {
        return SecurityOrgStructure.SECURITY_ORG_STRUCTURE.DEFAULT_MANAGER;
    }

    @Override
    public Field<ULong> field5() {
        return SecurityOrgStructure.SECURITY_ORG_STRUCTURE.MANAGER_ID;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getClientId();
    }

    @Override
    public ULong component3() {
        return getUserId();
    }

    @Override
    public Byte component4() {
        return getDefaultManager();
    }

    @Override
    public ULong component5() {
        return getManagerId();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public ULong value2() {
        return getClientId();
    }

    @Override
    public ULong value3() {
        return getUserId();
    }

    @Override
    public Byte value4() {
        return getDefaultManager();
    }

    @Override
    public ULong value5() {
        return getManagerId();
    }

    @Override
    public SecurityOrgStructureRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecurityOrgStructureRecord value2(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public SecurityOrgStructureRecord value3(ULong value) {
        setUserId(value);
        return this;
    }

    @Override
    public SecurityOrgStructureRecord value4(Byte value) {
        setDefaultManager(value);
        return this;
    }

    @Override
    public SecurityOrgStructureRecord value5(ULong value) {
        setManagerId(value);
        return this;
    }

    @Override
    public SecurityOrgStructureRecord values(ULong value1, ULong value2, ULong value3, Byte value4, ULong value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecurityOrgStructureRecord
     */
    public SecurityOrgStructureRecord() {
        super(SecurityOrgStructure.SECURITY_ORG_STRUCTURE);
    }

    /**
     * Create a detached, initialised SecurityOrgStructureRecord
     */
    public SecurityOrgStructureRecord(ULong id, ULong clientId, ULong userId, Byte defaultManager, ULong managerId) {
        super(SecurityOrgStructure.SECURITY_ORG_STRUCTURE);

        setId(id);
        setClientId(clientId);
        setUserId(userId);
        setDefaultManager(defaultManager);
        setManagerId(managerId);
    }
}