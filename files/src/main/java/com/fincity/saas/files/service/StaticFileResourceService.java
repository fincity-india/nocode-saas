package com.fincity.saas.files.service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fincity.saas.files.jooq.enums.FilesAccessPathResourceType;

import reactor.core.publisher.Mono;

@Service
public class StaticFileResourceService extends AbstractFilesResourceService {
	
	private static final String URI_PART = "api/files/static";
	private static final int URI_PART_LENGTH = URI_PART.length();

	private static final String URI_PART_FILE = "api/files/static/file";
	private static final int URI_PART_FILE_LENGTH = URI_PART_FILE.length();

	@Value("${files.resources.location.static}")
	private String location;

	private String staticResourceLocation;

	@PostConstruct
	private void initialize() {
		this.staticResourceLocation = location.replace("/", "\\\\");
	}

	@Override
	public String getBaseLocation() {
		return this.staticResourceLocation;
	}

	@Override
	public FilesAccessPathResourceType getResourceType() {
		return FilesAccessPathResourceType.STATIC;
	}

	@Override
	public Mono<Path> resolveFileToRead(String requestURI) {

		String path = requestURI.substring(requestURI.indexOf(URI_PART_FILE) + URI_PART_FILE_LENGTH);

		int index = path.indexOf('?');
		if (index != -1)
			path = path.substring(0, index);

		if (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);

		return Mono.just(Paths.get(this.staticResourceLocation, URLDecoder.decode(path, StandardCharsets.UTF_8)));
	}

	@Override
	public String resolvePathForList(String uri) {

		String path = uri.substring(uri.indexOf(URI_PART) + URI_PART_LENGTH,
		        uri.length() - (uri.endsWith("/") ? 1 : 0));
		
		int index = path.indexOf('?');
		if (index != -1)
			path = path.substring(0, index);

		if (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);
		
		return path;
	}
}
