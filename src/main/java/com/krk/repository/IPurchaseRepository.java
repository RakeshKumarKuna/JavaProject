package com.krk.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.PurchaseOrder;

public interface IPurchaseRepository extends JpaRepository<PurchaseOrder, Integer> {
	@Modifying
	@Query("UPDATE PurchaseOrder SET status = :status WHERE orderId = :orderId")
	void updatestatus(String status, Integer orderId);
}
