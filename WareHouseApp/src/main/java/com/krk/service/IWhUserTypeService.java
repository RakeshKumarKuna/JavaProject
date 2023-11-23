package com.krk.service;
import java.util.List;
import com.krk.model.Uom;
import com.krk.model.WhUserType;
public interface IWhUserTypeService {
	public Integer saveWhUserType(WhUserType whUserType);
	public List<WhUserType> getAllWhUserTypes();
	public void updateWhUserType(WhUserType whUserType);
	public void deleteWhUserType(Integer id);
	public WhUserType getOneWhUserType(Integer id);
	public boolean isWhUserMailIdExist(String email);

}
