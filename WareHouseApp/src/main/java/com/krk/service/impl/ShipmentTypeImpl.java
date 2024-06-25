package com.krk.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krk.Util.MyCollectionUtil;
import com.krk.exception.ShipmentTypeNotFoundException;
import com.krk.model.ShipmentType;
import com.krk.repository.ShipmentTypeRepository;
import com.krk.service.IShipmentTypeService;

@Service
public class ShipmentTypeImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentTypeRepository repo;

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return repo.save(st).getId();
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		repo.save(st);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType st = getOneShipmentType(id);
		repo.delete(st);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		ShipmentType st = repo.findById(id)
				.orElseThrow(() -> new ShipmentTypeNotFoundException("ShipmentType '" + id + "' Not exist"));
		return st;
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return repo.findAll();
	}
	@Override
	public Map<Integer,String> getShipmentIdAndCodeByEnabled(String enabled) {
		Map<Integer,String> map= MyCollectionUtil.convertListToMap(repo.getShipmentIdAndCodeByEnabled(enabled));
		return map; 
	}
}
