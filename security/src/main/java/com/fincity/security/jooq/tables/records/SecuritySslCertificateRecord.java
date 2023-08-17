/*
 * This file is generated by jOOQ.
 */
package com.fincity.security.jooq.tables.records;


import com.fincity.security.jooq.tables.SecuritySslCertificate;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SecuritySslCertificateRecord extends UpdatableRecordImpl<SecuritySslCertificateRecord> implements Record13<ULong, ULong, String, String, String, String, String, String, LocalDateTime, String, Byte, ULong, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>security.security_ssl_certificate.ID</code>. Primary key
     */
    public SecuritySslCertificateRecord setId(ULong value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.ID</code>. Primary key
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.URL_ID</code>. URL ID
     * for which this SSL certificate belongs to
     */
    public SecuritySslCertificateRecord setUrlId(ULong value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.URL_ID</code>. URL ID
     * for which this SSL certificate belongs to
     */
    public ULong getUrlId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CRT</code>. SSL
     * certificate
     */
    public SecuritySslCertificateRecord setCrt(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CRT</code>. SSL
     * certificate
     */
    public String getCrt() {
        return (String) get(2);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CRT_CHAIN</code>. SSL
     * certificate chain
     */
    public SecuritySslCertificateRecord setCrtChain(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CRT_CHAIN</code>. SSL
     * certificate chain
     */
    public String getCrtChain() {
        return (String) get(3);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CRT_KEY</code>. SSL
     * certificate key
     */
    public SecuritySslCertificateRecord setCrtKey(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CRT_KEY</code>. SSL
     * certificate key
     */
    public String getCrtKey() {
        return (String) get(4);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CSR</code>. SSL
     * certificate signing request
     */
    public SecuritySslCertificateRecord setCsr(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CSR</code>. SSL
     * certificate signing request
     */
    public String getCsr() {
        return (String) get(5);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.DOMAINS</code>.
     * Domains for which this SSL certificate is valid
     */
    public SecuritySslCertificateRecord setDomains(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.DOMAINS</code>.
     * Domains for which this SSL certificate is valid
     */
    public String getDomains() {
        return (String) get(6);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.ORGANIZATION</code>.
     * Organization for which this SSL certificate is valid
     */
    public SecuritySslCertificateRecord setOrganization(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.ORGANIZATION</code>.
     * Organization for which this SSL certificate is valid
     */
    public String getOrganization() {
        return (String) get(7);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.EXPIRY_DATE</code>.
     * Expiry date of this SSL certificate
     */
    public SecuritySslCertificateRecord setExpiryDate(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.EXPIRY_DATE</code>.
     * Expiry date of this SSL certificate
     */
    public LocalDateTime getExpiryDate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.ISSUER</code>. Issuer
     * of this SSL certificate
     */
    public SecuritySslCertificateRecord setIssuer(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.ISSUER</code>. Issuer
     * of this SSL certificate
     */
    public String getIssuer() {
        return (String) get(9);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CURRENT</code>. Is
     * this the current SSL certificate for the URL
     */
    public SecuritySslCertificateRecord setCurrent(Byte value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CURRENT</code>. Is
     * this the current SSL certificate for the URL
     */
    public Byte getCurrent() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public SecuritySslCertificateRecord setCreatedBy(ULong value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CREATED_BY</code>. ID
     * of the user who created this row
     */
    public ULong getCreatedBy() {
        return (ULong) get(11);
    }

    /**
     * Setter for <code>security.security_ssl_certificate.CREATED_AT</code>.
     * Time when this row is created
     */
    public SecuritySslCertificateRecord setCreatedAt(LocalDateTime value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>security.security_ssl_certificate.CREATED_AT</code>.
     * Time when this row is created
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<ULong, ULong, String, String, String, String, String, String, LocalDateTime, String, Byte, ULong, LocalDateTime> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<ULong, ULong, String, String, String, String, String, String, LocalDateTime, String, Byte, ULong, LocalDateTime> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.ID;
    }

    @Override
    public Field<ULong> field2() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.URL_ID;
    }

    @Override
    public Field<String> field3() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CRT;
    }

    @Override
    public Field<String> field4() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CRT_CHAIN;
    }

    @Override
    public Field<String> field5() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CRT_KEY;
    }

    @Override
    public Field<String> field6() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CSR;
    }

    @Override
    public Field<String> field7() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.DOMAINS;
    }

    @Override
    public Field<String> field8() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.ORGANIZATION;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.EXPIRY_DATE;
    }

    @Override
    public Field<String> field10() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.ISSUER;
    }

    @Override
    public Field<Byte> field11() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CURRENT;
    }

    @Override
    public Field<ULong> field12() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field13() {
        return SecuritySslCertificate.SECURITY_SSL_CERTIFICATE.CREATED_AT;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public ULong component2() {
        return getUrlId();
    }

    @Override
    public String component3() {
        return getCrt();
    }

    @Override
    public String component4() {
        return getCrtChain();
    }

    @Override
    public String component5() {
        return getCrtKey();
    }

    @Override
    public String component6() {
        return getCsr();
    }

    @Override
    public String component7() {
        return getDomains();
    }

    @Override
    public String component8() {
        return getOrganization();
    }

    @Override
    public LocalDateTime component9() {
        return getExpiryDate();
    }

    @Override
    public String component10() {
        return getIssuer();
    }

    @Override
    public Byte component11() {
        return getCurrent();
    }

    @Override
    public ULong component12() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component13() {
        return getCreatedAt();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public ULong value2() {
        return getUrlId();
    }

    @Override
    public String value3() {
        return getCrt();
    }

    @Override
    public String value4() {
        return getCrtChain();
    }

    @Override
    public String value5() {
        return getCrtKey();
    }

    @Override
    public String value6() {
        return getCsr();
    }

    @Override
    public String value7() {
        return getDomains();
    }

    @Override
    public String value8() {
        return getOrganization();
    }

    @Override
    public LocalDateTime value9() {
        return getExpiryDate();
    }

    @Override
    public String value10() {
        return getIssuer();
    }

    @Override
    public Byte value11() {
        return getCurrent();
    }

    @Override
    public ULong value12() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value13() {
        return getCreatedAt();
    }

    @Override
    public SecuritySslCertificateRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value2(ULong value) {
        setUrlId(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value3(String value) {
        setCrt(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value4(String value) {
        setCrtChain(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value5(String value) {
        setCrtKey(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value6(String value) {
        setCsr(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value7(String value) {
        setDomains(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value8(String value) {
        setOrganization(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value9(LocalDateTime value) {
        setExpiryDate(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value10(String value) {
        setIssuer(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value11(Byte value) {
        setCurrent(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value12(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord value13(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public SecuritySslCertificateRecord values(ULong value1, ULong value2, String value3, String value4, String value5, String value6, String value7, String value8, LocalDateTime value9, String value10, Byte value11, ULong value12, LocalDateTime value13) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SecuritySslCertificateRecord
     */
    public SecuritySslCertificateRecord() {
        super(SecuritySslCertificate.SECURITY_SSL_CERTIFICATE);
    }

    /**
     * Create a detached, initialised SecuritySslCertificateRecord
     */
    public SecuritySslCertificateRecord(ULong id, ULong urlId, String crt, String crtChain, String crtKey, String csr, String domains, String organization, LocalDateTime expiryDate, String issuer, Byte current, ULong createdBy, LocalDateTime createdAt) {
        super(SecuritySslCertificate.SECURITY_SSL_CERTIFICATE);

        setId(id);
        setUrlId(urlId);
        setCrt(crt);
        setCrtChain(crtChain);
        setCrtKey(crtKey);
        setCsr(csr);
        setDomains(domains);
        setOrganization(organization);
        setExpiryDate(expiryDate);
        setIssuer(issuer);
        setCurrent(current);
        setCreatedBy(createdBy);
        setCreatedAt(createdAt);
        resetChangedOnNotNull();
    }
}
