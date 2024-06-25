package com.krk.service;
import java.util.List;
import java.util.Map;

import com.krk.model.ShipmentType;
public interface IShipmentTypeService {
	Integer saveShipmentType(ShipmentType st);
	void updateShipmentType(ShipmentType st);
	void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	List<ShipmentType> getAllShipmentTypes();
	Map<Integer,String> getShipmentIdAndCodeByEnabled(String enabled);
}
