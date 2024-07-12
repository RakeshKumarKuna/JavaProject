package com.krk.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.krk.model.PurchaseDtl;
import com.krk.model.PurchaseOrder;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class VendorInvoicePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=VendorInvoice.pdf");
		// creating elements
		document.open();
		Font font = new Font(Font.TIMES_ROMAN, 22, Font.BOLD, Color.BLUE);
		Paragraph para = new Paragraph("VENDOR INVOICE", font);
		para.setSpacingAfter(10.0f);
		para.setSpacingBefore(10.0f);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		PurchaseOrder pc = (PurchaseOrder) model.get("pc");
		List<PurchaseDtl> dtl = (List<PurchaseDtl>) model.get("dtl");
		Double finalCost = 0.0;
		for (PurchaseDtl dtls : dtl) {
			finalCost += dtls.getPart().getPartCost() * dtls.getQty();
		}
		PdfPTable header = new PdfPTable(4);
		header.addCell("VENDOR CODE");
		header.addCell(pc.getWhuserType().getUserCode());
		header.addCell("ORDER CODE");
		header.addCell(pc.getOrderCode());
		header.addCell("FINAL COST");
		header.addCell(String.valueOf(finalCost));
		header.addCell("SHIMPMENT CODE");
		header.addCell(pc.getShipmentType().getShipmentCode());
		document.add(header);
		
		//adding parts to the pdf
		PdfPTable dtls=new PdfPTable(4);
		dtls.addCell("Code");
		dtls.addCell("Cost");
		dtls.addCell("Quantity");
		dtls.addCell("Value");
		for (PurchaseDtl dt : dtl) {
          dtls.addCell(dt.getOrder().getOrderCode());
          dtls.addCell(dt.getPart().getPartCost()+"");
          dtls.addCell(dt.getQty()+"");
          dtls.addCell(dt.getPart().getPartCost()*dt.getQty()+"");
		}
		document.add(dtls);
		
		document.close();
	}

}
