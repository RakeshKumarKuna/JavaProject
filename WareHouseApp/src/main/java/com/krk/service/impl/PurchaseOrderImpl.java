package com.krk.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krk.exception.PurchaseOrderNotFoundException;
import com.krk.model.PurchaseOrder;
import com.krk.repository.IPurchaseRepository;
import com.krk.service.IPurchaseOrderService;
@Service
public class PurchaseOrderImpl implements IPurchaseOrderService {
  @Autowired
	private  IPurchaseRepository repo;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return repo.save(purchaseOrder).getOrderId();
	}
	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return repo.findAll();
	}
	@Override
	public void updatePurchaseOrder(PurchaseOrder st) {
      repo.save(st);
	}
	@Override
	public void deletePurchaseOrder(Integer id) {
    repo.deleteById(id);
	}
	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return repo.findById(id).orElseThrow( ()->new PurchaseOrderNotFoundException("PurchaseOrder id: "+id+" Not Fount"));
	}
}
