/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * Reference type
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum DataStorageRefFieldRefType implements EnumType {

    CASCADE("CASCADE"),

    RESTRICT("RESTRICT"),

    SETNULL("SETNULL");

    private final String literal;

    private DataStorageRefFieldRefType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return "data_storage_ref_field_REF_TYPE";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static DataStorageRefFieldRefType lookupLiteral(String literal) {
        return EnumType.lookupLiteral(DataStorageRefFieldRefType.class, literal);
    }
}
