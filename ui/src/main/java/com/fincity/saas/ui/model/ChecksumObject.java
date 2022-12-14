package com.fincity.saas.ui.model;

import java.math.BigInteger;
import java.security.MessageDigest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChecksumObject {

	private String checkSum;
	private String objectString;
	
	public ChecksumObject(String objectString) {
		this.objectString = objectString;
	}
	
	public String getCheckSum() {
		
		if (this.checkSum != null) 
			return this.checkSum;

        try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(objectString.getBytes());
	        BigInteger no = new BigInteger(1, messageDigest);
	        this.checkSum = no.toString(16);
        } catch (Exception ex) {
	        checkSum = Integer.toHexString(objectString.hashCode());
        }
		
		return this.checkSum;
	}
}
