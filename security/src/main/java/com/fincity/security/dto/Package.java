package com.fincity.security.dto;

import org.jooq.types.ULong;

import com.fincity.saas.commons.model.dto.AbstractUpdatableDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Package extends AbstractUpdatableDTO<ULong, ULong> {

	private static final long serialVersionUID = -7920462907193913694L;

	private ULong clientId;
	private String code;
	private String name;
	private String description;
	private boolean base;
	private ULong appId;
}
