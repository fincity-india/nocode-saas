package com.fincity.saas.data.dto;

import org.jooq.types.ULong;
import org.jooq.types.UShort;

import com.fincity.saas.commons.model.dto.AbstractUpdatableDTO;
import com.fincity.saas.data.jooq.enums.DataStorageFieldType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StorageField extends AbstractUpdatableDTO<ULong, ULong> {

	private static final long serialVersionUID = 4818996620726412681L;

	private String name;
	private DataStorageFieldType type;
	private UShort size;
	private ULong storageId;
	private String defaultValue;
	private ULong refStorageFieldId;
}
