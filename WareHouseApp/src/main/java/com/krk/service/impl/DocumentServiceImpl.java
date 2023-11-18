package com.krk.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krk.model.Document;
import com.krk.repositary.DocumentRepo;
import com.krk.service.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService {
	@Autowired
	private DocumentRepo repo;
	
	@Override
	public void saveDocument(Document document) {
		repo.save(document);
	}

	@Override
	public List<Object[]> getDocumentIdAndNames() {
		return repo.getDocumentIdAndNames();
	}
	
	@Override
	public Optional<Document> getOneDocument(Integer id) {
		return repo.findById(id);
	}
}
