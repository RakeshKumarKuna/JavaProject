package com.krk.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krk.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {

}
