package com.krk.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.PurchaseDtl;

public interface PurchaseDtlRepository extends JpaRepository<PurchaseDtl, Integer>{

	@Query("select dtl from PurchaseDtl dtl join dtl.order as order where order.id=:orderId")
	public List<PurchaseDtl> getPurchaseDtlsByOrderid(Integer orderId); 
	
//	@Query("select count(*) from PurchaseDtl")
	@Query("select count(dtl) from PurchaseDtl dtl join dtl.order as order where order.id=:orderId")
	public Integer getCount(Integer orderId);
}
