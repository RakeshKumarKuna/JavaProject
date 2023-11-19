package com.krk.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krk.exception.WhUserTypeNotFound;
import com.krk.model.WhUserType;
import com.krk.repositary.WhUserTypeRepositary;
import com.krk.service.IWhUserTypeService;
@Service
public class IWhUserTypeImpl implements IWhUserTypeService {
     @Autowired
	private WhUserTypeRepositary repo;
	@Override
	public Integer saveWhUserType(WhUserType whuser) {
		return repo.save(whuser).getId();
	}

	@Override
	public List<WhUserType> getAllWhUserType() {
		return repo.findAll();
	}

	@Override
	public String deleteWhUserType(Integer id) {
		Optional<WhUserType> opt=repo.findById(id);
		if(opt.isPresent()) {
		repo.deleteById(id);
		}
     return "Deleted With id "+id;
	}

	@Override
	public WhUserType getOneRecord(Integer id) {
		WhUserType opt=repo.findById(id).orElseThrow(()->new WhUserTypeNotFound("WhUser Not Found with id :"+id));
		return opt;
	}
}
