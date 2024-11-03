package com.krk.rest;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krk.model.Uom;
import com.krk.service.IUomService;

@RestController
@RequestMapping("rest/uom")
public class UomRest {
	@Autowired
	private IUomService ser;

	@GetMapping("/getdata")
	public ResponseEntity<?> getAllUoms() {
		List<Uom> response = ser.getAllUoms();
		ResponseEntity<List<Uom>> res = new ResponseEntity<List<Uom>>(response, HttpStatus.OK);
		return res;
	}
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Uom uom) {
		Integer id = ser.saveUom(uom);
		String result = "Uom saved with id " + id;
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
}
