package com.krk.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krk.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {
	@Query("SELECT id,orderCode FROM OrderMethod WHERE orderMode=:mode")
	public List<Object[]> getOrderMethodIdAndCodeByMode(String mode);
}
