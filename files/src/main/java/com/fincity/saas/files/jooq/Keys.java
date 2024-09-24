/*
 * This file is generated by jOOQ.
 */
package com.fincity.saas.files.jooq;


import com.fincity.saas.files.jooq.tables.FilesAccessPath;
import com.fincity.saas.files.jooq.tables.FilesSecuredAccessKeys;
import com.fincity.saas.files.jooq.tables.records.FilesAccessPathRecord;
import com.fincity.saas.files.jooq.tables.records.FilesSecuredAccessKeysRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * files.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FilesAccessPathRecord> KEY_FILES_ACCESS_PATH_PRIMARY = Internal.createUniqueKey(FilesAccessPath.FILES_ACCESS_PATH, DSL.name("KEY_files_access_path_PRIMARY"), new TableField[] { FilesAccessPath.FILES_ACCESS_PATH.ID }, true);
    public static final UniqueKey<FilesSecuredAccessKeysRecord> KEY_FILES_SECURED_ACCESS_KEYS_PRIMARY = Internal.createUniqueKey(FilesSecuredAccessKeys.FILES_SECURED_ACCESS_KEYS, DSL.name("KEY_files_secured_access_keys_PRIMARY"), new TableField[] { FilesSecuredAccessKeys.FILES_SECURED_ACCESS_KEYS.ID }, true);
    public static final UniqueKey<FilesSecuredAccessKeysRecord> KEY_FILES_SECURED_ACCESS_KEYS_UK1_ACCESS_KEY = Internal.createUniqueKey(FilesSecuredAccessKeys.FILES_SECURED_ACCESS_KEYS, DSL.name("KEY_files_secured_access_keys_UK1_ACCESS_KEY"), new TableField[] { FilesSecuredAccessKeys.FILES_SECURED_ACCESS_KEYS.ACCESS_KEY }, true);
}
