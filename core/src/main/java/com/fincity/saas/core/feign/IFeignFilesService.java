package com.fincity.saas.core.feign;

import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.fincity.saas.core.configuration.FileFeignConfiguration;

import lombok.Data;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "files", configuration = FileFeignConfiguration.class)
public interface IFeignFilesService {

	@PostMapping(value = "${core.feign.staticURI:api/files/static/**}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Mono<FileDetail> create(@RequestPart(name = "file", required = false) Mono<FilePart> filePart,
	        @RequestParam(required = false) String clientCode,
	        @RequestPart(required = false, name = "override") String override,
	        @RequestPart(required = false, name = "name") String fileName, ServerHttpRequest request);

	@Data
	public static class FileDetail {
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
	}
}
