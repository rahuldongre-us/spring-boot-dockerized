package com.saic.demo.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.saic.demo.model.Applicationz;
import com.saic.demo.model.Documentz;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppDto {

	private Integer id;

	@NotBlank(message = "Title is required")
	private String title;

	private List<DocDto> documents;

	/*
	 * 3) Design/develop a set of URL(s) to perform the following tasks: a) Retrieve
	 * all the documents for a given application identifier and sorted by document
	 * identifier
	 * 
	 */

	public AppDto(Applicationz app) {
		this.id = app.getId();
		this.title = app.getTitle();
		this.documents = app.getDocumentzes().stream().sorted(Comparator.comparing(Documentz::getId).reversed())
				.map(DocDto::new).collect(Collectors.toList());
	}
}
