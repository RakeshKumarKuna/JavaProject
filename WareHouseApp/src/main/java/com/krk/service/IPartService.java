package com.krk.service;

import java.util.List;
import java.util.Map;

import com.krk.model.Part;

public interface IPartService {

	public Integer savePart(Part part);
	public List<Part> getAllParts();
	public void updatePart(Part part);
	public void deletePart(Integer id);
	public Part getOnePart(Integer id);
	public Map<Integer,String> getPartIDAndCode();
	
}
