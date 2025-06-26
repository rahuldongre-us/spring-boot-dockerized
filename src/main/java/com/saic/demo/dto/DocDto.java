package com.saic.demo.dto;

import com.saic.demo.model.Documentz;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class DocDto {
	
	private Integer id;

	@NotBlank(message = "Title is required")
	private String title;

	@NotNull(message = "Application ID is required")
	private Integer applicationId;
	
    public DocDto(Documentz doc) {
        this.id = doc.getId();
        this.title = doc.getTitle();
        this.applicationId = doc.getApplicationz().getId();
    }
}
