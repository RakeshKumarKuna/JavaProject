package com.krk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krk.model.PurchaseDtl;
import com.krk.model.PurchaseOrder;
import com.krk.service.IPartService;
import com.krk.service.IPurchaseOrderService;
import com.krk.service.IShipmentTypeService;
import com.krk.service.IWhUserTypeService;
import com.krk.view.VendorInvoicePdfView;

import io.micrometer.common.lang.Nullable;

@Controller
@RequestMapping("/pc")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shipmentservice;
	@Autowired
	private IWhUserTypeService whuserservice;
	@Autowired
	private IPartService partService;

	private void addDynbamicUiComponent(Map map) {
		map.put("shimpmenttypes", shipmentservice.getShipmentIdAndCodeByEnabled("YES"));
		map.put("whusertypes", whuserservice.getWhUserTypeByUserType("Vendor"));
	}

	@GetMapping("/registration")
	public String showPurchaseOrder(Map map) {
		addDynbamicUiComponent(map);
		PurchaseOrder obj = new PurchaseOrder();
		obj.setStatus("Open");
		map.put("pcobj", obj);
		return "PurchaseRegistraion";
	}

	@PostMapping("/save")
	public String savePurchase(@ModelAttribute PurchaseOrder pcorder, RedirectAttributes redirect, Map map) {
		addDynbamicUiComponent(map);
		int id = service.savePurchaseOrder(pcorder);
		redirect.addFlashAttribute("savemsg", "Your Rigistartion Completed");
		return "redirect:registration";
	}

	@GetMapping("/all")
	public String getAllData(Map map) {
		List<PurchaseOrder> list = service.getAllPurchaseOrders();
		map.put("list", list);
		list.stream().forEach((data)->System.out.println(data.getStatus()));
		return "PurchaseData";
	}

	@GetMapping("/parts")
	public String showParts(@RequestParam Integer id, Map map) {
		PurchaseOrder ordobj = service.getOnePurchaseOrder(id);
		map.put("obj", ordobj);
		map.put("dtlobj", new PurchaseDtl());
		map.put("partidcode", partService.getPartIDAndCode());
		List<PurchaseDtl> dtl = service.getPurchaseDtlsByOrderid(id);
		map.put("dtllist", dtl);
		/*
		 * if (service.getCount(ordobj.getOrderId()) == 0) {
		 * service.updatestatus("Open", ordobj.getOrderId()); } else if
		 * (service.getCount(ordobj.getOrderId()) > 0) { service.updatestatus("Picking",
		 * ordobj.getOrderId()); }
		 */
		return "PurchaseOrderParts";
	}

	@PostMapping("/savedtl")
	public String saveDtl(@ModelAttribute PurchaseDtl dtl) {
		service.savepurchaseOrderDtl(dtl);
		service.updatestatus("Picking", dtl.getOrder().getOrderId());
		return "redirect:parts?id=" + dtl.getOrder().getOrderId();
	}

	@GetMapping("/delete")
	public String deleteDtl(@RequestParam Integer dtlId, @RequestParam Integer orderId,
			@RequestParam String orderCode) {
		service.deleteDtlById(dtlId);
	
      
		if (service.getCount(orderId) == 0) {
			service.updatestatus("Open", orderId);
		} /*
			 * else { service.updatestatus("Picking", orderId); }
			 */

		return "redirect:parts?id=" + orderId;
	}
	@GetMapping("/confirm")
	public String confirmOrder(@RequestParam Integer orderId) {
		service.updatestatus("Ordered", orderId);
		System.out.println("hello");
		return "redirect:parts?id=" + orderId;
	}
	@GetMapping("/generate")
	public String generateInvoice(@RequestParam Integer orderId) {
		service.updatestatus("Invoiced", orderId);
		System.out.println("hello");
		return "redirect:parts?id=" + orderId;
	}
	@GetMapping("/generateall")
	public String generateInvoiceToAll() {
		return "redirect:all";
	}
	@GetMapping("/printinvoice")
	public ModelAndView PrintInvoice(@RequestParam Integer orderId) {
		ModelAndView m=new ModelAndView();
		m.setView(new VendorInvoicePdfView());
		m.addObject("pc", service.getOnePurchaseOrder(orderId));
		m.addObject("dtl", service.getPurchaseDtlsByOrderid(orderId));
		System.out.println(service.getOnePurchaseOrder(orderId));
		System.out.println(service.getPurchaseDtlsByOrderid(orderId));
		return m;
	}
}
