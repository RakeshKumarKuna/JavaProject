package com.krk.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
  /**
   * getting all the data
   */
	@Override
	public List<Uom> getAllUoms() {
		return repo.findAll();
	}
  /**
   * deleting the record eith id
   */
	@Override
	public String deleteUom(Integer id) {
	  Optional<Uom> opt=repo.findById(id);
	  if(opt.isPresent()) {
		  repo.deleteById(id);
	  }
		return "deleted with id no "+id;
	}

	@Override
	public Uom getOneRecord(Integer id) {
		Optional<Uom> opt= repo.findById(id);
		return opt.get();
	}
	
	@Override
	public boolean isUomModelExist(String uomModel) {
		return repo.getUomModelCount(uomModel) > 0 ? true : false;
	}
	
	@Override
	public List<Object[]> getUomTypeAndCount() {
		repo.getUomTypeAndCount().forEach(System.out::println);
     return    repo.getUomTypeAndCount();
	
	}
	@Override
	public Map<Integer, String> getUomIdAndModel() {
		List<Object[]> list = repo.getUomIdAndModel();

		/*
		 * //JDK 1.8 Map<Integer,String> map = list.stream() .collect( Collectors.toMap(
		 * ob->Integer.valueOf(ob.toString()), ob->ob.toString()) );
		 */
		//converting list<Object[]> to map<key,value>
		
		Map<Integer,String> map = new LinkedHashMap<>();
		for(Object[] ob:list) {
			map.put(
					Integer.valueOf(ob[0].toString()), 
					ob[1].toString()
				);
		}
		return map;
	}
}
