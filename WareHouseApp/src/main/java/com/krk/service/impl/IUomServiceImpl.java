package com.krk.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krk.model.Uom;
import com.krk.repositary.UomRepositary;
import com.krk.service.IUomService;
@Service
public class IUomServiceImpl implements IUomService{
	//injecting repo interface here
    @Autowired
	private UomRepositary repo;
    /**
     * saving Uom data
     * @param uom - uom object
     */
	@Override
	public Integer saveUom(Uom uom) {
		return repo.save(uom).getId();
	}

	@Override
	public List<Uom> getAllUoms() {
		return repo.findAll();
	}

	@Override
	public String deleteUom(Integer id) {
	  Optional<Uom> opt=repo.findById(id);
	  if(opt.isPresent()) {
		  repo.deleteById(id);
	  }
	  
		return "deleted with id no "+id;
	}
	

}
