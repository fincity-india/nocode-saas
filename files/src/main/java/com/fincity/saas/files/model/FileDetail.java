package com.fincity.saas.files.model;

import java.nio.file.attribute.FileTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileDetail {

	private String name;
	private boolean isDirectory;
	private long size;
	private String filePath;
	private String url;
	private long createdDate;
	private long lastModifiedTime;
	private long lastAccessTime;
	private String type;
	private String fileName;

	@JsonIgnore
	private FileTime modifiedTime;

	public FileDetail setName(String name) {

		this.name = name;

		if (name == null || name.isBlank())
			return this;

		int ind = name.lastIndexOf('.');
		if (ind <= 0)
			this.fileName = name;
		else {
			this.fileName = name.substring(0, ind);
			this.type = name.substring(ind + 1)
			        .toLowerCase();
		}
		return this;
	}

	@JsonProperty("isCompressedFile")
	public boolean isCompressedFile() {

		if (this.type == null)
			return false;

		return this.type.endsWith(".zip") || this.type.endsWith(".gz");
	}
}
