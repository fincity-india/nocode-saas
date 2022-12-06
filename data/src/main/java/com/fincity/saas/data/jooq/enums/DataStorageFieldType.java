/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.data.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * Data type of the field
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum DataStorageFieldType implements EnumType {

    INTEGER("INTEGER"),

    LONG("LONG"),

    FLOAT("FLOAT"),

    DOUBLE("DOUBLE"),

    STRING("STRING"),

    OBJECT("OBJECT"),

    ARRAY("ARRAY"),

    BOOLEAN("BOOLEAN"),

    REF("REF"),

    DATE("DATE"),

    TIMESTAMP("TIMESTAMP");

    private final String literal;

    private DataStorageFieldType(String literal) {
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
        return "data_storage_field_TYPE";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static DataStorageFieldType lookupLiteral(String literal) {
        return EnumType.lookupLiteral(DataStorageFieldType.class, literal);
    }
}
