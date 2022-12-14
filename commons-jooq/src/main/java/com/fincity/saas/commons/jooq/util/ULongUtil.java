package com.fincity.saas.commons.jooq.util;

import java.math.BigInteger;

import org.jooq.types.ULong;

public class ULongUtil {

	public static ULong valueOf(Object o) {

		if (o == null)
			return null;

		if (o instanceof ULong v)
			return v;
		
		if (o instanceof BigInteger b)
			return ULong.valueOf(b);

		return ULong.valueOf(o.toString());
	}

	private ULongUtil() {
	}
}
