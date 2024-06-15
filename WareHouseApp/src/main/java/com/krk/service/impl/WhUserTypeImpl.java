package com.krk.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krk.exception.WhUserTypeNotFound;
import com.krk.model.WhUserType;
import com.krk.repository.WhUserTypeRepositary;
import com.krk.service.IWhUserTypeService;
@Service
public class WhUserTypeImpl implements IWhUserTypeService {
	@Autowired
	private WhUserTypeRepositary repo;
	
	@Override
	public Integer saveWhUserType(WhUserType whUserType) {
		return repo.save(whUserType).getId();
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return repo.findAll();
	}

	@Override
	public void deleteWhUserType(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public WhUserType getOneWhUserType(Integer id) {
		WhUserType whUserType = repo.findById(id).orElseThrow(() -> new WhUserTypeNotFound("Warehouse User Type "+id+" Not exist"));
		return whUserType;
	}
	
	@Override
	public void updateWhUserType(WhUserType whUserType) {
		repo.save(whUserType);
	}

	@Override
	public boolean isWhUserMailIdExist(String email) {
		//return repo.getWhUserEmailCount(email)>0?true:false;
		return repo.getWhUserEmailCount(email)>0;
	}

}
