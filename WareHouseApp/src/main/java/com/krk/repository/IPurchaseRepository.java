package com.krk.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.krk.model.PurchaseOrder;

public interface IPurchaseRepository extends JpaRepository<PurchaseOrder, Integer> {

}
