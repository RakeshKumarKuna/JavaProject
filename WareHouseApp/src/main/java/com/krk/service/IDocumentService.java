package com.krk.service;

import java.util.List;
import java.util.Optional;

import com.krk.model.Document;

public interface IDocumentService {

	void saveDocument(Document document);
	List<Object[]> getDocumentIdAndNames();
	Optional<Document> getOneDocument(Integer id);
}
