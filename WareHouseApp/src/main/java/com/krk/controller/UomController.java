package com.krk.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krk.model.Uom;
import com.krk.service.IUomService;
import com.krk.service.impl.IUomServiceImpl;

@Controller
@RequestMapping("/")
public class UomController {
	@Autowired
	private IUomService ser;
	/**
	 * 1.Returning the Home Page
	 * @return Home page
	 */
	@GetMapping("/")
	public String home() {
		return "home";
	}
	/**
	 * 2.Loading the registration Page
	 * @return registraion form registration.html
	 */
    @GetMapping("/reg")
	public String showReg() {
		return "registration";
	}
    /**
     * 3.Saving data enter in the UI form
     * @param uom object data
     * @param map is to send the result to ui page
     * @return  regsave page == conformartion messeage to client
     */
    @PostMapping("/save")
    public String save(@ModelAttribute Uom uom,Map map ) {
    	Integer id=ser.saveUom(uom);
    	String result="Uom saved with id "+id;
    	map.put("val", result);
    	//map.put("data", ser.getAllUoms());
    	return "regsave";
    }
    /**
     * Displaying the all  data
     * @param uom object
     * @param map to set the list data to ui
     * @return resultdata.html
     */
    @GetMapping("/getdata")
    public String getAllUoms(@ModelAttribute("uom") Uom uom,Map map) {
    	map.put("data", ser.getAllUoms());
    	return "resultdata";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id,Map map) {
    	String res=ser.deleteUom(id);
    	map.put("deleteres", res);
    	return "Deletedmsg";
    }
}
