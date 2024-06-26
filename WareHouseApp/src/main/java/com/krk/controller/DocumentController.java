package com.krk.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.krk.model.Document;
import com.krk.service.IDocumentService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;

	// 1. show Documents Upload page
	@GetMapping("/all")
	public String showDocs(Model model) {
		List<Object[]> list = service.getDocumentIdAndNames();
		model.addAttribute("list", list);
		return "Documents";
	}

	// 2. on click upload /form submit
	@PostMapping("/save")
	public String saveDoc(@RequestParam Integer fid, @RequestParam MultipartFile fob) {
		try {
			// create Model class object
			Document doc = new Document();
			doc.setDocId(fid);
			doc.setDocName(fob.getOriginalFilename());
			doc.setDocData(fob.getBytes());
			service.saveDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:all";
	}

	// 3. Document downloads
	@GetMapping("/download")
	public void downloadDoc(@RequestParam Integer id, HttpServletResponse resp) {
		// a. get data based on id
		Optional<Document> opt = service.getOneDocument(id);

		if (opt.isPresent()) {
			// b. read object
			Document doc = opt.get();

			// c. add Header Param
			resp.addHeader("Content-Disposition", "attachment;filename=" + doc.getDocName());

			// d. copy data //from --> to
			try {
				FileCopyUtils.copy(doc.getDocData(), resp.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
