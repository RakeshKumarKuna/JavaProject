package com.krk.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krk.model.OrderMethod;
import com.krk.repository.OrderMethodRepository;
import com.krk.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private OrderMethodRepository orderRepo;

	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return orderRepo.save(orderMethod).getId();
	}

	@Override
	public void updateOrderMethod(OrderMethod orderMehtod) {
		orderRepo.save(orderMehtod);
	}

	@Override
	public void deleteOrderMethod(int id) {
		orderRepo.deleteById(id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		return orderRepo.findAll();
	}

	@Override
	public Map<Integer, String> getOrderMethodIdAndOrderMehtodCodeByOrderMode(String mode) {
	List<Object[]> list=	orderRepo.getOrderMethodIdAndCodeByMode(mode);
	Map<Integer,String> map=list.stream()
			                                               .collect(
			                                            		   Collectors.toMap(
			                                            		   ob-> Integer.valueOf(ob[0].toString()),
			                                            		   ob-> ob[1].toString())
			                                            		   );
	return map;
	}

}
