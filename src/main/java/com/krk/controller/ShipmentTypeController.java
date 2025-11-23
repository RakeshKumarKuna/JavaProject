package com.krk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krk.model.ShipmentType;
import com.krk.service.IShipmentTypeService;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	// 1. show Register page
	@GetMapping("/register")
	public String showReg() {
		return "ShipmentTypeRegister";
	}

	// 2. save
	@PostMapping("/save")
	public String save(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		
		String message = "Registration Completed with id of '" + id;
		model.addAttribute("message", message);
		return "ShipmentTypeRegister";
	}

	// 3. display all
	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	// 4. delete by id
	@GetMapping("/delete")
	public String deleteOne(@RequestParam Integer id, Model model) {
		service.deleteShipmentType(id);
		model.addAttribute("message", "ShipmentType '" + id + "' deleted");
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	// 5. show edit
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Map model) {
		model.put("shipmentType",service.getOneShipmentType(id));
		return "ShipmentTypeEdit";
	}

	// 6. update
	@PostMapping("/update")
	public String doUpdate(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateShipmentType(shipmentType);
		model.addAttribute("message", "ShipmentType '" + shipmentType.getId() + "' Updated");
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	@GetMapping("/reportpdf")
	public String pdfdata(Map map) {
		map.put("list", service.getAllShipmentTypes());
			return "shipmentpdf";
	}
	
	@GetMapping("/reportexcel")
	public String exceldata(Map map) {
		map.put("list", service.getAllShipmentTypes());
			return "shipmentexcel";
	}

}