package com.fincity.security.dto;

import org.jooq.types.ULong;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Package extends AbstractUpdatableDTO<ULong, ULong> {

	private static final long serialVersionUID = -7920462907193913694L;

	private String code;
	private String name;
	private String description;
	private boolean base;
}
