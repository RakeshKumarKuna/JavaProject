package com.krk.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krk.exception.PartNotFoundException;
import com.krk.model.Part;
import com.krk.repository.PartRepository;
import com.krk.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {
	
	@Autowired
	private PartRepository repo;
	
	@Override
	public Integer savePart(Part part) {
		return repo.save(part).getId();
	}

	@Override
	public List<Part> getAllParts() {
		return repo.findAll();
	}

	@Override
	public void deletePart(Integer id) {
		Part part  = getOnePart(id);
		repo.delete(part);
	}
	
	@Override
	public Part getOnePart(Integer id) {
		Part part = repo.findById(id)
				.orElseThrow(()-> new PartNotFoundException("Part '"+id+"' Not exist"));
		return part;
	}
	
	@Override
	public void updatePart(Part part) {
		repo.save(part);
	}
	
	
	
	
}