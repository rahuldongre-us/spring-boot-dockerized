package com.saic.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saic.demo.dto.AppDto;
import com.saic.demo.dto.DocDto;
import com.saic.demo.model.Applicationz;
import com.saic.demo.model.Documentz;
import com.saic.demo.repo.ApplicationRepository;
import com.saic.demo.repo.DocumentRepository;

@Service
public class ApplicationInfoBusinessService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private DocumentRepository documentRepository;

	/*
	 * 
	 * 2) Design/develop a business service layer (let's call it
	 * "ApplicationInfoBusinessService") to perform the following tasks: a) given an
	 * application identifier, find all the documents associated with that
	 * application sorted by document identifier;
	 * 
	 */

	public List<Documentz> getDocumentsByApplicationId(Integer documentId) {
		return documentRepository.findByApplicationzIdOrderByIdDesc(documentId);
		// return documentRepository.findByApplicationzId(documentId,
		// Sort.by(Sort.Direction.DESC, "id"));
		// return
		// applicationRepository.findById(documentId).map(Applicationz::getDocumentzes).orElseThrow(()
		// -> new RuntimeException("Application not found"));
	}

	public Documentz createDocument(DocDto dto) {
		Applicationz application = applicationRepository.findById(dto.getApplicationId())
				.orElseThrow(() -> new RuntimeException("Application not found with ID " + dto.getApplicationId()));

		Documentz doc = new Documentz();
		doc.setTitle(dto.getTitle());
		doc.setApplicationz(application);

		return documentRepository.save(doc);
	}

	public AppDto createApplicationWithDocs(AppDto dto) {
		Applicationz appz = new Applicationz();
		appz.setTitle(dto.getTitle());

		List<Documentz> docs = dto.getDocuments().stream().map(d -> {
			Documentz doc = new Documentz();
			doc.setTitle(d.getTitle());
			doc.setApplicationz(appz);
			return doc;
		}).toList();

		appz.setDocumentzes(docs);

		Applicationz saved = applicationRepository.save(appz);

		return new AppDto(saved);
	}

	public AppDto getApplicationById(Integer id) {
		Applicationz app = applicationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

		return new AppDto(app);
	}

	public Iterable<AppDto> getAllApplications() {
		List<Applicationz> apps = (List<Applicationz>) applicationRepository.findAll();
		return apps.stream().map(AppDto::new).toList();
	}

	public DocDto getApplicationTitleByDocId(Integer docId) {
		Documentz docz = documentRepository.findById(docId)
				.orElseThrow(() -> new RuntimeException("Document not found with id: " + docId));

		return new DocDto(docz);
	}

}
