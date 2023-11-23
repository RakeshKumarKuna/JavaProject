package com.krk.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krk.Charts.UomUtil;
import com.krk.Util.ShipmentTypeMailUtil;
import com.krk.model.WhUserType;
import com.krk.service.IWhUserTypeService;
@Controller
@RequestMapping("/WhUser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ShipmentTypeMailUtil mail;
	@Autowired
	private UomUtil util;
	@GetMapping("/register")
	public String registration() {
		return "WhUserTypeRegister";
	}
	 @PostMapping("/save")
	public String save(@ModelAttribute WhUserType type,RedirectAttributes flash) throws Exception
	{
		int res=service.saveWhUserType(type);
		flash.addFlashAttribute("msg","Registraion Completed With ID :"+res);
		mail.sendemail(type.getUserEmail(), "WareHouse", "Your Order Completed with id:"+res);
        return "redirect:register";
	}
	}
