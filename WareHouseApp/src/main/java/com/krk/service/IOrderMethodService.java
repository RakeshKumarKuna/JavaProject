package com.krk.service;

import java.util.List;
import java.util.Map;

import com.krk.model.OrderMethod;

public interface IOrderMethodService {
Integer saveOrderMethod(OrderMethod orderMethod);
void updateOrderMethod(OrderMethod orderMehtod);
void deleteOrderMethod(int id);
List<OrderMethod> getAllOrderMethod();
Map<Integer,String> getOrderMethodIdAndOrderMehtodCodeByOrderMode(String mode);
}
