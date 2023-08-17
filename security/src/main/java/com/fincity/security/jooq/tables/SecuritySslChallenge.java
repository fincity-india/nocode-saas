/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables;


import com.fincity.security.jooq.Keys;
import com.fincity.security.jooq.Security;
import com.fincity.security.jooq.enums.SecuritySslChallengeChallengeType;
import com.fincity.security.jooq.enums.SecuritySslChallengeStatus;
import com.fincity.security.jooq.tables.records.SecuritySslChallengeRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function12;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row12;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecuritySslChallenge extends TableImpl<SecuritySslChallengeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>security.security_ssl_challenge</code>
     */
    public static final SecuritySslChallenge SECURITY_SSL_CHALLENGE = new SecuritySslChallenge();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SecuritySslChallengeRecord> getRecordType() {
        return SecuritySslChallengeRecord.class;
    }

    /**
     * The column <code>security.security_ssl_challenge.ID</code>. Primary key
     */
    public final TableField<SecuritySslChallengeRecord, ULong> ID = createField(DSL.name("ID"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key");

    /**
     * The column <code>security.security_ssl_challenge.REQUEST_ID</code>. SSL
     * request ID for which this challenge belongs to
     */
    public final TableField<SecuritySslChallengeRecord, ULong> REQUEST_ID = createField(DSL.name("REQUEST_ID"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "SSL request ID for which this challenge belongs to");

    /**
     * The column <code>security.security_ssl_challenge.CHALLENGE_TYPE</code>.
     * Challenge type
     */
    public final TableField<SecuritySslChallengeRecord, SecuritySslChallengeChallengeType> CHALLENGE_TYPE = createField(DSL.name("CHALLENGE_TYPE"), SQLDataType.VARCHAR(7).nullable(false).asEnumDataType(com.fincity.security.jooq.enums.SecuritySslChallengeChallengeType.class), this, "Challenge type");

    /**
     * The column <code>security.security_ssl_challenge.DOMAIN</code>. Domain
     * for which this challenge is valid
     */
    public final TableField<SecuritySslChallengeRecord, String> DOMAIN = createField(DSL.name("DOMAIN"), SQLDataType.VARCHAR(1024).nullable(false), this, "Domain for which this challenge is valid");

    /**
     * The column <code>security.security_ssl_challenge.TOKEN</code>. Challenge
     * token for HTTP-01 challenge/Challenge TXT record name for DNS-01
     * challenge
     */
    public final TableField<SecuritySslChallengeRecord, String> TOKEN = createField(DSL.name("TOKEN"), SQLDataType.VARCHAR(1024).nullable(false), this, "Challenge token for HTTP-01 challenge/Challenge TXT record name for DNS-01 challenge");

    /**
     * The column <code>security.security_ssl_challenge.AUTHORIZATION</code>.
     * Challenge key authorization for HTTP-01 challenge/Digest for DNS-01
     * challenge
     */
    public final TableField<SecuritySslChallengeRecord, String> AUTHORIZATION = createField(DSL.name("AUTHORIZATION"), SQLDataType.VARCHAR(1024).nullable(false), this, "Challenge key authorization for HTTP-01 challenge/Digest for DNS-01 challenge");

    /**
     * The column <code>security.security_ssl_challenge.STATUS</code>. Challenge
     * status
     */
    public final TableField<SecuritySslChallengeRecord, SecuritySslChallengeStatus> STATUS = createField(DSL.name("STATUS"), SQLDataType.VARCHAR(7).nullable(false).defaultValue(DSL.inline("PENDING", SQLDataType.VARCHAR)).asEnumDataType(com.fincity.security.jooq.enums.SecuritySslChallengeStatus.class), this, "Challenge status");

    /**
     * The column <code>security.security_ssl_challenge.FAILED_REASON</code>.
     * Reason for challenge failure
     */
    public final TableField<SecuritySslChallengeRecord, String> FAILED_REASON = createField(DSL.name("FAILED_REASON"), SQLDataType.CLOB, this, "Reason for challenge failure");

    /**
     * The column
     * <code>security.security_ssl_challenge.LAST_VALIDATED_AT</code>. Time when
     * this challenge is validated
     */
    public final TableField<SecuritySslChallengeRecord, LocalDateTime> LAST_VALIDATED_AT = createField(DSL.name("LAST_VALIDATED_AT"), SQLDataType.LOCALDATETIME(0), this, "Time when this challenge is validated");

    /**
     * The column <code>security.security_ssl_challenge.RETRY_COUNT</code>.
     * Number of times this challenge is retried
     */
    public final TableField<SecuritySslChallengeRecord, UInteger> RETRY_COUNT = createField(DSL.name("RETRY_COUNT"), SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGERUNSIGNED)), this, "Number of times this challenge is retried");

    /**
     * The column <code>security.security_ssl_challenge.CREATED_BY</code>. ID of
     * the user who created this row
     */
    public final TableField<SecuritySslChallengeRecord, ULong> CREATED_BY = createField(DSL.name("CREATED_BY"), SQLDataType.BIGINTUNSIGNED, this, "ID of the user who created this row");

    /**
     * The column <code>security.security_ssl_challenge.CREATED_AT</code>. Time
     * when this row is created
     */
    public final TableField<SecuritySslChallengeRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "Time when this row is created");

    private SecuritySslChallenge(Name alias, Table<SecuritySslChallengeRecord> aliased) {
        this(alias, aliased, null);
    }

    private SecuritySslChallenge(Name alias, Table<SecuritySslChallengeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>security.security_ssl_challenge</code> table
     * reference
     */
    public SecuritySslChallenge(String alias) {
        this(DSL.name(alias), SECURITY_SSL_CHALLENGE);
    }

    /**
     * Create an aliased <code>security.security_ssl_challenge</code> table
     * reference
     */
    public SecuritySslChallenge(Name alias) {
        this(alias, SECURITY_SSL_CHALLENGE);
    }

    /**
     * Create a <code>security.security_ssl_challenge</code> table reference
     */
    public SecuritySslChallenge() {
        this(DSL.name("security_ssl_challenge"), null);
    }

    public <O extends Record> SecuritySslChallenge(Table<O> child, ForeignKey<O, SecuritySslChallengeRecord> key) {
        super(child, key, SECURITY_SSL_CHALLENGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Security.SECURITY;
    }

    @Override
    public Identity<SecuritySslChallengeRecord, ULong> getIdentity() {
        return (Identity<SecuritySslChallengeRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<SecuritySslChallengeRecord> getPrimaryKey() {
        return Keys.KEY_SECURITY_SSL_CHALLENGE_PRIMARY;
    }

    @Override
    public List<ForeignKey<SecuritySslChallengeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1_SSL_CHLNG_REQ_ID);
    }

    private transient SecuritySslRequest _securitySslRequest;

    /**
     * Get the implicit join path to the
     * <code>security.security_ssl_request</code> table.
     */
    public SecuritySslRequest securitySslRequest() {
        if (_securitySslRequest == null)
            _securitySslRequest = new SecuritySslRequest(this, Keys.FK1_SSL_CHLNG_REQ_ID);

        return _securitySslRequest;
    }

    @Override
    public SecuritySslChallenge as(String alias) {
        return new SecuritySslChallenge(DSL.name(alias), this);
    }

    @Override
    public SecuritySslChallenge as(Name alias) {
        return new SecuritySslChallenge(alias, this);
    }

    @Override
    public SecuritySslChallenge as(Table<?> alias) {
        return new SecuritySslChallenge(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SecuritySslChallenge rename(String name) {
        return new SecuritySslChallenge(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecuritySslChallenge rename(Name name) {
        return new SecuritySslChallenge(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SecuritySslChallenge rename(Table<?> name) {
        return new SecuritySslChallenge(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<ULong, ULong, SecuritySslChallengeChallengeType, String, String, String, SecuritySslChallengeStatus, String, LocalDateTime, UInteger, ULong, LocalDateTime> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function12<? super ULong, ? super ULong, ? super SecuritySslChallengeChallengeType, ? super String, ? super String, ? super String, ? super SecuritySslChallengeStatus, ? super String, ? super LocalDateTime, ? super UInteger, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function12<? super ULong, ? super ULong, ? super SecuritySslChallengeChallengeType, ? super String, ? super String, ? super String, ? super SecuritySslChallengeStatus, ? super String, ? super LocalDateTime, ? super UInteger, ? super ULong, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
