package com.fincity.saas.files.util;

public class FileExtensionUtil {

	public static String get(String name) {

		if (name == null || name.isBlank())
			return "";

		int ind = name.lastIndexOf('.');
		if (ind == -1 || ind + 1 == name.length())
			return "";

		return name.substring(ind + 1);
	}

	public static String getFileNameWithExtension(String actualFile, String fileName) {

		if (fileName == null || fileName.isBlank())
			return "";

		return fileName + "." + get(actualFile);
	}

	private FileExtensionUtil() {
	}
}
