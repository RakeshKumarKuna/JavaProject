package com.krk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krk.model.PurchaseOrder;
import com.krk.service.IPurchaseOrderService;

@Controller
@RequestMapping("/pc")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
    @GetMapping("/registration")
	public String savePurchaseOrder(Map map) {
    	map.put("pcobj", new PurchaseOrder());
		return "PurchaseRegistraion";
	}
    @PostMapping("/save")
    public String savePurchase(@ModelAttribute PurchaseOrder pcorder,RedirectAttributes redirect) {
    	int id=service.savePurchaseOrder(pcorder);
    	redirect.addFlashAttribute("savemsg","Your Rigistartion Completed" );
    	return "redirect:registration";
    }
    @GetMapping("/all")
    public String getAllData(Map map) {
    	List<PurchaseOrder> list=service.getAllPurchaseOrders();
        map.put("list", list);
    	return "PurchaseData";
    }
}
