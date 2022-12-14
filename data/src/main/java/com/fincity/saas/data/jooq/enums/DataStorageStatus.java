/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum DataStorageStatus implements EnumType {

    ACTIVE("ACTIVE"),

    READONLY("READONLY"),

    INACTIVE("INACTIVE"),

    DELETED("DELETED");

    private final String literal;

    private DataStorageStatus(String literal) {
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
        return "data_storage_STATUS";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static DataStorageStatus lookupLiteral(String literal) {
        return EnumType.lookupLiteral(DataStorageStatus.class, literal);
    }
}
