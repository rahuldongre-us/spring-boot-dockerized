package com.saic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saic.demo.dto.AppDto;
import com.saic.demo.dto.DocDto;
import com.saic.demo.model.Documentz;
import com.saic.demo.service.ApplicationInfoBusinessService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "Applications", description = "Operations related to applications and documents")

public class DemoController {

	@Autowired
	private ApplicationInfoBusinessService applicationInfoBusinessService;

	@Operation(summary = "Get documents by application ID", description = "given an application identifier, find all the documents associated with that application sorted by document identifier;")
	@GetMapping("docz/application/{appId}")
	public List<Documentz> getDocsByAppId(@PathVariable(name = "appId") Integer appId) {
		return applicationInfoBusinessService.getDocumentsByApplicationId(appId);
	}

	@PostMapping("docz")
	public ResponseEntity<DocDto> createDocument(@Valid @RequestBody DocDto dto) {
		Documentz savedDoc = applicationInfoBusinessService.createDocument(dto);
		// return ResponseEntity.ok("Document created with id " + savedDoc.getId());
		return ResponseEntity.ok(new DocDto(savedDoc));
	}

	@PostMapping("application")
	public ResponseEntity<AppDto> createApplication(@Valid @RequestBody AppDto dto) {
		AppDto savedApp = applicationInfoBusinessService.createApplicationWithDocs(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedApp);
	}

	@Operation(summary = "Get application by ID", description = "Returns application and associated documents by ID")
	@GetMapping("/application/{id}")
	public ResponseEntity<AppDto> getApplication(
			@Parameter(description = "ID of the application", required = true) @PathVariable(name = "id") Integer id) {
		AppDto app = applicationInfoBusinessService.getApplicationById(id);
		return ResponseEntity.ok(app);
	}

	@GetMapping("/applications")
	public ResponseEntity<Iterable<AppDto>> getAllApplications() {
		Iterable<AppDto> app = applicationInfoBusinessService.getAllApplications();
		return ResponseEntity.ok(app);
	}

	/*
	 * 
	 * 3) Design/develop a set of URL(s) to perform the following tasks: b) Retrieve
	 * the application title for a given document identifier that the document is
	 * associated with
	 */
	@Operation(summary = "Get application title by Doc ID", description = "Returns application title for given document ID")
	@GetMapping("docz/applicationTitle/{docId}")
	public ResponseEntity<String> getApplicationTitleByDocId(
			@Parameter(description = "ID of the application", required = true) @PathVariable(name = "docId") Integer docId) {
		DocDto app = applicationInfoBusinessService.getApplicationTitleByDocId(docId);
		return ResponseEntity.ok(app.getTitle());
	}

}
