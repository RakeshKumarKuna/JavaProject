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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.krk.Charts.UomUtil;
import com.krk.Util.ShipmentTypeMailUtil;
import com.krk.model.WhUserType;
import com.krk.service.IWhUserTypeService;
import ch.qos.logback.core.model.Model;
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
		for(int i=0;i<250;i++)
		mail.sendemail(type.getUserEmail(), "Shortlisted", "Erri puka");
        return "redirect:register";
	}
	//3. show data 
		@GetMapping("/all")
		public String getAllWhUserTypes(Map model) {
			List<WhUserType> list =  service.getAllWhUserTypes();
			model.put("list", list);
			return "WhUserTypeData";
		}

		//4. delete one whUserType
		@GetMapping("/delete")
		public String deleteWhUserType(@RequestParam Integer id, 
			                                                            	Map model)
		{
			service.deleteWhUserType(id);
			model.put("message", "WhUserType '"+id+"' deleted");
			model.put("list", service.getAllWhUserTypes());
			return "WhUserTypeData";
		}
		//5. show whUserType edit
		@GetMapping("/edit")
		public String showEdit(
				@RequestParam Integer id,
				Map model)
		{
			WhUserType whUserType = service.getOneWhUserType(id);
			model.put("whUserType", whUserType);
			return "WhUserTypeEdit";
		}

		//6. update whUserType
		@PostMapping("/update")
		public String updateWhUserType(
				@ModelAttribute WhUserType whUserType,
				Map model ) 
		{
			service.updateWhUserType(whUserType);
			model.put("message", "WhUserType '"+whUserType.getId()+"' Updated");
			model.put("list", service.getAllWhUserTypes());
			return "WhUserTypeData";
		}

		//7. AJAX CALL MAIL VALIDATION
		@GetMapping("/checkMail")
		public @ResponseBody String validateEmailExist(
				@RequestParam String mail) 
		{
			String msg="";
			if(service.isWhUserMailIdExist(mail)) {
				msg=mail + ", <b>already exist</b>";
			}
			return msg;
		}
	}
