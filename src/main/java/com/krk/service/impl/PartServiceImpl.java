package com.krk.service.impl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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
        Optional<Part> i= repo.findById(id);
        if(i.isPresent()) {
        	repo.deleteById(id);
        }
        else {
        	throw new PartNotFoundException("Part Not Found");
        }
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

	@Override
	public Map<Integer, String> getPartIDAndCode() {
		List<Object[]> list= repo.getPartIDAndCode();
		Map map=list.stream().collect(Collectors.toMap((ob)->Integer.valueOf(ob[0].toString()), (ob)->ob[1].toString()));
		return map;
	}
	
	
	
	
}