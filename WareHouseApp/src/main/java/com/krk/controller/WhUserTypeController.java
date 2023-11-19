package com.krk.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krk.model.WhUserType;
import com.krk.service.IWhUserTypeService;
@Controller
@RequestMapping("/WhUser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@GetMapping("/register")
	public String registration() {
		return "WhUserTypeRegister";
	}
	 @PostMapping("/save")
	public String save(@ModelAttribute WhUserType type,RedirectAttributes flash)
	{
		int res=service.saveWhUserType(type);
		flash.addFlashAttribute("msg","Registraion Completed With ID :"+res);
        return "redirect:register";
	}
	}
