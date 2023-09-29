package com.krk.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krk.model.Uom;

public interface UomRepositary extends JpaRepository<Uom, Integer> {
	

}
