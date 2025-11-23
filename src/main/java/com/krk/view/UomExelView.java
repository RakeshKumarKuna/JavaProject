package com.krk.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.krk.model.Uom;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component("excel")
public class UomExelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			                                                       Workbook workbook, 
			                                                       HttpServletRequest request,
			                                                        HttpServletResponse response) throws Exception {
      List<Uom> uom=(List<Uom>)model.get("list");
      response.addHeader("Content-Disposition", "attachment;filename=UomData.xlsx");
	Sheet sheet=workbook.createSheet("Uom");
	setHeader(sheet);
	 setBody(sheet,uom);
	 
	}

	private void setBody(Sheet sheet, List<Uom> uom) {
		int count=1;
		for(Uom data:uom) {
		Row row =sheet.createRow(count++);
		row.createCell(0).setCellValue(data.getId());
		row.createCell(1).setCellValue(data.getUomType());
		row.createCell(2).setCellValue(data.getUomModel());
		row.createCell(3).setCellValue(data.getDescription());
		}
		
	}

	private void setHeader(Sheet sheet) {
		Row row =sheet.createRow(0);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("uomtype");
		row.createCell(2).setCellValue("uommodel");
		row.createCell(3).setCellValue("description");
		}
	
	

}
