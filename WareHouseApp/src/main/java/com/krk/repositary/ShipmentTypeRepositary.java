package com.krk.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krk.model.ShipmentType;

public interface ShipmentTypeRepositary extends JpaRepository<ShipmentType, Integer> {

}
