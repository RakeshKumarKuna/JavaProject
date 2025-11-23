package com.krk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.Uom;

public interface UomRepositary extends JpaRepository<Uom, Integer> {
	
	@Query("SELECT COUNT(uomModel) FROM Uom WHERE uomModel=:uomModel")
	Integer getUomModelCount(String uomModel);
	@Query(value = "select uom_uom_type_col,count(uom_uom_type_col) from uom_tab group by uom_uom_type_col",nativeQuery = true)
	List<Object[]> getUomTypeAndCount();
	@Query("SELECT id,uomModel FROM Uom")
	List<Object[]> getUomIdAndModel();

}
