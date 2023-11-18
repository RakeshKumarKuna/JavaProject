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

import com.krk.Charts.UomUtil;
import com.krk.model.Uom;
import com.krk.service.IUomService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/")
public class UomController {
	@Autowired
	private IUomService ser;
	@Autowired
	private UomUtil util;
	@Autowired
	private ServletContext context;
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
    /**
     * 
     * @param id to gat id of the record
     * @param map to sending the result msg
     * @return Deletemsg.html
     */
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id,Map<String, String> map) {
    	String res=ser.deleteUom(id);
    	map.put("deleteres", res);
    	return "Deletedmsg";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Integer id,Map map) {
    System.out.println("edit enterd");
    		Uom uom=ser.getOneRecord(id);
    	map.put("uom", uom);
    	return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Uom uom,Map map) {
    	int id=ser.saveUom(uom);
    	String result="Detailes Updated with id "+id;
    	map.put("result",result);
    	return "update";
    }
    @GetMapping("/excel")
    public String exceldata(Map map) {
    	map.put("list", ser.getAllUoms());
    	return "excel";
    }
    @GetMapping("/pdf")
    public String pdfdata(Map map) {
    	map.put("list", ser.getAllUoms());
    	return "pdf";
    }

  	@GetMapping("/validate")
  	public @ResponseBody String validateModel(
  			@RequestParam String model)
  	{
  		String message = "";
  		if(ser.isUomModelExist(model)) {
  			message = "Uom Model '"+model+"' already exist";
  		}
  		
  		return message;
  	}
  	@GetMapping("/piechart")
  	public String charts() {
  	List<Object[]> data=	ser.getUomTypeAndCount();
  		util.generatePieChart(context.getRealPath("/"), data);
  		util.generateBarChart(context.getRealPath("/"), data);
  		System.out.println(context.getRealPath("/"));
  		return "UomCharts";
  	}
    
}
