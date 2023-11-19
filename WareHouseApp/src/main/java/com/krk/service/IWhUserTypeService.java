package com.krk.service;
import java.util.List;
import com.krk.model.Uom;
import com.krk.model.WhUserType;
public interface IWhUserTypeService {
	public Integer saveWhUserType(WhUserType whuser);
	public List<WhUserType> getAllWhUserType();
	public String deleteWhUserType(Integer id);
	public WhUserType getOneRecord(Integer id);

}
