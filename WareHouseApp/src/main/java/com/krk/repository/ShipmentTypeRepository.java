package com.krk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {
	@Query("SELECT COUNT(shipmentCode) FROM ShipmentType WHERE shipmentCode=:shipmentCode")
	Integer getShipmentTypeCodeCount(String shipmentCode);
	//shipmentMode, count(shipmentMode)
	@Query("SELECT shipmentMode, COUNT(shipmentMode) FROM ShipmentType GROUP BY shipmentMode")
	List<Object[]> getShipmentModeAndCount();
}
