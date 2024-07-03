package com.krk.service;
import java.util.List;

import com.krk.model.PurchaseDtl;
import com.krk.model.PurchaseOrder;

public interface IPurchaseOrderService {
public Integer savePurchaseOrder(PurchaseOrder purchaseOrder);
public List<PurchaseOrder> getAllPurchaseOrders();
void updatePurchaseOrder(PurchaseOrder st);
void deletePurchaseOrder(Integer id);
PurchaseOrder getOnePurchaseOrder(Integer id);
Integer savepurchaseOrderDtl(PurchaseDtl dtl);
public List<PurchaseDtl> getPurchaseDtlsByOrderid(Integer orderId); 
public void deleteDtlById(Integer id);
public Integer getCount() ;
}
